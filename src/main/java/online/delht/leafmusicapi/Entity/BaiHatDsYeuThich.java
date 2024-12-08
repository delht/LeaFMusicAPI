package online.delht.leafmusicapi.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "baihat_ds_yeuthich")
public class BaiHatDsYeuThich {

//    @EmbeddedId
//    private BaiHatDsYeuThichId id;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_item")
    private Integer is_item;

    @ManyToOne
    @JoinColumn(name = "id_ds")
    private DsYeuThich dsYeuThich;

    @ManyToOne
    @JoinColumn(name = "id_baihat")
    private BaiHat baiHat;

}
