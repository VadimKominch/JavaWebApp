package by.epam.learn.vadimkominch.demoservlet;

import by.epam.learn.vadimkominch.command.Command;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletController extends HttpServlet {
    private static final Logger LOGGER = LogManager.getLogger(ServletController.class);
    private ActionFactory actionFactory;
    private CommandFactory commandFactory;

    @Override
    public void init() throws ServletException {
        super.init();
        actionFactory = new ActionFactory();
        commandFactory = CommandFactory.getInstance();
        LOGGER.info("{} has been initialized.", getClass().getSimpleName());
    }

    @Override
    public void destroy() {
        super.destroy();
        LOGGER.info("{} has been destroyed.", getClass().getSimpleName());
    }


    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Command command = actionFactory.defineCommand(request);
        Command command2 = commandFactory.getCommand(request.getServletPath());
        System.out.println();
        try {
            command.execute(request, response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        handleRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        handleRequest(request, response);
    }
}
