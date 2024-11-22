package online.delht.leafmusicapi.Mapper;

import online.delht.leafmusicapi.Entity.Album;
import online.delht.leafmusicapi.Entity.BaiHat;
import online.delht.leafmusicapi.dto.reponse.Album_Respone.Album_BaiHat_Respone;
import online.delht.leafmusicapi.dto.reponse.Album_Respone.Album_Respone;
import online.delht.leafmusicapi.dto.reponse.BaiHat_Respone.BaiHat_ForAlbum_Respone;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface AlbumMapper {
//    @Mapping(source = "caSi.tenCaSi", target = "tenCaSi")
//    Album_Respone albumToAlbumResponse(Album respone);

//    @Mapping(source="baiHats.idBaiHat", target = "baiHats")
//    Album_BaiHat_Respone to_Album_BaiHat_Respone(Album album);

    @Mappings({
            @Mapping(source = "caSi.tenCaSi", target = "tenCaSi"),
            @Mapping(source = "baiHats", target = "baiHats")
    })
    Album_BaiHat_Respone to_Album_BaiHat_Respone(Album album);

    // Ánh xạ từng BaiHat sang BaiHat_ForAlbum_Respone
    @Mappings({
            @Mapping(source = "idBaiHat", target = "idBaiHat"),
            @Mapping(source = "tenBaiHat", target = "tenBaiHat"),
            @Mapping(source = "theLoai.tenTheLoai", target = "theLoai"),
            @Mapping(source = "khuVucNhac.tenKhuVuc", target = "khuVucNhac"),
            @Mapping(source = "urlHinh", target = "urlHinh"),
            @Mapping(source = "ngayPhatHanh", target = "ngayPhatHanh")
    })
    BaiHat_ForAlbum_Respone to_BaiHat_ForAlbum_Respone(BaiHat baiHat);
}
