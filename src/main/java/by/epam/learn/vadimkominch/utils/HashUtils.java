package by.epam.learn.vadimkominch.utils;

import org.mindrot.jbcrypt.BCrypt;

public class HashUtils {

    public static final int ROUNDS = 12;
    public static final String SALT = BCrypt.gensalt(ROUNDS);
    public static String hash(String src) {
        return BCrypt.hashpw(src, SALT);
    }

    public static boolean checkPass(String src, String hash) {
        return BCrypt.checkpw(src, hash);
    }
}
