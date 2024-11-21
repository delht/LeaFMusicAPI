package online.delht.leafmusicapi.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemYeuThichId implements Serializable {

    private Integer dsYeuThich;

    private Integer baiHat;
}