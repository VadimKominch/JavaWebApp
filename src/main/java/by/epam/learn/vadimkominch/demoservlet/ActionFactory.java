package by.epam.learn.vadimkominch.demoservlet;

import by.epam.learn.vadimkominch.command.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Class provided to generate command from request. Use object of @{HttpServletRequest}.
 */
public class ActionFactory {

    public Command defineCommand(HttpServletRequest request) {
        Command command;
        String requestPath = request.getServletPath();
        switch (requestPath) {
            case "/login":
                command = new LoginCommand();
                break;
            case "/logout":
                command = new LogoutCommand();
                break;
            case "/register":
                command = new RegistrationCommand();
                break;
            case "/main":
                command = new GetMainPageCommand();
                break;
            case "/get_page":
                command = new GetPageCommand();
                break;
            case "/add_adv":
                command = new AddAdvertismentCommand();
                break;
            default:
                command = new UnknownCommand();
        }
        return command;
    }
}
