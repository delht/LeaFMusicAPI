package online.delht.leafmusicapi.Entity;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.*;

@Entity
@Table(name = "thongtin_taikhoan")
public class ThongTinTaiKhoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Thongtin;

    @ManyToOne
    @JoinColumn(name = "id_taikhoan")
    private TaiKhoan taikhoan;

    private String ten_taikhoan;

    @Column(nullable = false, unique = true)
    private String email;

    private String sdt;
}
