package online.delht.leafmusicapi.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "thongtin_taikhoan")
public class ThongTinTaiKhoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_thongtin")
    private Integer idThongTin;

    @OneToOne
    @JoinColumn(name = "id_taikhoan", nullable = false, foreignKey = @ForeignKey(name = "fk_thongtin_taikhoan"))
    private TaiKhoan taiKhoan;

    @Column(name = "ten_taikhoan")
    private String tenTaiKhoan;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "sdt", length = 20)
    private String sdt;
}

