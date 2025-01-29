package by.epam.learn.vadimkominch.connectionpool;

import by.epam.learn.vadimkominch.constant.PathConstant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;


/**
 * database connection provider class. Initialize custom connectino pool from properties or default pool size.
 */
public class ConnectionPool {
    private Queue<Connection> connectionList;
    private static final Logger LOGGER = LogManager.getLogger(ConnectionPool.class);
    private Properties databaseProperties;

    public static final int DEFAULT_POOL_SIZE = 10;

    private ConnectionPool(){
        loadProperties();
        initConnectionPool();
        /* Open connections*/
        LOGGER.debug("Connection Pool is created. CurrentPoolSize = {}", connectionList.size());
    }

    private void loadProperties() {
        try (InputStream in = Thread
                .currentThread()
                .getContextClassLoader()
                .getResourceAsStream(PathConstant.SECOND_DATABASE_RESOURCE_PATH)) {
            databaseProperties = new Properties();
            databaseProperties.load(in);
        } catch (IOException e) {
            LOGGER.error("No config file is present");
            System.exit(1);
        }
    }

    public void releaseConnection(Connection connection) {
        connectionList.add(connection);
    }

    public Connection getConnection() {
        int size = connectionList.size();
        if (size == 0) {
            return createConnection();
        } else {
            return connectionList.poll();
        }
    }

    private Connection createConnection() {
        try {
            String url = databaseProperties.getProperty(PathConstant.KEY_FOR_URI);
            String username = databaseProperties.getProperty(PathConstant.KEY_FOR_USERNAME);
            String password = databaseProperties.getProperty(PathConstant.KEY_FOR_PASSWORD);
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
        return null;
    }

    private void initConnectionPool() {
        int poolSize;
        try {
            poolSize = Integer.parseInt(databaseProperties.getProperty(PathConstant.KEY_FOR_POOL_SIZE));
        } catch (NumberFormatException e) {
            LOGGER.warn("No value for pool size is present, default pool size is {}",DEFAULT_POOL_SIZE);
            poolSize = DEFAULT_POOL_SIZE;
        }
        connectionList = new ArrayBlockingQueue<>(poolSize);
        for (int i = 0; i < poolSize; i++) {
            Connection connection = createConnection();
            connectionList.add(connection);
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
