package online.delht.leafmusicapi.dto.reponse.TheLoai_Respone;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TheLoai_Respone {

    private Integer idTheLoai;
    private String tenTheLoai;
}
