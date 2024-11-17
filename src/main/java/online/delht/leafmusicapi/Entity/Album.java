package online.delht.leafmusicapi.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "album")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_album;

    @Column(nullable = false)
    private String ten_album;

    @ManyToOne
    @JoinColumn(name = "id_casi")
    private CaSi id_casi;

    @Column(nullable = true)
    private String url_hinh;

    private String ngay_phathanh;

    @OneToMany(mappedBy = "id_album")
    private Set<BaiHat> baiHats;

}
