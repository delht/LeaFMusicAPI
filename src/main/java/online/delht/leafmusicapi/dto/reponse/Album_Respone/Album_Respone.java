package online.delht.leafmusicapi.dto.reponse.Album_Respone;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Album_Respone {

    private Integer idAlbum;
    private String tenAlbum;
    private String tenCaSi;
    private String urlHinh;
    private LocalDateTime ngayPhatHanh;

}
