package online.delht.leafmusicapi.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DsYeuThich_Request {
    private String tenDs;
    private Integer idTaiKhoan;
//    private String loaiDs;
}
