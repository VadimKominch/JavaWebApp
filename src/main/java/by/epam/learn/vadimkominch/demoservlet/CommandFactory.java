package by.epam.learn.vadimkominch.demoservlet;

import by.epam.learn.vadimkominch.command.*;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    Map <String, Command> commandMap;

    private CommandFactory instance = new CommandFactory();

    private CommandFactory() {
        this.commandMap = new HashMap<String,Command>() {{
            put("/login",new LoginCommand());
            put("/logout",new LogoutCommand());
            put("/get_page",new GetPageCommand());
            put("/main",new GetMainPageCommand());

        }};
    }

    public CommandFactory getInstance() {
        return instance;
    }

    public Command getCommand(String url) {
        return commandMap.get(url);
    }


}
