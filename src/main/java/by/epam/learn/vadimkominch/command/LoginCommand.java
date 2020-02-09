package by.epam.learn.vadimkominch.command;

import by.epam.learn.vadimkominch.check.LoginAndPasswordCheck;
import by.epam.learn.vadimkominch.daoimplementation.DAOInterface;
import by.epam.learn.vadimkominch.daoimplementation.UserDaoImplementation;
import by.epam.learn.vadimkominch.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginCommand implements Command {
    private static LoginAndPasswordCheck checker = new LoginAndPasswordCheck();

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        System.out.println(login);
        System.out.println(password);
        //defense from sql injection
        if (checker.checkLoginIsNullable(login) && checker.checkPasswordIsNullable(password)) {
            DAOInterface<User, String> userDAOInterface = new UserDaoImplementation();
            User user = userDAOInterface.getOne(login);
            //insert check class
            if (user != null && (user.getLogin().equals(login) || user.getEmail().equals(login)) && user.getPassword().equals(password)) {
                if(session.getAttribute("userName")==null) {
                    session.setAttribute("userName",user.getNickName());
                }
                if(session.getAttribute("user")==null) {
                    session.setAttribute("user",user);
                }
                return "main";
                //TODO replace by global variables
            }
        }
        //TODO add error message to loginpage.jsp
        return "jsp/loginpage.jsp";
        //if action is login then return mainpage with credentials
        //else do nothing or send error messages
    }
}
