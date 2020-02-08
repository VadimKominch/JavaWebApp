package by.epam.learn.vadimkominch.command;

import javax.servlet.http.HttpServletRequest;

public class LogoutCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        request.getSession().invalidate();
        return "jsp/mainpage.jsp";
    }
}
