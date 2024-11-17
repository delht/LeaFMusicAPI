package online.delht.leafmusicapi.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ds_yeuthich")
public class DsYeuThich {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_yeuthich")
    private Integer idYeuThich;

    @ManyToOne
    @JoinColumn(name = "id_taikhoan", nullable = false, foreignKey = @ForeignKey(name = "fk_ds_yeuthich_taikhoan"))
    private TaiKhoan taiKhoan;

    @Column(name = "ten_danhsach", nullable = false)
    private String tenDanhSach;

}
