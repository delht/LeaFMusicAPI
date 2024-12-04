package online.delht.leafmusicapi.dto.reponse.KhuVuc_Respone;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KhuVuc_Respone {

    private Integer idKhuVuc;
    private String tenKhuVuc;
}
