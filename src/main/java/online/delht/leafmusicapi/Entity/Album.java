package online.delht.leafmusicapi.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "album")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_album")
    private Integer idAlbum;

    @Column(name = "ten_album", nullable = false)
    private String tenAlbum;

    @ManyToOne
    @JoinColumn(name = "id_casi", foreignKey = @ForeignKey(name = "fk_album_casi"))
    private CaSi caSi;

    @Column(name = "url_hinh", length = 255)
    private String urlHinh;

    @Column(name = "ngay_phathanh", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime ngayPhatHanh;

    @OneToMany(mappedBy = "album")
    private List<BaiHat> baiHats;

}
