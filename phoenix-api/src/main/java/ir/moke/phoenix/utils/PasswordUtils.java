package ir.moke.phoenix.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class PasswordUtils {

    public static String digestPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-512");
            digest.update(password.getBytes("UTF-8"));
            byte[] passwordDigest = digest.digest();
            return new String(Base64.getEncoder().encode(passwordDigest));
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            throw new RuntimeException("Exception encoding password ", e);
        }
    }
}
