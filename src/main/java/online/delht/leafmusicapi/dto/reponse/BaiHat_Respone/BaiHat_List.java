package online.delht.leafmusicapi.dto.reponse.BaiHat_Respone;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaiHat_List {
    private Integer idBaiHat;
    private String tenBaiHat;
    private String urlHinh;
}
