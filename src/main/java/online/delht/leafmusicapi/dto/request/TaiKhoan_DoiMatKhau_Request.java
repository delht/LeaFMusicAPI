package online.delht.leafmusicapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaiKhoan_DoiMatKhau_Request {

    private String idTaiKhoan;
    private String oldPassword;
    private String newPassword;

}
