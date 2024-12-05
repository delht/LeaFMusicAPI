package online.delht.leafmusicapi.dto.reponse.Album_Respone;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import online.delht.leafmusicapi.dto.reponse.BaiHat_Respone.BaiHat_ForAlbum_Respone;
import online.delht.leafmusicapi.dto.reponse.BaiHat_Respone.BaiHat_GetRespone;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class Album_BaiHat_Respone {

    private Integer idAlbum;
    private String tenAlbum;
    private String tenCaSi;
    private String idCaSi;
    private String urlHinh;
    private LocalDateTime ngayPhatHanh;

    private List<BaiHat_ForAlbum_Respone> baiHats;




}
