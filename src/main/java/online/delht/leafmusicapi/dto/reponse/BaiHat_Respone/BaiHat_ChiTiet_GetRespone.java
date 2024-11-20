package online.delht.leafmusicapi.dto.reponse.BaiHat_Respone;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import online.delht.leafmusicapi.Entity.Album;
import online.delht.leafmusicapi.Entity.TheLoai;
import online.delht.leafmusicapi.dto.reponse.Album_Respone.Album_Respone;
import online.delht.leafmusicapi.dto.reponse.CaSi_Respone.CaSi_GetRespone;
import online.delht.leafmusicapi.dto.reponse.KhuVuc_Respone.KhuVuc_Respone;
import online.delht.leafmusicapi.dto.reponse.TheLoai_Respone.TheLoai_Respone;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaiHat_ChiTiet_GetRespone {

    private String tenBaiHat;
//    private CaSi caSi;
//    private TheLoai theLoai;
    private CaSi_GetRespone caSi;
    private TheLoai_Respone theLoai;
    private Album_Respone album;
    private KhuVuc_Respone khuVuc;
}
