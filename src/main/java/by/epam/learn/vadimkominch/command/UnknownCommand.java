package by.epam.learn.vadimkominch.command;

import jakarta.servlet.http.HttpServletRequest;

public class UnknownCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        System.out.println("Unknown");
        return null;
    }
}
