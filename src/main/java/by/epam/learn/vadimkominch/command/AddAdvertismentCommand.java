package by.epam.learn.vadimkominch.command;

import by.epam.learn.vadimkominch.daoimplementation.AdvertismentDaoImplementation;
import by.epam.learn.vadimkominch.daoimplementation.DAOInterface;
import by.epam.learn.vadimkominch.entity.Advertisment;
import by.epam.learn.vadimkominch.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
        daoInterface.addOneDAO(advertisment);
        //update info anbout page of eadvertisments
        List<Advertisment> advertismentList = daoInterface.getAmountOfDAOInBorders(1,10);
//        advertismentList.forEach(System.out::println);
        request.getSession(true).setAttribute("advertismentList", advertismentList);
        return "jsp/profile.jsp";
    }
}
