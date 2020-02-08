package by.epam.learn.vadimkominch.command;

import by.epam.learn.vadimkominch.daoimplementation.AdvertismentDaoImplementation;
import by.epam.learn.vadimkominch.daoimplementation.DAOInterface;
import by.epam.learn.vadimkominch.entity.Advertisment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class GetMainPageCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        DAOInterface<Advertisment,String> daoInterface = new AdvertismentDaoImplementation();
        List<Advertisment> advertismentList = daoInterface.getAmountOfDAOInBorders(1,10);

        HttpSession session = request.getSession(true);

        if(session.getAttribute("advertisments")==null) {
            session.setAttribute("advertisments", advertismentList);
        }
        return "jsp/mainpage.jsp";
    }
}
