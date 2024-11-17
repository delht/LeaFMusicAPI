package online.delht.leafmusicapi.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "ds_yeuthich")
public class DanhSachYeuThich {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_yeuthich;

    @ManyToOne
    @JoinColumn(name = "id_taikhoan")
    private TaiKhoan id_taikhoan;

    @Column(nullable = false)
    private String ten_danhsach;

    @ManyToMany
    @JoinTable(
            name = "item_yeuthich",
            joinColumns = @JoinColumn(name = "id_yeuthich"),
            inverseJoinColumns = @JoinColumn(name = "id_baihat")
    )
    private Set<BaiHat> baiHats;
}
