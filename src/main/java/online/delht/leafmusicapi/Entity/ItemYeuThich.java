package online.delht.leafmusicapi.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "item_yeuthich")
public class ItemYeuThich {

    @Id
    @ManyToOne
    @JoinColumn(name = "id_yeuthich", referencedColumnName = "id_yeuthich", insertable = false, updatable = false)
    private DanhSachYeuThich id_yeuthich;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_baihat", referencedColumnName = "id_baihat", insertable = false, updatable = false)
    private BaiHat id_baihat;

}
