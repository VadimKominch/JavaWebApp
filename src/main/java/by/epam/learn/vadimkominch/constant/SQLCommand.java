package by.epam.learn.vadimkominch.constant;

public class SQLCommand {
    // Category queries
    public static final String GET_ALL_CATEGORIES = "SELECT id, name from category";
    // Credentials queries
    public static final String GET_CREDENTIALS_BY_LOGIN = "SELECT id,login,email,password, user_id from credentials WHERE login = ?;";
    public static final String INSERT_CREDENTIALS = "INSERT INTO `credentials` (`login`, `password`, `email`, user_id) values (?,?,?,?);";

    //User commands
    public static final String GET_USER_BY_ID = "SELECT id, first_name, last_name, nick_name FROM user WHERE id = ?";
    public static final String INSERT_USER = "INSERT INTO user (first_name, last_name, nick_name) values (?,?,?);";
    public static final String SELECT_ALL_USERS = "SELECT credentials.Login AS login,credentials.Email AS email,credentials.Password AS password,user.NickName AS nickname,user.first_name AS first_name,user.last_name AS last_name from `user` join `credentials` on user.User_id = credentials.User_id";
    public static final String DELETE_USER_INFO = "DELETE FROM `user` WHERE `id` = ? AND `first_name` = ? AND `last_name` = ? AND `NickName`= ?";
    public static final String DELETE_USER_CONFIDENTIALS = "DELETE FROM `user` WHERE `id` = ? AND `first_name` = ? AND `last_name` = ? AND `NickName`= ?";
    public static final String UPDATE_USER = "UPDATE `user` SET Login = ?  WHERE ?";
    public static final String RAISE_USER_ROLE = "UPDATE `user` SET WHERE first_name=? AND LastName=?";

    //Advertisement commands
    public static final String GET_ALL_ADVERTISEMENTS = "SELECT * from paragraph"; //use join for getting author with its paragraph(need for setting style of site)
    public static final String GET_TOP_N_ADVERTISEMENTS = "SELECT * from paragraph order by created_date desc limit ?";
    public static final String GET_ALL_ADVERTISEMENTS_BY_USER = "SELECT id,title,body,category_id,created_date, author_id from paragraph where author_id=? order by created_date desc";
    public static final String INSERT_ADVERTISEMENT = "INSERT INTO paragraph (title,body,category_id,created_date, author_id) values (?,?,?,?,?)";
    public static final String DELETE_ADVERTISEMENT = "DELETE FROM paragraph WHERE  id = ?";
    public static final String SELECT_ADVERTISMENTS_FOR_ONE_PAGE = "SELECT * from `paragraph` WHERE id BETWEEN ? AND ?";
    public static final String UPDATE_ADVERTISMENT_NAME_AND_CATEGORY = "UPDATE `paragraph` SET `Parapgraph_name` = ?,`Category` = ? WHERE  paragraph_id = ? ";
     //TODO add some queries for categories(not duplicate)
    //Ratings commands
    public static final String GET_AVERAGE_RATING = "";
    public static final String ADD_RATING = "";
    public static final String DELETE_RATING = "";
    public static final String UPDATE_RATING = "";
}
