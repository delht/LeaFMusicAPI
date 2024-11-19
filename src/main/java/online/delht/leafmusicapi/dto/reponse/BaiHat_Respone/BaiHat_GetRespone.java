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
import online.delht.leafmusicapi.dto.reponse.CaSi_Respone.CaSi_GetRespone;

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
    private TheLoai theLoai;



}
