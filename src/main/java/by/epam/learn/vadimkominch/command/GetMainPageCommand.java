package by.epam.learn.vadimkominch.command;

import by.epam.learn.vadimkominch.daoimplementation.AdvertismentDaoImplementation;
import by.epam.learn.vadimkominch.entity.Advertisment;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.util.List;

public class GetMainPageCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        AdvertismentDaoImplementation daoInterface = new AdvertismentDaoImplementation();
        HttpSession session = request.getSession(true);
        int totalSize = daoInterface.getAmountOfAdvertisments();
//        System.out.println("Total size:" +totalSize);
//        System.out.println((int)Math.ceil((double)totalSize/10));
        session.setAttribute("totalPageAmount", (int)Math.ceil((double)totalSize/10));
        int pageNumber;
        if (session.getAttribute("mainPageAdvListNumber") == null) {
            session.setAttribute("mainPageAdvListNumber", 1);
            pageNumber = 1;
        } else {
            pageNumber = (int) session.getAttribute("mainPageAdvListNumber");
        }

        //bad style(correct if can)
        String direction = request.getParameter("direction");
        if (direction != null) {
            if (direction.equals("next")) {
                pageNumber += 1;
            } else if (direction.equals("prev")) {
                pageNumber -= 1;
            }
            session.setAttribute("mainPageAdvListNumber", pageNumber);
        }
        int lowBorder = 10 * (pageNumber - 1) + 1;
        int highBorder = 10 * pageNumber;
        System.out.println(lowBorder + ":" + highBorder);
        List<Advertisment> advertismentList = daoInterface.getAdvertismentsInBorders(lowBorder, highBorder);
        System.out.println(advertismentList.size());
        session.setAttribute("advertismentList", advertismentList);
        return "jsp/mainpage.jsp";
    }
}
