package by.epam.learn.vadimkominch.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String[] params = request.getServletPath().substring(1).split("/");
        if(params.length == 4&&params[0].equals("admin")&&params[1].equals("login")&&params[2].equals("password")) {
                request.getRequestDispatcher("/get_page?page=admin").forward(request,response);
        } else {
                response.sendRedirect(request.getRequestURL().toString().replaceFirst(request.getRequestURI(),request.getContextPath()));
        }
    }

    @Override
    public void destroy() {

    }
}
