package online.delht.leafmusicapi.dto.reponse.CaSi_Respone;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import online.delht.leafmusicapi.dto.reponse.Album_Respone.Album_Respone;
import online.delht.leafmusicapi.dto.reponse.BaiHat_Respone.BaiHat_GetRespone;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CaSi_BaiHat_GetRespone {

    private int idCaSi;
    private String tenCaSi;
    private String urlHinh;
    private List<BaiHat_GetRespone> baiHats;
}
