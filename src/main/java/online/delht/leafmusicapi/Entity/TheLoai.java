package online.delht.leafmusicapi.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "theloai")
public class TheLoai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_theloai")
    private Integer idTheLoai;

    @Column(name = "ten_theloai", nullable = false, unique = true)
    private String tenTheLoai;


    @OneToMany(mappedBy = "theLoai")
    private List<BaiHat> baiHats;

}
