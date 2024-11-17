package online.delht.leafmusicapi.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

}
