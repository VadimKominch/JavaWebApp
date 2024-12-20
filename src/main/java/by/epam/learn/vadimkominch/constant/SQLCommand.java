package by.epam.learn.vadimkominch.constant;

public class SQLCommand {
    //User commands
    public static final String ADD_USER_TO_USER_TABLE = "INSERT INTO `user` (`first_name`, `last_name`, `nick_name`,`role`) values (?,?,?,?);";
    public static final String ADD_USER_TO_CONFIDENTIALS_TABLE = "INSERT INTO `credentials` (`login`, `password`, `email`) values (?,?,?);";
    public static final String SELECT_USER_FOR_LOGIN = "SELECT credentials.id AS id,credentials.login AS login,credentials.email AS email,credentials.password AS password,user.nick_name AS nick_name,user.first_name AS first_name,user.last_name AS last_name from `user` join `credentials` on user.id = credentials.id WHERE credentials.email like ? OR credentials.Login like ?;";
    public static final String SELECT_CREDENTIALS_FOR_LOGIN = "SELECT credentials.id AS id,credentials.login AS login,credentials.email AS email,credentials.password AS password WHERE credentials.email like ? OR credentials.Login like ?;";
    public static final String SELECT_ALL_USERS = "SELECT credentials.Login AS login,credentials.Email AS email,credentials.Password AS password,user.NickName AS nickname,user.first_name AS first_name,user.last_name AS last_name from `user` join `credentials` on user.User_id = credentials.User_id";
    public static final String SELECT_USERS_FOR_ONE_PAGE = "SELECT `first_name`, `last_name`, `NickName` from `user` WHERE `Role`=\"User\" AND id BETWEEN ? AND ?";
    public static final String DELETE_USER_INFO = "DELETE FROM `user` WHERE `id` = ? AND `first_name` = ? AND `last_name` = ? AND `NickName`= ?";
    public static final String DELETE_USER_CONFIDENTIALS = "DELETE FROM `user` WHERE `id` = ? AND `first_name` = ? AND `last_name` = ? AND `NickName`= ?";
    public static final String UPDATE_USER = "UPDATE `user` SET Login = ?  WHERE ?";
    public static final String RAISE_USER_ROLE = "UPDATE `user` SET WHERE first_name=? AND LastName=?";

    //Advertisment commands
    public static final String GET_AMOUNT_OF_ADVERTISMENTS = "SELECT COUNT(*) AS `count` from `paragraph`";
    public static final String GET_AMOUNT_OF_ADVERTISMENTS_BY_USER = "SELECT COUNT(*) AS `count` from `paragraph` WHERE author_id = ?";
    public static final String SELECT_ADVERTISMENT = "SELECT * from `paragraph`"; //use join for getting author with its paragraph(need for setting style of site)
    public static final String ADD_NEW_ADVERTISMENT_TO_PARAGRAPH_TABLE = "INSERT INTO `paragraph` (`Parapgraph_name`,`Category`,`author_id`) values (?,?,?)";
    public static final String ADD_NEW_ADVERTISMENT_TO_PARAGRAPH_ARTICLES = "INSERT INTO `paragraph_articles` (`Article_text`,`creation_date`) values (?,?)";
    public static final String DELETE_ADVERTISMENT = "DELETE FROM `paragraph` WHERE NickName = ? AND advertisment_id = ?";//deleting by nickname
    public static final String DELETE_ADVERTISMENT_NAME = "DELETE FROM `paragraph` WHERE paragraph_id = ?";//deleting by nickname
    public static final String DELETE_ADVERTISMENT_TEXT = "DELETE FROM `Paragraph_articles` WHERE paragraph_id = ?";//deleting by nickname
    public static final String SELECT_ADVERTISMENTS_FOR_ONE_PAGE = "SELECT * from `paragraph` WHERE id BETWEEN ? AND ?";
    public static final String UPDATE_ADVERTISMENT_NAME_AND_CATEGORY = "UPDATE `paragraph` SET `Parapgraph_name` = ?,`Category` = ? WHERE  paragraph_id = ? ";
    public static final String UPDATE_ADVERTISMENT_TEXT = "UPDATE `Paragraph_articles` SET `Article_text` = ?, `creation_date` = ? WHERE paragraph_id = ? ";
//    public static final String GET_PAGE_OF_ADVERTISMENTS = "SELECT *  FROM    ( SELECT    ROW_NUMBER() OVER ( ORDER BY author_id ) AS RowNum, paragraph.Category AS category, paragraph.Parapgraph_name AS name, paragraph.author_id AS author_id,paragraph_articles.Article_text AS text, paragraph.paragraph_id AS paragraph_id,paragraph_articles.creation_date AS creation_date FROM  `paragraph` JOIN `paragraph_articles` ON paragraph.paragraph_id = paragraph_articles.paragraph_id WHERE paragraph.Paragraph_id < 10) AS RowConstrainedResult WHERE   RowNum >= ?  AND RowNum < ? ORDER BY RowNum;";
    public static final String GET_PAGE_OF_ADVERTISMENTS = "SELECT *  FROM    ( SELECT    ROW_NUMBER() OVER ( ORDER BY author_id ) AS RowNum,paragraph.Category AS category, paragraph.Parapgraph_name AS name,user.NicKname AS nickname, paragraph_articles.Article_text AS text,paragraph.paragraph_id AS paragraph_id, paragraph_articles.creation_date AS creation_date FROM  `paragraph` JOIN `paragraph_articles` ON paragraph.paragraph_id = paragraph_articles.paragraph_id JOIN `user` on paragraph.author_id = user.User_id) AS RowConstrainedResult WHERE   RowNum >= ?  AND RowNum < ? ORDER BY RowNum;";
    public static final String GET_PAGE_OF_ADVERTISMENTS_BY_USER = "SELECT *  \n" +
            "FROM    ( SELECT    ROW_NUMBER() OVER ( ORDER BY author_id ) AS RowNum,\n" +
            "paragraph.Category AS category, \n" +
            "paragraph.Parapgraph_name AS name,\n" +
            "paragraph_articles.Article_text AS text,\n" +
            "paragraph.paragraph_id AS paragraph_id, \n" +
            "paragraph_articles.creation_date AS creation_date, \n" +
            "paragraph.author_id AS author_id\n" +
            "FROM  `paragraph` JOIN `paragraph_articles` ON paragraph.paragraph_id = paragraph_articles.paragraph_id \n" +
            "JOIN `user` on paragraph.author_id = user.User_id) \n" +
            "AS RowConstrainedResult \n" +
            "WHERE   RowNum >= ?  AND RowNum < ? AND author_id = ? \n" +
            "ORDER BY RowNum;";
    //TODO add some queries for categories(not duplicate)
    //Ratings commands
    public static final String GET_AVERAGE_RATING = "";
    public static final String ADD_RATING = "";
    public static final String DELETE_RATING = "";
    public static final String UPDATE_RATING = "";
}
