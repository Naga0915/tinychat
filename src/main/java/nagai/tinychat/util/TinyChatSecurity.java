package nagai.tinychat.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;

public class TinyChatSecurity {
    private static String hashSalt = "543a0fbd748bfe349ed7d967b8cc6c9face0a6191772d7fbb136f2835cdfea2294bd16f3098b20e125e7d7edfb42fb4edebd5d0af38d004ee6bc735a49e02175";

    public static String getHashSalt() {
        return hashSalt;
    }

    public static boolean passwordCheck(String password, String saltedHash) {
        try {
            if(generateSaltedHash(password) == saltedHash){
                return true;
            }
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public static String generateSaltedHash(String text) throws NoSuchAlgorithmException {
        String saltedPassword = getHashSalt() + text;
        MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
        byte[] sha256Byte = sha256.digest(saltedPassword.getBytes());

        HexFormat hex = HexFormat.of().withLowerCase();
        return hex.formatHex(sha256Byte);
    }
}
