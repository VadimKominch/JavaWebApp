package by.epam.learn.vadimkominch.command;

import javax.servlet.http.HttpServletRequest;

public class GetRegisterPageCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return "jsp/register.jsp";
    }
}
