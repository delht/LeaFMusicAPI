package online.delht.leafmusicapi.Entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaiHatDsYeuThichId implements Serializable {

    private Integer idDanhSach;
    private Integer idBaiHat;

}
