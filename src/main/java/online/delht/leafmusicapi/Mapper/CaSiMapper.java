package online.delht.leafmusicapi.Mapper;

import online.delht.leafmusicapi.Entity.*;
import online.delht.leafmusicapi.dto.reponse.BaiHat_Respone.BaiHat_GetRespone;
import online.delht.leafmusicapi.dto.reponse.CaSi_Respone.CaSi_Album_GetRespone;
import online.delht.leafmusicapi.dto.reponse.CaSi_Respone.CaSi_BaiHat_GetRespone;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CaSiMapper {

    @Mappings({
//            @Mapping(source = "caSi.idCaSi", target = "caSi.idCaSi"),
            @Mapping(source = "caSi.albums", target = "albums")
    })
    CaSi_Album_GetRespone to_CaSi_Albums_GetRespone(CaSi caSi);
//=============================================================================

    // Ánh xạ từ CaSi sang CaSi_BaiHat_GetRespone
    @Mapping(source = "baiHats", target = "baiHats")
    CaSi_BaiHat_GetRespone to_CaSi_BaiHat_GetRespone(CaSi caSi);

    // Ánh xạ từ BaiHat sang BaiHat_GetRespone
    @Mappings({
//            @Mapping(target = "caSi", expression = "java(baiHat.getCaSi() != null ? baiHat.getCaSi().getTenCaSi() : null)"),
            @Mapping(target = "caSi", source = "caSi.tenCaSi"),
            @Mapping(target = "theLoai", expression = "java(baiHat.getTheLoai() != null ? baiHat.getTheLoai().getTenTheLoai() : null)"),
            @Mapping(target = "album", expression = "java(baiHat.getAlbum() != null ? baiHat.getAlbum().getTenAlbum() : null)"),
            @Mapping(target = "khuVucNhac", expression = "java(baiHat.getKhuVucNhac() != null ? baiHat.getKhuVucNhac().getTenKhuVuc() : null)")
    })
    BaiHat_GetRespone to_BaiHat_GetRespone(BaiHat baiHat);

    // Ánh xạ danh sách bài hát
    List<BaiHat_GetRespone> to_BaiHat_GetRespone_List(List<BaiHat> baiHats);


}
