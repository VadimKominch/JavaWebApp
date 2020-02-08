package by.epam.learn.vadimkominch.check;

/**
 * Class provides checking login and password
 */
public class LoginAndPasswordCheck {
    /**
     *
     * @param login
     * @return @true if login is not empty or null
     */
    public boolean checkLoginIsNullable(String login) {
        return login != null &&
                !login.trim().isEmpty();
    }

    /**
     *
     * @param password
     * @return @true if login is not empty or null
     */
    public boolean checkPasswordIsNullable(String password) {
        return password != null &&
                !password.trim().isEmpty();
    }

}
