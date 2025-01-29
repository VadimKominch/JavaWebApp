package by.epam.learn.vadimkominch.command.advertisement;

import by.epam.learn.vadimkominch.command.Command;
import by.epam.learn.vadimkominch.entity.AdvertisementApiModel;
import by.epam.learn.vadimkominch.entity.User;
import by.epam.learn.vadimkominch.service.AdvertisementService;
import by.epam.learn.vadimkominch.utils.JsonReaderUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EditAdvertisementCommand implements Command {

    private final AdvertisementService advertisementService;

    public EditAdvertisementCommand() {
        this(AdvertisementService.getInstance());
    }

    public EditAdvertisementCommand(AdvertisementService advertisementService) {
        this.advertisementService = advertisementService;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        AdvertisementApiModel adsModel = JsonReaderUtils.readFromHttpRequest(request, AdvertisementApiModel.class);
        User user = (User)request.getSession().getAttribute("user");

        advertisementService.updateAdvertisement(adsModel, user);
        response.sendRedirect("/profile");
    }
}
