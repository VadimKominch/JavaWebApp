package by.epam.learn.vadimkominch.command;

import by.epam.learn.vadimkominch.check.LoginAndPasswordCheck;
import by.epam.learn.vadimkominch.repository.CredentialsRepository;
import by.epam.learn.vadimkominch.repository.UserRepository;
import by.epam.learn.vadimkominch.entity.Credentials;
import by.epam.learn.vadimkominch.entity.User;

import by.epam.learn.vadimkominch.service.UserService;
import by.epam.learn.vadimkominch.utils.HashUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginCommand implements Command {
    private final LoginAndPasswordCheck checker;
    private final CredentialsRepository credentialsRepository;
    private final UserService userService;

    public LoginCommand() {
        this(new LoginAndPasswordCheck(), CredentialsRepository.getInstance(), UserService.getInstance());
    }

    public LoginCommand(LoginAndPasswordCheck checker, CredentialsRepository credentialsRepository, UserService userService) {
        this.checker = checker;
        this.credentialsRepository = credentialsRepository;
        this.userService = userService;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if("GET".equals(request.getMethod())) {
            request.getRequestDispatcher("jsp/loginpage.jsp").forward(request,response);
            return;
        }
        HttpSession session = request.getSession(true);
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if (checker.checkLoginIsNullable(login) && checker.checkPasswordIsNullable(password)) {
            Credentials credentials = credentialsRepository.getByLogin(login);
            if (
                    credentials != null &&
                            credentials.getLogin().getValue().equals(login) &&
                    HashUtils.checkPass(password, credentials.getPassword().getValue())
            ) {
                User user = userService.getOne(credentials.getUserId().getValue()); // not null if credentials with one-to-one relationship
                setAttributeIfMissing(session, "user", user);

                response.sendRedirect("main");
                return;
            }
        }
        // sendRedirect for success redirect
        // forward for fail
        request.getRequestDispatcher("jsp/loginpage.jsp").forward(request, response);
    }

    public <T> void setAttributeIfMissing(HttpSession session, String attrName, T attrValue) {
        if(session.getAttribute(attrName) == null) {
            session.setAttribute(attrName, attrValue);
        }
    }
}
