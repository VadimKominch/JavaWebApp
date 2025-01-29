package by.epam.learn.vadimkominch.command;

import by.epam.learn.vadimkominch.entity.Credentials;
import by.epam.learn.vadimkominch.entity.RegisterUserApiModel;
import by.epam.learn.vadimkominch.entity.User;
import by.epam.learn.vadimkominch.service.UserService;
import by.epam.learn.vadimkominch.utils.HashUtils;

import by.epam.learn.vadimkominch.utils.JsonReaderUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegistrationCommand implements Command {
    private final UserService userService;

    public RegistrationCommand() {
        this(UserService.getInstance());
    }

    public RegistrationCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String method = request.getMethod();
        if("GET".equals(method)) {
             request.getRequestDispatcher("jsp/register.jsp").forward(request,response);
            return;
        }
        RegisterUserApiModel model = JsonReaderUtils.readFromHttpRequest(request, RegisterUserApiModel.class);
        User user = extractUser(model);
        Credentials credentials = extractCredentials(model);
        if(userService.registerUser(user, credentials)) {
            response.sendRedirect("main");
        }
    }

    private User extractUser(RegisterUserApiModel model) {
        User user = new User();
        user.setFirstName(model.getFirstName());
        user.setLastName(model.getLastName());
        user.setNickName(model.getNickName());
        return user;
    }

    private Credentials extractCredentials(RegisterUserApiModel model) {
        Credentials credentials = new Credentials();
        credentials.setEmail(model.getEmail());
        credentials.setLogin(model.getLogin());
        credentials.setPassword(HashUtils.hash(model.getPassword()));
        return credentials;
    }
}
