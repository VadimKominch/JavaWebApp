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
    public static final String UPDATE_USER = "UPDATE user SET first_name=?, last_name=?, nick_name=? WHERE id=?";

    //Advertisement commands
    public static final String GET_ADVERTISEMENT_BY_ID_WITH_ALL_INFO = "SELECT p.id,p.title,p.body,c.name,p.created_date, u.nick_name from paragraph p join category c on p.category_id=c.id join user u on p.author_id=u.id where p.id=?";
    public static final String GET_ALL_ADVERTISEMENTS = "SELECT * from paragraph"; //use join for getting author with its paragraph(need for setting style of site)
    public static final String GET_TOP_N_ADVERTISEMENTS = "SELECT * from paragraph order by created_date desc limit ?";
    public static final String GET_ALL_ADVERTISEMENTS_BY_USER = "SELECT id,title,body,category_id,created_date, author_id from paragraph where author_id=? order by created_date desc";
    public static final String GET_ADVERTISEMENT_BY_ID = "SELECT id,title,body,category_id,created_date, author_id from paragraph where id=?";
    public static final String INSERT_ADVERTISEMENT = "INSERT INTO paragraph (title,body,category_id,created_date, author_id) values (?,?,?,?,?)";
    public static final String DELETE_ADVERTISEMENT = "DELETE FROM paragraph WHERE id = ?";
    public static final String UPDATE_ADVERTISEMENT = "UPDATE paragraph SET title = ?,body = ?, category_id = ? WHERE id = ? ";
     //TODO add some queries for categories(not duplicate)
    // Message commands
     public static final String INSERT_CONVERSATION = "INSERT INTO conversation (hash,first_id,second_id) values (?,?,?)";
     public static final String GET_ALL_CONVERSATIONS = "SELECT id,hash,first_id,second_id from conversation";
     public static final String GET_ALL_USER_CONVERSATIONS = "SELECT id,hash,first_id,second_id from conversation where first_id=? or second_id=?";
     public static final String GET_CONVERSATION_BY_IDS = "SELECT id,hash,first_id,second_id from conversation where first_id=? and second_id=? or first_id=? and second_id=?";
     public static final String GET_CONVERSATION_BY_HASH = "SELECT id,hash,first_id,second_id from conversation where hash=?";
     public static final String GET_CONVERSATION_BY_ID = "SELECT id,hash,first_id,second_id from conversation where id=?";
     public static final String INSERT_MESSAGE = "INSERT INTO message (message,sender_id,conversation_id,send_date) values (?,?,?,?)";
     public static final String GET_MESSAGES_FOR_CONVERSATION = "SELECT id,message,sender_id,conversation_id,send_date from message where conversation_id=? order by send_date desc limit 10";
     public static final String GET_MESSAGE_HISTORY_FOR_CONVERSATION = "SELECT id,message,sender_id,conversation_id,send_date from message where conversation_id=? and send_date > ? and send_date < ?";
}
