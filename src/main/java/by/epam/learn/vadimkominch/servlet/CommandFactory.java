package by.epam.learn.vadimkominch.servlet;

import by.epam.learn.vadimkominch.command.*;
import by.epam.learn.vadimkominch.command.advertisement.GetAdvertismentCommand;
import by.epam.learn.vadimkominch.command.advertisement.GetUserAdvertisementsCommand;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    Map <String, Command> commandMap;

    private static final CommandFactory instance = new CommandFactory();
    private Command defaultCommand;
    private CommandFactory() {
        this.commandMap = new HashMap<>() {{
            put("/login", new LoginCommand());
            put("/logout", new LogoutCommand());
            put("/main", new GetMainPageCommand());
            put("/register", new RegistrationCommand());
            put("/advertisements", new GetUserAdvertisementsCommand());
            put("/profile", new GetProfileCommand());
            put("/profile-info", new GetProfileInfoCommand());
            put("/get-adv", new GetAdvertismentCommand());
            put("/edit-adv", new EditNickNameCommand());
        }};
        defaultCommand = new UnknownCommand();
    }

    public static CommandFactory getInstance() {
        return instance;
    }

    public Command getCommand(String url) {
        return commandMap.getOrDefault(url, defaultCommand);
    }


}
