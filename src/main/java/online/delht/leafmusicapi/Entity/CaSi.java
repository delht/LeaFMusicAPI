package online.delht.leafmusicapi.Entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "casi")
public class CaSi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_casi;

    @Column(nullable = false)
    private String ten_casi;

    private String url_hinh;

    @OneToMany(mappedBy = "casi")
    private Set<BaiHat> baiHats;

    @OneToMany(mappedBy = "casi")
    private Set<Album> albums;
}
