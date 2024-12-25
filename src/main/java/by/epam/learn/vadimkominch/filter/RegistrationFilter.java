package by.epam.learn.vadimkominch.filter;


import by.epam.learn.vadimkominch.command.Command;
import by.epam.learn.vadimkominch.demoservlet.ActionFactory;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


public class RegistrationFilter implements Filter {
    private String filterPath;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        filterPath = "jsp/mainpage.jsp";
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        System.out.println("1");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        ActionFactory factory = new ActionFactory();
        Command command = factory.defineCommand(request);
//        response.sendRedirect(filterPath);
        //request.getRequestDispatcher(filterPath).forward(request,response);

        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
