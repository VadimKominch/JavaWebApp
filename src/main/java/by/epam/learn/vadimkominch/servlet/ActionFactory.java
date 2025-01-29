package by.epam.learn.vadimkominch.servlet;

import by.epam.learn.vadimkominch.command.*;

import by.epam.learn.vadimkominch.command.advertisement.*;
import by.epam.learn.vadimkominch.command.message.GetConversationPageCommand;
import by.epam.learn.vadimkominch.command.message.GetMessageHistoryCommand;
import by.epam.learn.vadimkominch.command.message.SendMessageCommand;
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
        System.out.println(requestPath);
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
            case "/profile-info":
                command = new GetProfileInfoCommand();
                break;
            case "/advertisement":
                command = new AddAdvertismentCommand();
                break;
            case "/advertisements":
                command = new GetUserAdvertisementsCommand();
                break;
            case "/categories":
                command = new GetCategoriesCommand();
                break;
            case "/get_adv":
                command = new GetAdvertismentCommand();
                break;
            case "/edit_adv":
                command = new EditAdvertisementCommand();
                break;
            case "/edit_usr":
                command = new EditNickNameCommand();
                break;
            case "/delete_adv":
                command = new DeleteAdvertismentCommand();
                break;
            case "/conversation":
                command = new GetConversationPageCommand();
                break;
            case "/message":
                command = new SendMessageCommand();
                break;
            case "/message-history":
                command = new GetMessageHistoryCommand();
                break;
            default:
                command = new UnknownCommand();
        }
        return command;
    }
}
