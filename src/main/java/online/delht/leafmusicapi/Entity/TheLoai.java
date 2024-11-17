package online.delht.leafmusicapi.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "theloai")
public class TheLoai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_theloai;

    @Column(nullable = false, unique = true)
    private String ten_theloai;

    @OneToMany(mappedBy = "theloai")
    private Set<BaiHat> baiHats;
}
