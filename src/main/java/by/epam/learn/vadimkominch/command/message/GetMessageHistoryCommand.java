package by.epam.learn.vadimkominch.command.message;

import by.epam.learn.vadimkominch.command.Command;
import by.epam.learn.vadimkominch.entity.ConversationHistoryModel;
import by.epam.learn.vadimkominch.entity.MessageApiModel;
import by.epam.learn.vadimkominch.service.MessageService;
import by.epam.learn.vadimkominch.utils.JsonReaderUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

public class GetMessageHistoryCommand implements Command {
    private final MessageService messageService;

    public GetMessageHistoryCommand() {
        this(MessageService.getInstance());
    }

    public GetMessageHistoryCommand(MessageService messageService) {
        this.messageService = messageService;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ConversationHistoryModel model = JsonReaderUtils.readFromHttpRequest(request, ConversationHistoryModel.class);
        List<MessageApiModel> conversationHistory = messageService.getConversationHistory(model);
        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType("application/json");
        response.getWriter().write(JsonReaderUtils.writeToJsonString(conversationHistory));
    }
}
