package online.delht.leafmusicapi.Entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "baihat")
public class BaiHat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_baihat;

    @Column(nullable = false)
    private String ten_baihat;

    @ManyToOne
    @JoinColumn(name = "id_casi")
    private CaSi casi;

    @ManyToOne
    @JoinColumn(name = "id_theloai")
    private TheLoai theloai;

    @ManyToOne
    @JoinColumn(name = "id_album")
    private Album album;

    @ManyToOne
    @JoinColumn(name = "id_khuvuc")
    private KhuVucNhac khuvucNhac;

    @Column(nullable = true)
    private String url_hinh;

    private String ngay_phathanh;

    @ManyToMany(mappedBy = "baiHats")
    private Set<DanhSachYeuThich> dsYeuthichs;
}
