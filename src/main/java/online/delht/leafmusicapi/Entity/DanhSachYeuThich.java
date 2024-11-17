package online.delht.leafmusicapi.Entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "ds_yeuthich")
public class DanhSachYeuThich {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_yeuthich;

    @ManyToOne
    @JoinColumn(name = "id_taikhoan")
    private TaiKhoan taikhoan;

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
