package by.epam.learn.vadimkominch.command.message;

import by.epam.learn.vadimkominch.command.Command;
import by.epam.learn.vadimkominch.entity.MessageApiModel;
import by.epam.learn.vadimkominch.entity.User;
import by.epam.learn.vadimkominch.entity.dao.Conversation;
import by.epam.learn.vadimkominch.service.ConversationService;
import by.epam.learn.vadimkominch.service.MessageService;
import by.epam.learn.vadimkominch.service.UserService;
import by.epam.learn.vadimkominch.utils.HashUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.util.List;

public class GetConversationPageCommand implements Command {

    private final ConversationService conversationService;
    private final MessageService messageService;

    public GetConversationPageCommand() {
        this(ConversationService.getInstance(), MessageService.getInstance());
    }

    public GetConversationPageCommand(ConversationService conversationService, MessageService messageService) {
        this.conversationService = conversationService;
        this.messageService = messageService;
    }

    public static final String TARGET_ID_ATTRIBUTE = "target_id";
    public static final String CONVERSATION_ATTRIBUTE = "conversation_id";
    public static final String CONVERSATION_LIST_ATTRIBUTE = "conversation_list";
    public static final String CONVERSATION_MESSAGES_ATTRIBUTE = "messages";
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if(request.getParameter(TARGET_ID_ATTRIBUTE) != null) {
            Integer targetId = Integer.parseInt(request.getParameter(TARGET_ID_ATTRIBUTE));
            Conversation conversation = conversationService.getByCreatorAndTargetUserId(user.getId().getValue(), targetId);
            int convId;
            if (conversation == null) {
                conversation = new Conversation();
                conversation.setHash(HashUtils.hash(String.valueOf(targetId).concat(user.getId().getValue().toString())));
                conversation.setFirst(user.getId().getValue());
                conversation.setSecond(targetId);
                convId = conversationService.save(conversation);
            } else {
                convId = conversation.getId().getValue();
            }


            List<MessageApiModel> conversationMessages = messageService.getConversationMessages(convId);

            request.setAttribute(CONVERSATION_ATTRIBUTE, conversation.getId().getValue());
            request.setAttribute(CONVERSATION_MESSAGES_ATTRIBUTE, conversationMessages);
            request.setAttribute(TARGET_ID_ATTRIBUTE, targetId);
        }
        List<Conversation> convList = conversationService.getForUser(user.getId().getValue());

        request.setAttribute(CONVERSATION_LIST_ATTRIBUTE, convList);
        request.getRequestDispatcher("jsp/chat.jsp").forward(request,response);
    }
}
