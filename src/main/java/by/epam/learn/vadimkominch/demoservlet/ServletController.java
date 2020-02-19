package by.epam.learn.vadimkominch.demoservlet;

import by.epam.learn.vadimkominch.command.Command;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletController extends HttpServlet {
    private static final Logger LOGGER = LogManager.getLogger(ServletController.class);
    private ActionFactory actionFactory;

    @Override
    public void init() throws ServletException {
        super.init();
        actionFactory = new ActionFactory();
        LOGGER.info(getClass().getSimpleName() + " has been initialized.");
    }

    @Override
    public void destroy() {
        super.destroy();
        LOGGER.info(getClass().getSimpleName() + " has been destroyed.");
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
