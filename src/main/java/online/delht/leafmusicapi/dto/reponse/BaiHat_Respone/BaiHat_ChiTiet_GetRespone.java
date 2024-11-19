package online.delht.leafmusicapi.dto.reponse.BaiHat_Respone;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import online.delht.leafmusicapi.Entity.TheLoai;
import online.delht.leafmusicapi.dto.reponse.CaSi_Respone.CaSi_GetRespone;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaiHat_ChiTiet_GetRespone {
    private String tenBaiHat;
//    private CaSi caSi;
//    private TheLoai theLoai;
    private CaSi_GetRespone caSi;
    private TheLoai theLoai;



}
