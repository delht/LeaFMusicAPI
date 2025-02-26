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
    @JoinColumn(name = "id_casi")
    private CaSi caSi;

    @ManyToOne
    @JoinColumn(name = "id_theloai")
    private TheLoai theLoai;

    @ManyToOne
    @JoinColumn(name = "id_album")
    private Album album;

    @ManyToOne
    @JoinColumn(name = "id_khuvuc")
    private KhuVucNhac khuVucNhac;

    @Column(name = "url_hinh", length = 255)
    private String urlHinh;

    @Column(name = "url_file", length = 255)
    private String urlFile;

    @Column(name = "ngay_phathanh")
    private LocalDateTime ngayPhatHanh;

}

