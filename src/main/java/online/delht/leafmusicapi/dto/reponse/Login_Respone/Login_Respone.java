package online.delht.leafmusicapi.dto.reponse.Login_Respone;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Login_Respone {
    private String id_taikhoan;
    private String username;
    private String vaitro;
}
