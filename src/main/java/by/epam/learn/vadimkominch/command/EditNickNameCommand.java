package by.epam.learn.vadimkominch.command;

import by.epam.learn.vadimkominch.entity.NickNameUpdateModel;
import by.epam.learn.vadimkominch.service.UserService;
import by.epam.learn.vadimkominch.utils.JsonReaderUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EditNickNameCommand implements Command{

    private final UserService userService;


    public EditNickNameCommand() {
        this(UserService.getInstance());
    }

    public EditNickNameCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        NickNameUpdateModel model = JsonReaderUtils.readFromHttpRequest(request, NickNameUpdateModel.class);
        userService.updateUser(model);
        response.sendRedirect("main");
    }
}
