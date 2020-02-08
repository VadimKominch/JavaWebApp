package by.epam.learn.vadimkominch.command;

import by.epam.learn.vadimkominch.daoimplementation.AdvertismentDaoImplementation;
import by.epam.learn.vadimkominch.daoimplementation.DAOInterface;
import by.epam.learn.vadimkominch.entity.Advertisment;

import javax.servlet.http.HttpServletRequest;

public class ModifyParagraphCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        //insert data from paragraph
        DAOInterface<Advertisment,String> daoInterface = new AdvertismentDaoImplementation();
        return "jsp/profile.jsp";
    }
}
