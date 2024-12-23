package by.epam.learn.vadimkominch.command;

import by.epam.learn.vadimkominch.entity.dao.Advertisement;
import by.epam.learn.vadimkominch.repository.AdvertismentRepository;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.http.HttpServletRequest;

public class DeleteAdvertismentCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        AdvertismentRepository repository = new AdvertismentRepository();
        int id = Integer.parseInt(request.getParameter("ads_id"));
        Advertisement advertisement = repository.getOne(id); // select for delete
        repository.delete(advertisement);
        response.sendRedirect("/profile");
    }
}
