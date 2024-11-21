package online.delht.leafmusicapi.dto.reponse.BaiHat_Respone;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import online.delht.leafmusicapi.Entity.Album;
import online.delht.leafmusicapi.Entity.CaSi;
import online.delht.leafmusicapi.Entity.KhuVucNhac;
import online.delht.leafmusicapi.Entity.TheLoai;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaiHat_GetRespone {

    private Integer idBaiHat;
    private String tenBaiHat;
    private String caSi;
    private String theLoai;
    private String album;
    private String khuVucNhac;
    private String urlHinh;
    private String urlFile;
    private LocalDateTime ngayPhatHanh;
}
