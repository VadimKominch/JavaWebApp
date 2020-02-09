package by.epam.learn.vadimkominch.command;

import by.epam.learn.vadimkominch.daoimplementation.AdvertismentDaoImplementation;
import by.epam.learn.vadimkominch.daoimplementation.DAOInterface;
import by.epam.learn.vadimkominch.entity.Advertisment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Implement factory pattern to get all pages
 */
public class GetPageCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String page = request.getParameter("page");
        String returnPage = null;
        switch (page) {
            case "login":
                returnPage = "jsp/loginpage.jsp";
                break;
            case "registration":
                returnPage = "jsp/register.jsp";
                break;
            case "admin":
                returnPage = "jsp/admin.jsp";
                break;
            case "profile":
            case "new_ads":
                returnPage = "jsp/advertisment.jsp";
                break;
            case "main":
            default:
                returnPage = "main";
                break;
        }
        return returnPage;
    }
    //TODO add some pagination commands
}
