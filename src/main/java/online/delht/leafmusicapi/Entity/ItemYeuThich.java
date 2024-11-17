package online.delht.leafmusicapi.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "item_yeuthich")
@IdClass(ItemYeuThichId.class)
public class ItemYeuThich {
    @Id
    @ManyToOne
    @JoinColumn(name = "id_yeuthich", nullable = false, foreignKey = @ForeignKey(name = "fk_item_yeuthich_ds_yeuthich"))
    private DsYeuThich dsYeuThich;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_baihat", nullable = false, foreignKey = @ForeignKey(name = "fk_item_yeuthich_baihat"))
    private BaiHat baiHat;

}

