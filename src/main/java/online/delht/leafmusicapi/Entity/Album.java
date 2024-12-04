package online.delht.leafmusicapi.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "ngay_phathanh")
    private LocalDateTime ngayPhatHanh;

    @OneToMany(mappedBy = "album")
    private List<BaiHat> baiHats;



    @Override
    public String toString() {
        return "Album{idAlbum=" + idAlbum + ", tenAlbum='" + tenAlbum + "', urlHinh='" + urlHinh + "'}";
    }
}
