package online.delht.leafmusicapi.Entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "casi")
public class CaSi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_casi")
    private Integer idCaSi;

    @Column(name = "ten_casi")
    private String tenCaSi;

    @Column(name = "url_hinh")
    private String urlHinh;

    @OneToMany(mappedBy = "caSi")
    private List<Album> albums;

    @OneToMany(mappedBy = "caSi")
    private List<BaiHat> baiHats;




    public CaSi(Integer idCaSi) {
        this.idCaSi = idCaSi;
    }

    @Override
    public String toString() {
        return "CaSi{idCaSi=" + idCaSi + ", tenCaSi='" + tenCaSi + "'}";
    }
}
