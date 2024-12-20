package by.epam.learn.vadimkominch.command;

import by.epam.learn.vadimkominch.daoimplementation.AdvertismentDaoImplementation;
import by.epam.learn.vadimkominch.daoimplementation.DAOInterface;
import by.epam.learn.vadimkominch.entity.Advertisment;
import by.epam.learn.vadimkominch.entity.User;

import jakarta.servlet.http.HttpServletRequest;

import java.util.Date;
import java.util.List;

public class AddAdvertismentCommand implements Command{
    @Override
    public String execute(HttpServletRequest request) {
        DAOInterface<Advertisment,String> daoInterface = new AdvertismentDaoImplementation();
        String adsName = request.getParameter("Name");
        String adsText = request.getParameter("Text");
        String category = request.getParameter("Category");

        User user = (User)request.getSession(true).getAttribute("user");
//        System.out.println(user);
        Advertisment advertisment = new Advertisment();
        advertisment.setAuthor(user.getNickName());
        advertisment.setCategory(category);
        advertisment.setDate(new Date());
        advertisment.setName(adsName);
        advertisment.setText(adsText);
        advertisment.setAuthorId(user.getId());
        daoInterface.save(advertisment);
        List<Advertisment> advertismentList = daoInterface.getAdvertismentsInBorders(1,10);//add builder for selecting
        request.getSession(true).setAttribute("advertismentList", advertismentList);
        return "jsp/advertisment.jsp";
    }
}
