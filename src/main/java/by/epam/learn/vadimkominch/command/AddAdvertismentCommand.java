package by.epam.learn.vadimkominch.command;

import by.epam.learn.vadimkominch.entity.AdvertisementApiModel;
import by.epam.learn.vadimkominch.entity.dao.Advertisement;
import by.epam.learn.vadimkominch.repository.AdvertismentRepository;
import by.epam.learn.vadimkominch.entity.User;

import by.epam.learn.vadimkominch.service.AdvertisementService;
import com.google.gson.Gson;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.util.Date;

public class AddAdvertismentCommand implements Command{

    private final AdvertisementService adsService;

    public AddAdvertismentCommand() {
        adsService = AdvertisementService.getInstance();
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        AdvertismentRepository adsRepository = new AdvertismentRepository();
        AdvertisementApiModel adsModel = null;
        try(BufferedReader reader = request.getReader()) {
            StringBuilder buffer = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
                buffer.append(System.lineSeparator());
            }
            String data = buffer.toString();
            var gson = new Gson();
             adsModel = gson.fromJson(data, AdvertisementApiModel.class);
        }

//        String title = request.getParameter("name");
//        String body = request.getParameter("text");
//        String category = request.getParameter("category");
//        int categoryId = Integer.parseInt(request.getParameter("categoryId"));

        User user = (User)request.getSession().getAttribute("user");
        Advertisement advertisement = new Advertisement();
        advertisement.setTitle(adsModel.getTitle());
        advertisement.setBody(adsModel.getBody());
        advertisement.setCreatedDate(new Date());
        advertisement.setAuthorId(user.getId().getValue());
        advertisement.setCategoryId(adsModel.getCategoryId());
        adsRepository.save(advertisement);
//        List<Advertisement> advertismentList = daoInterface.getAdvertisementsInBorders(1,10);//add builder for selecting
//        request.getSession(true).setAttribute("advertismentList", advertismentList);
        response.sendRedirect("/profile");
    }
}
