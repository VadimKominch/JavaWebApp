package by.epam.learn.vadimkominch.command;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Implement factory pattern to get all pages
 */
public class GetPageCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
//        return returnPage;
    }
    //TODO add some pagination commands
}
