package by.epam.learn.vadimkominch.command;

import by.epam.learn.vadimkominch.entity.ProfileInfoApiModel;
import by.epam.learn.vadimkominch.utils.JsonReaderUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GetProfileInfoCommand implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if("PUT".equals(request.getMethod())) {
            ProfileInfoApiModel body = JsonReaderUtils.readFromHttpRequest(request, ProfileInfoApiModel.class);
            System.out.println(body);
        }
        response.sendRedirect("jsp/profile_info.jsp");
    }
}
