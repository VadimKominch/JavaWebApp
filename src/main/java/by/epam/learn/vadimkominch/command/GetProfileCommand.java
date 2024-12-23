package by.epam.learn.vadimkominch.command;

import by.epam.learn.vadimkominch.entity.User;
import by.epam.learn.vadimkominch.entity.dao.Advertisement;
import by.epam.learn.vadimkominch.service.AdvertisementService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

public class GetProfileCommand implements Command{

    private final AdvertisementService adsService;

    public GetProfileCommand() {
        adsService = AdvertisementService.getInstance();
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        User user = (User) request.getSession().getAttribute("user");
        List<Advertisement> userAds = adsService.getUserAdvertisements(user.getId().getValue());
        if("GET".equals(request.getMethod())) {
            response.sendRedirect("jsp/profile.jsp");
        } else {
            response.sendRedirect("main");
        }
    }
}
