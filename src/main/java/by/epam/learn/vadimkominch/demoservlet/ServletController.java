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

    @Override
    public void init() throws ServletException {
        super.init();
        actionFactory = new ActionFactory();
        LOGGER.info("{} has been initialized.", getClass().getSimpleName());
    }

    @Override
    public void destroy() {
        super.destroy();
        LOGGER.info("{} has been destroyed.", getClass().getSimpleName());
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setStatus(200);
        LOGGER.info("request for login page Servlet has been handled");
        handleRequest(request, response);
    }

    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getServletPath());
        Command command = actionFactory.defineCommand(request);
        String url = command.execute(request);
        request.getRequestDispatcher(url).forward(request, response);
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request, response);
    }
}
