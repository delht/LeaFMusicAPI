package online.delht.leafmusicapi.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ds_yeuthich")
public class DsYeuThich {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ds")
    private Integer idDanhSach;

    @ManyToOne
    @JoinColumn(name = "id_taikhoan", nullable = false)
    private TaiKhoan taiKhoan;

    @Column(name = "ten_ds", nullable = false)
    private String tenDs;

    @Enumerated(EnumType.STRING)
    @Column(name = "loai_ds", columnDefinition = "ENUM('macdinh', 'custom') DEFAULT 'custom' ")
    private LoaiDanhSach loaiDs;

//    @OneToMany(mappedBy = "dsYeuThich")
//    private List<BaiHatDsYeuThich> baiHatDsYeuThichList;

    public enum LoaiDanhSach {
        macdinh , custom
    }

}
