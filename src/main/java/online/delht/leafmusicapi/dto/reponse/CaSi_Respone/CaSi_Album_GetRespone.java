package online.delht.leafmusicapi.dto.reponse.CaSi_Respone;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import online.delht.leafmusicapi.dto.reponse.Album_Respone.Album_Respone;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CaSi_Album_GetRespone {

    private int idCaSi;
    private String tenCaSi;
    private String urlHinh;
    private List<Album_Respone> albums;


}
