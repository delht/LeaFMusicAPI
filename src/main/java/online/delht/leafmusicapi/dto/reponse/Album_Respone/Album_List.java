package online.delht.leafmusicapi.dto.reponse.Album_Respone;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Album_List {
    private Integer idAlbum;
    private String tenAlbum;
    private String urlHinh;
}
