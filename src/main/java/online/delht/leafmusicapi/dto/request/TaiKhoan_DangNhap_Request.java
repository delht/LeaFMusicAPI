package online.delht.leafmusicapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaiKhoan_DangNhap_Request {
    private String username;
    private String password;
}
