package by.epam.learn.vadimkominch.command;

import by.epam.learn.vadimkominch.entity.dao.Advertisement;
import by.epam.learn.vadimkominch.repository.AdvertismentRepository;
import by.epam.learn.vadimkominch.entity.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Date;

public class AddAdvertismentCommand implements Command{
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        AdvertismentRepository adsRepository = new AdvertismentRepository();
        String title = request.getParameter("Name");
        String body = request.getParameter("Text");
        String category = request.getParameter("Category");
        int categoryId = 1;

        User user = (User)request.getSession(true).getAttribute("user");
        Advertisement advertisement = new Advertisement();
        advertisement.setTitle(title);
        advertisement.setBody(body);
        advertisement.setCreatedDate(new Date());
        advertisement.setAuthorId(user.getId().getValue());
        advertisement.setCategoryId(categoryId);
        adsRepository.save(advertisement);
//        List<Advertisement> advertismentList = daoInterface.getAdvertisementsInBorders(1,10);//add builder for selecting
//        request.getSession(true).setAttribute("advertismentList", advertismentList);
        response.sendRedirect("jsp/advertisment.jsp");
    }
}
