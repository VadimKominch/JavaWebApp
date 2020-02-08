package by.epam.learn.vadimkominch.connectionpool;

import by.epam.learn.vadimkominch.Constant.PathConstant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * Class which provides database connection. Locks used.
 */
public class ConnectionPool {
    //add logger
    private Lock lock;
    private List<Connection> connectionList;//replace by BlockingQueue
    private static final Logger LOGGER = LogManager.getLogger(ConnectionPool.class);

    private ConnectionPool() {
        //add connection to database table
        connectionList = new ArrayList<>();
        lock = new ReentrantLock(true);
        initConnectionPool();
        /* Open connections*/
        LOGGER.debug("Connection Pool is created. CurrentPoolSize = " + connectionList.size());
    }

    public void releaseConnection(Connection connection) {
        try {
            lock.lock();
            connectionList.add(connection);
        } finally {
            lock.unlock();
        }
    }

    public Connection getConnection() {
        try {
            lock.lock();
            int size = connectionList.size();
            if (size == 0) {
                Connection connection = createConnection();
                return connection;
            } else {
                return connectionList.get(size - 1);
            }
        } finally {
            lock.unlock();
        }
    }

    /**
     * Method for creating connections. Use data from resources files
     *
     * @return
     */
    private Connection createConnection() {
        Properties properties = new Properties();
        InputStream in = null;
        try {
//            ClassLoader classLoader = getClass().getClassLoader();
//            URL resource = classLoader.getResource(PathConstant.SECOND_DATABASE_RESOURCE_PATH);
//            File file = new File(resource.getFile());
//            in = new FileInputStream(file);
            in = Thread.currentThread().getContextClassLoader().getResourceAsStream(PathConstant.SECOND_DATABASE_RESOURCE_PATH);
            properties.load(in);
            String driver = properties.getProperty(PathConstant.KEY_FOR_DRIVER);
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url = properties.getProperty(PathConstant.KEY_FOR_URI);
            String username = properties.getProperty(PathConstant.KEY_FOR_USERNAME);
            String password = properties.getProperty(PathConstant.KEY_FOR_PASSWORD);
            Connection connection = DriverManager.getConnection(url, username, password);
            return connection;
        } catch (InstantiationException | IllegalAccessException | SQLException | ClassNotFoundException | IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    private void initConnectionPool() {
        Properties properties = new Properties();
        InputStream in = null;
        int poolSize;
        try {
//            ClassLoader classLoader = getClass().getClassLoader();(Thread.currentThread().getContextClassLoader().
//            URL resource = classLoader.getResource(PathConstant.SECOND_DATABASE_RESOURCE_PATH);
//            File file = new File(resource.getFile());
//            ClassLoader classloader = Thread.currentThread().getContextClassLoader().getResourceAsStream(PathConstant.SECOND_DATABASE_RESOURCE_PATH);
            in = Thread.currentThread().getContextClassLoader().getResourceAsStream(PathConstant.SECOND_DATABASE_RESOURCE_PATH);
            //in = new FileInputStream(PathConstant.DATABASE_RESOURCE_PATH);
            //in = getClass().getClassLoader().getResourceAsStream(PathConstant.DATABASE_RESOURCE_PATH);
            //in = new FileInputStream(file);
            properties.load(in);
            try {
                poolSize = Integer.parseInt(properties.getProperty(PathConstant.KEY_FOR_POOL_SIZE));
            } catch (NumberFormatException e) {
                //logger
                poolSize = 10;
            }
            for (int i = 0; i < poolSize; i++) {
                Connection connection = createConnection();
                if (connection == null) {
                    throw new NullPointerException();
                } else {
                    connectionList.add(connection);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //TODO
    //increase amount  of connections
    //decrease amount of connections

    private static class Holder {
        private static final ConnectionPool INSTANCE = new ConnectionPool();
    }

    public static ConnectionPool getInstance() {
        return Holder.INSTANCE;
    }


}
