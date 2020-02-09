package by.epam.learn.vadimkominch;

import org.mindrot.jbcrypt.BCrypt;

/**
 * Test class for conenecting to database and inserting one line into Users table
 */
public class Main {
    public static void main(String[] args) {

        //register bloc
        String password = "password";
        String password2 = "password1";
        String generatedSecuredPasswordHash = BCrypt.hashpw(password, BCrypt.gensalt(12));
        System.out.println(generatedSecuredPasswordHash);
        System.out.println(generatedSecuredPasswordHash.length());
        String encrypted = "$2a$12$3jj2Qa5jcado62zG9snF8.BaINbexQR/MFQ5CB4okmqtZZuaAZQ7a";
        System.out.println(BCrypt.checkpw(password,encrypted));
        String generatedSecuredPasswordHash2 = BCrypt.hashpw(password2, BCrypt.gensalt(12));
        System.out.println(generatedSecuredPasswordHash2);
        System.out.println(generatedSecuredPasswordHash2.length());

        System.out.println(BCrypt.checkpw(password,generatedSecuredPasswordHash));

    }
}
