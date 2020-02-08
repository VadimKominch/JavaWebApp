package by.epam.learn.vadimkominch.command;

import by.epam.learn.vadimkominch.daoimplementation.DAOInterface;
import by.epam.learn.vadimkominch.daoimplementation.UserDaoImplementation;
import by.epam.learn.vadimkominch.entity.User;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.http.HttpServletRequest;

public class RegistrationCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String firstName = request.getParameter("firstname");
        String secondName = request.getParameter("lastname");
        String nickName = request.getParameter("nickName");
        String password = request.getParameter("password");  //hash password
        String email = request.getParameter("email");
        String login = request.getParameter("login");
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(secondName);
        user.setNickName(nickName);
        user.setRole(8);
        user.setEmail(email);
        user.setLogin(login);
        user.setPassword(password);
        System.out.println(BCrypt.hashpw(password, BCrypt.gensalt(12)));
        DAOInterface<User,String> userDAOInterface = new UserDaoImplementation();
        User selectedUser = userDAOInterface.getOne(email);
        if(selectedUser == null) {
            userDAOInterface.addOneDAO(user);// add to credentials and users table
        } else {
            //jsp/errorMessage.jsp
        }
        return "jsp/mainpage.jsp";
    }
}
