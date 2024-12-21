package online.delht.leafmusicapi.Utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordUtil {

    public static String maHoaPassword(String password) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(password.getBytes()); // bam chuoi truyen vao
            byte[] bytes = messageDigest.digest();
            StringBuilder sb = new StringBuilder();

            //chuyen byte thanh chuoi hex va noi lai vs nhau
            for (byte b : bytes) {
                sb.append(String.format("%02x", b)); //moi 1 ki tu se thanh 2
            }
            return sb.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Khong the ma hoa", e);
        }
    }


}
