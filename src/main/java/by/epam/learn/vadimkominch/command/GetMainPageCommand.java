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
        HttpSession session = request.getSession(true);
        int pageNumber;
        if(session.getAttribute("mainPageAdvListNumber")==null) {
            session.setAttribute("mainPageAdvListNumber",1);
            pageNumber = 1;
        } else {
            pageNumber = (int) session.getAttribute("mainPageAdvListNumber");
        }
        String direction = request.getParameter("direction");
        if(direction != null) {
            if (direction.equals("next")) {
                pageNumber += 1;
            } else if (direction.equals("prev")) {
                pageNumber -= 1;
            }
            session.setAttribute("mainPageAdvListNumber",pageNumber);
        }
        int lowBorder = 10*(pageNumber-1)+1;
        int highBorder = 10*pageNumber;
        System.out.println(lowBorder+":"+highBorder);
        List<Advertisment> advertismentList = daoInterface.getAmountOfDAOInBorders(lowBorder,highBorder);
        System.out.println(advertismentList.size());
        session.setAttribute("advertismentList", advertismentList);
        return "jsp/mainpage.jsp";
    }
}
