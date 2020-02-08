package by.epam.learn.vadimkominch;

import org.mindrot.jbcrypt.BCrypt;

/**
 * Test class for conenecting to database and inserting one line into Users table
 */
public class Main {
    public static void main(String[] args) {

        //register bloc
        String password = "password";

        String generatedSecuredPasswordHash = BCrypt.hashpw(password, BCrypt.gensalt(12));
        System.out.println(generatedSecuredPasswordHash);

        System.out.println(BCrypt.checkpw(password,generatedSecuredPasswordHash));

    }
}
