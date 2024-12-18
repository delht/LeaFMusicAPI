package online.delht.leafmusicapi.dto.reponse.Album_Respone;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Album_Artist_Respone {
    private Integer idAlbum;
    private String tenAlbum;
    private String urlHinh;
}
