package by.epam.learn.vadimkominch.command;

import javax.servlet.http.HttpServletRequest;

public class CommandHandler {
    //inside request dispatcher filter info and get it
    //request.getRequestDispatcher("jsp/users.jsp").forward(request, response);
    public String handle(Command command,HttpServletRequest request) {
        String requestedUrl = command.execute(request);
        return requestedUrl;
    }
}
