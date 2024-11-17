package online.delht.leafmusicapi.Entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "khuvuc_nhac")
public class KhuVucNhac {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_khuvuc;

    @Column(nullable = false)
    private String ten_khuvuc;

    @OneToMany(mappedBy = "khuvucNhac")
    private Set<BaiHat> baiHats;

}
