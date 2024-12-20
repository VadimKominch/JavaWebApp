package by.epam.learn.vadimkominch.command;

import by.epam.learn.vadimkominch.daoimplementation.AdvertismentDaoImplementation;
import by.epam.learn.vadimkominch.daoimplementation.DAOInterface;
import by.epam.learn.vadimkominch.entity.Advertisment;

import jakarta.servlet.http.HttpServletRequest;
import java.util.Date;

public class ModifyAdvertismentCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        //insert data from paragraph
        Advertisment advertisment = new Advertisment();
        advertisment.setAdvertismentId(Integer.parseInt(request.getParameter("ads_id")));
        advertisment.setCategory(request.getParameter("Category"));
        advertisment.setDate(new Date());
        advertisment.setName(request.getParameter("Name"));
        advertisment.setText(request.getParameter("Text"));
        System.out.println(advertisment);
        DAOInterface<Advertisment,String> daoInterface = new AdvertismentDaoImplementation();
        daoInterface.update(request.getParameter("ads_id"),advertisment);
        return "jsp/advertisment.jsp";
    }
}
