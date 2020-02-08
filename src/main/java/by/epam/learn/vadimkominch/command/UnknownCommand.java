package by.epam.learn.vadimkominch.command;

import javax.servlet.http.HttpServletRequest;

public class UnknownCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return null;
    }
}
