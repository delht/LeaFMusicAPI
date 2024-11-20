package online.delht.leafmusicapi.dto.reponse.BaiHat_Respone;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaiHat_ForKhuVuc_Respone {

    private Integer idBaiHat;
    private String tenBaiHat;
    private String caSi;
    private String theLoai;
    private String album;
    private String urlHinh;
    private LocalDateTime ngayPhatHanh;
}
