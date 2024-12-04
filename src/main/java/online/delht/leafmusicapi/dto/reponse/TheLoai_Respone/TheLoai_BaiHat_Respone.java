package online.delht.leafmusicapi.dto.reponse.TheLoai_Respone;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import online.delht.leafmusicapi.dto.reponse.BaiHat_Respone.BaiHat_ForAlbum_Respone;
import online.delht.leafmusicapi.dto.reponse.BaiHat_Respone.BaiHat_ForTheLoai_Respone;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TheLoai_BaiHat_Respone {

    private Integer idTheLoai;
    private String tenTheLoai;

    private List<BaiHat_ForTheLoai_Respone> baiHats;
}
