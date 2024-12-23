package by.epam.learn.vadimkominch.command;

import by.epam.learn.vadimkominch.entity.Credentials;
import by.epam.learn.vadimkominch.entity.User;
import by.epam.learn.vadimkominch.service.UserService;
import by.epam.learn.vadimkominch.utils.HashUtils;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegistrationCommand implements Command {
    private final UserService userService;

    public RegistrationCommand() {
        userService = UserService.getInstance();
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String method = request.getMethod();
        if("GET".equals(method)) {
             request.getRequestDispatcher("jsp/register.jsp").forward(request,response);
            return;
        }
        User user = extractUser(request);
        Credentials credentials = extractCredentials(request);
        if(userService.registerUser(user, credentials)) {
            response.sendRedirect("main");
        }
    }

    private User extractUser(HttpServletRequest request) {
        User user = new User();
        user.setFirstName(request.getParameter("firstname"));
        user.setLastName(request.getParameter("lastname"));
        user.setNickName(request.getParameter("nickName"));
        return user;
    }

    private Credentials extractCredentials(HttpServletRequest request) {
        Credentials credentials = new Credentials();
        credentials.setEmail(request.getParameter("email"));
        credentials.setLogin(request.getParameter("login"));
        credentials.setPassword(HashUtils.hash(request.getParameter("password")));
        return credentials;
    }
}
