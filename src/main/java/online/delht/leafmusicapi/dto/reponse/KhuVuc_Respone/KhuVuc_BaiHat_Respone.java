package online.delht.leafmusicapi.dto.reponse.KhuVuc_Respone;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import online.delht.leafmusicapi.dto.reponse.BaiHat_Respone.BaiHat_ForKhuVuc_Respone;
import online.delht.leafmusicapi.dto.reponse.BaiHat_Respone.BaiHat_ForTheLoai_Respone;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KhuVuc_BaiHat_Respone {

    private Integer idKhuVuc;
    private String tenKhuVuc;

    private List<BaiHat_ForKhuVuc_Respone> baiHats;
}
