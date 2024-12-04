package online.delht.leafmusicapi.dto.reponse.Album_Respone;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Album_ResponeForUpdate {

    private Integer idAlbum;
    private String tenAlbum;
    private String idCaSi;
    private String urlHinh;
    private LocalDateTime ngayPhatHanh;
}
