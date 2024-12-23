package by.epam.learn.vadimkominch.demoservlet;

import by.epam.learn.vadimkominch.command.*;

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
            put("/get_page", new GetPageCommand());
            put("/main", new GetMainPageCommand());
            put("/register", new RegistrationCommand());
            put("/profile", new GetProfileCommand());
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
