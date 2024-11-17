package online.delht.leafmusicapi.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "baihat")
public class BaiHat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_baihat")
    private Integer idBaiHat;

    @Column(name = "ten_baihat", nullable = false)
    private String tenBaiHat;

    @ManyToOne
    @JoinColumn(name = "id_casi", foreignKey = @ForeignKey(name = "fk_baihat_casi"))
    private CaSi caSi;

    @ManyToOne
    @JoinColumn(name = "id_theloai", foreignKey = @ForeignKey(name = "fk_baihat_theloai"))
    private TheLoai theLoai;

    @ManyToOne
    @JoinColumn(name = "id_album", foreignKey = @ForeignKey(name = "fk_baihat_album"))
    private Album album;

    @ManyToOne
    @JoinColumn(name = "id_khuvuc", foreignKey = @ForeignKey(name = "fk_baihat_khuvuc"))
    private KhuVucNhac khuVucNhac;

    @Column(name = "url_hinh", length = 255)
    private String urlHinh;

    @Column(name = "ngay_phathanh", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime ngayPhatHanh;

}

