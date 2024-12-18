package online.delht.leafmusicapi.Utils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class VerificationCodeCache {

    // Sử dụng ConcurrentHashMap để đảm bảo thread-safe
    private static Map<String, String> verificationCodeMap = new ConcurrentHashMap<>();

    // Lưu mã xác nhận vào bộ nhớ
    public static void saveCode(String email, String code) {
        verificationCodeMap.put(email, code);
    }

    // Lấy mã xác nhận từ bộ nhớ
    public static String getCode(String email) {
        return verificationCodeMap.get(email);
    }

    // Xóa mã xác nhận khi đã sử dụng xong
    public static void removeCode(String email) {
        verificationCodeMap.remove(email);
    }
}
