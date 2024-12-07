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

    @EmbeddedId
    private BaiHatDsYeuThichId id;

    @ManyToOne
    @JoinColumn(name = "id_ds", referencedColumnName = "id_ds", insertable = false, updatable = false)
    private DsYeuThich dsYeuThich;

    @ManyToOne
    @JoinColumn(name = "id_baihat", referencedColumnName = "id_baihat", insertable = false, updatable = false)
    private BaiHat baiHat;

}
