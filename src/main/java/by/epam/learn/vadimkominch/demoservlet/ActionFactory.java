package by.epam.learn.vadimkominch.demoservlet;

import by.epam.learn.vadimkominch.command.*;

import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class provided to generate command from request. Use object of @{HttpServletRequest}.
 */
public class ActionFactory {

    Logger log = LogManager.getLogger(ActionFactory.class);

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
            case "/profile":
                command = new GetProfileCommand();
                break;
            case "/get_page":
                command = new GetPageCommand();
                break;
            case "/advertisement":
                command = new AddAdvertismentCommand();
                break;
            case "/categories":
                command = new GetCategoriesCommand();
                break;
            case "/edit_adv":
                command = new ModifyAdvertismentCommand();
                break;
            case "/delete_adv":
                command = new DeleteAdvertismentCommand();
                break;
            default:
                command = new UnknownCommand();
        }
        return command;
    }
}
