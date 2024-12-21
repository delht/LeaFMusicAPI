package online.delht.leafmusicapi.Mapper;

import online.delht.leafmusicapi.Entity.Album;
import online.delht.leafmusicapi.Entity.BaiHat;
import online.delht.leafmusicapi.dto.reponse.Album_Respone.Album_BaiHat_Respone;
import online.delht.leafmusicapi.dto.reponse.Album_Respone.Album_Respone;
import online.delht.leafmusicapi.dto.reponse.Album_Respone.Album_ResponeForUpdate;
import online.delht.leafmusicapi.dto.reponse.BaiHat_Respone.BaiHat_ForAlbum_Respone;
import online.delht.leafmusicapi.dto.request.Album_Request;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface AlbumMapper {

    /*
    * src: la doi tuong goc (ben trong ngoac) Album
    * target: la doi tuong muc tieu Album_BaiHat_Respone
    * tuc la id, ten, baihats cua Album se duoc anh xa vafo Album_BaiHat_Respone
    */

    @Mappings({
            @Mapping(source = "caSi.tenCaSi", target = "tenCaSi"),
            @Mapping(source = "caSi.idCaSi", target = "idCaSi"),
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

    // Ánh xạ từ Album_Request sang Album
    @Mappings({
            @Mapping(source = "ten_album", target = "tenAlbum"),
            @Mapping(target = "caSi", ignore = true), // Sẽ set trong service
            @Mapping(source = "ngay_phathanh", target = "ngayPhatHanh"),
            @Mapping(target = "urlHinh", ignore = true) // Sẽ set trong service
    })
    Album toAlbum(Album_Request albumRequest);

//    ================================================= ko su dung

    @Mappings({
            @Mapping(source = "idAlbum", target = "idAlbum"),
            @Mapping(source = "tenAlbum", target = "tenAlbum"),
            @Mapping(source = "caSi.idCaSi", target = "idCaSi"),  // Ánh xạ idCaSi từ đối tượng CaSi trong Album
            @Mapping(source = "urlHinh", target = "urlHinh"),
            @Mapping(source = "ngayPhatHanh", target = "ngayPhatHanh")
    })
    Album_ResponeForUpdate toAlbumResponeForUpdate(Album album);



}
