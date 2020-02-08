package by.epam.learn.vadimkominch.Constant;

public class SQLCommand {
    //User commands
    public static final String ADD_USER_TO_USER_TABLE = "INSERT INTO `Users` (`FirstName`, `SecondName`, `NickName`,`Role`) values (?,?,?,?);";
    public static final String ADD_USER_TO_CONFIDENTIALS_TABLE = "INSERT INTO `confidentials` (`Login`, `Password`, `Email`) values (?,?,?);";
    public static final String SELECT_USER_FOR_LOGIN = "SELECT confidentials.User_id AS id,confidentials.Login AS login,confidentials.Email AS email,confidentials.Password AS password,Users.NickName AS nickname from `Users` join `confidentials` on Users.User_id = confidentials.User_id WHERE confidentials.Email like ? OR confidentials.Login like ?;";
    public static final String SELECT_ALL_USERS = "SELECT confidentials.Login AS login,confidentials.Email AS email,confidentials.Password AS password,Users.NickName AS nickname,Users.FirstName AS firstname,Users.SecondName AS secondname from `Users` join `confidentials` on Users.User_id = confidentials.User_id";
    public static final String SELECT_USERS_FOR_ONE_PAGE = "SELECT `FirstName`, `SecondName`, `NickName` from `Users` WHERE `Role`=\"User\" AND id BETWEEN ? AND ?";
    public static final String DELETE_USER_INFO = "DELETE FROM `Users` WHERE `id` = ? AND `FirstName` = ? AND `SecondName` = ? AND `NickName`= ?";
    public static final String DELETE_USER_CONFIDENTIALS = "DELETE FROM `Users` WHERE `id` = ? AND `FirstName` = ? AND `SecondName` = ? AND `NickName`= ?";
    public static final String UPDATE_USER = "UPDATE `Users` SET WHERE ?";
    public static final String RAISE_USER_ROLE = "UPDATE `Users` SET WHERE FirstName=? AND LastName=?";

    //Advertisment commands
    public static final String SELECT_ADVERTISMENT = "SELECT * from `Paragraphs`"; //use join for getting author with its paragraph(need for setting style of site)
    public static final String ADD_NEW_ADVERTISMENT_TO_PARAGRAPH_TABLE = "INSERT INTO `paragraphs` (`Parapgraph_name`,`Category`,`author_id`) values (?,?,?)";
    public static final String ADD_NEW_ADVERTISMENT_TO_PARAGRAPH_ARTICLES = "INSERT INTO `paragraph_articles` (`Article_text`,`creation_date`) values (?,?)";
    public static final String DELETE_ADVERTISMENT = "DELETE FROM `Paragraphs` WHERE NickName = ? AND advertisment_id = ?";//deleting by nickname
    public static final String SELECT_ADVERTISMENTS_FOR_ONE_PAGE = "SELECT * from `Paragraphs` WHERE id BETWEEN ? AND ?";
    public static final String UPDATE_ADVERTISMENT = "UPDATE `Paragraphs` SET WHERE ? AND ? AND ?";
//    public static final String GET_PAGE_OF_ADVERTISMENTS = "SELECT *  FROM    ( SELECT    ROW_NUMBER() OVER ( ORDER BY author_id ) AS RowNum, paragraphs.Category AS category, paragraphs.Parapgraph_name AS name, paragraphs.author_id AS author_id,paragraph_articles.Article_text AS text, paragraphs.paragraph_id AS paragraph_id,paragraph_articles.creation_date AS creation_date FROM  `paragraphs` JOIN `paragraph_articles` ON paragraphs.paragraph_id = paragraph_articles.paragraph_id WHERE paragraphs.Paragraph_id < 10) AS RowConstrainedResult WHERE   RowNum >= ?  AND RowNum < ? ORDER BY RowNum;";
    public static final String GET_PAGE_OF_ADVERTISMENTS = "SELECT *  FROM    ( SELECT    ROW_NUMBER() OVER ( ORDER BY author_id ) AS RowNum,paragraphs.Category AS category, paragraphs.Parapgraph_name AS name,users.NicKname AS nickname, paragraph_articles.Article_text AS text,paragraphs.paragraph_id AS paragraph_id, paragraph_articles.creation_date AS creation_date FROM  `paragraphs` JOIN `paragraph_articles` ON paragraphs.paragraph_id = paragraph_articles.paragraph_id JOIN `users` on paragraphs.author_id = users.User_id WHERE paragraphs.Paragraph_id < 10) AS RowConstrainedResult WHERE   RowNum >= ?  AND RowNum < ? ORDER BY RowNum;";
    //TODO add some queries for categories(not duplicate)
    //Ratings commands
    public static final String GET_AVERAGE_RATING = "";
    public static final String ADD_RATING = "";
    public static final String DELETE_RATING = "";
    public static final String UPDATE_RATING = "";
}
