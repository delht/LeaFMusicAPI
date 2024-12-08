package online.delht.leafmusicapi.dto.reponse.DsYeuThich_Respone;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import online.delht.leafmusicapi.Entity.DsYeuThich;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DsMacDinh_Respone {
    private Integer id_ds;
    private DsYeuThich.LoaiDanhSach loai_ds;
    private String ten_ds;
}
