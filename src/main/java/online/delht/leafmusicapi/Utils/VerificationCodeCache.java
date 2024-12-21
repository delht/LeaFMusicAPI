package online.delht.leafmusicapi.Utils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class VerificationCodeCache {

    //dung map de luu 2 gia tri vao veri
    private static Map<String, String> verificationCodeMap = new ConcurrentHashMap<>();

    //luu ma code va email vao bo nho
    public static void saveCode(String email, String code) {
        verificationCodeMap.put(email, code);
    }

    // lay code ra
    public static String getCode(String email) {
        return verificationCodeMap.get(email);
    }

    // xoa khi thao tac xong
    public static void removeCode(String email) {
        verificationCodeMap.remove(email);
    }
}
