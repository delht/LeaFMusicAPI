package online.delht.leafmusicapi.dto.reponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import online.delht.leafmusicapi.Entity.CaSi;
import online.delht.leafmusicapi.Entity.KhuVucNhac;
import online.delht.leafmusicapi.Entity.TheLoai;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaiHat_GetRespone {
    private String tenBaiHat;
//    private CaSi caSi;
//    private TheLoai theLoai;
    private CaSi_GetRespone caSi;
    private String theLoai;
}
