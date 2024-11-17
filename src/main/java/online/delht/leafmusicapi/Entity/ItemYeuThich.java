package online.delht.leafmusicapi.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "item_yeuthich")
public class ItemYeuThich {

    @Id
    @ManyToOne
    @JoinColumn(name = "id_yeuthich", referencedColumnName = "id_yeuthich", insertable = false, updatable = false)
    private DanhSachYeuThich dsYeuthich;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_baihat", referencedColumnName = "id_baihat", insertable = false, updatable = false)
    private BaiHat baihat;
}
