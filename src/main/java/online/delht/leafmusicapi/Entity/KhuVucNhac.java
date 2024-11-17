package online.delht.leafmusicapi.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "khuvuc_nhac")
public class KhuVucNhac {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_khuvuc")
    private Integer idKhuVuc;

    @Column(name = "ten_khuvuc", nullable = false)
    private String tenKhuVuc;
}


