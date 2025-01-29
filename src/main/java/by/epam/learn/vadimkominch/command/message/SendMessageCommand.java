package by.epam.learn.vadimkominch.command.message;

import by.epam.learn.vadimkominch.command.Command;
import by.epam.learn.vadimkominch.entity.MessageApiModel;
import by.epam.learn.vadimkominch.entity.User;
import by.epam.learn.vadimkominch.service.MessageService;
import by.epam.learn.vadimkominch.utils.JsonReaderUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class SendMessageCommand implements Command {
    private final MessageService messageService;

    public SendMessageCommand() {
        this(MessageService.getInstance());
    }

    public SendMessageCommand(MessageService messageService) {
        this.messageService = messageService;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        var message = JsonReaderUtils.readFromHttpRequest(request, MessageApiModel.class);
        messageService.saveMessage(message);
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().write("");
    }
}
