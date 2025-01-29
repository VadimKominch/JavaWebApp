package by.epam.learn.vadimkominch.command.advertisement;

import by.epam.learn.vadimkominch.command.Command;
import by.epam.learn.vadimkominch.service.AdvertisementService;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.http.HttpServletRequest;

public class DeleteAdvertismentCommand implements Command {

    private final AdvertisementService advertisementService;

    public DeleteAdvertismentCommand() {
        this(AdvertisementService.getInstance());
    }

    public DeleteAdvertismentCommand(AdvertisementService advertisementService) {
        this.advertisementService = advertisementService;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        advertisementService.delete(id);
        response.sendRedirect("/profile");
    }
}
