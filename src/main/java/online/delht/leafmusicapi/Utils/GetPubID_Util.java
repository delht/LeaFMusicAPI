package online.delht.leafmusicapi.Utils;

import org.springframework.stereotype.Component;

@Component
public class GetPubID_Util {

    public String layPublicIdTuURL(String fileUrl, String folder) {
        int start = fileUrl.indexOf(folder); //tim vi tri dau tien cua path folder
        return fileUrl.substring(start); //cut chuoi tu vi tri start
    }
}
