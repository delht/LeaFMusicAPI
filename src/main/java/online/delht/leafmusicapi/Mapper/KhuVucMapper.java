package online.delht.leafmusicapi.Mapper;

import online.delht.leafmusicapi.Entity.BaiHat;
import online.delht.leafmusicapi.Entity.KhuVucNhac;
import online.delht.leafmusicapi.dto.reponse.BaiHat_Respone.BaiHat_ForKhuVuc_Respone;
import online.delht.leafmusicapi.dto.reponse.BaiHat_Respone.BaiHat_ForTheLoai_Respone;
import online.delht.leafmusicapi.dto.reponse.KhuVuc_Respone.KhuVuc_BaiHat_Respone;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface KhuVucMapper {

    @Mapping(source = "baiHats", target = "baiHats")
    KhuVuc_BaiHat_Respone to_KhuVuc_BaiHat_Respone(KhuVucNhac KhuVucNhac);

    @Mappings({
            @Mapping(source = "idBaiHat", target = "idBaiHat"),
            @Mapping(source = "tenBaiHat", target = "tenBaiHat"),
            @Mapping(target = "caSi", expression = "java(baiHat.getCaSi() != null ? baiHat.getCaSi().getTenCaSi() : null)"),
            @Mapping(target = "theLoai", expression = "java(baiHat.getTheLoai() != null ? baiHat.getTheLoai().getTenTheLoai() : null)"),
            @Mapping(source = "album.tenAlbum", target = "album"),
            @Mapping(source = "urlHinh", target = "urlHinh"),
            @Mapping(source = "ngayPhatHanh", target = "ngayPhatHanh")
    })
    BaiHat_ForKhuVuc_Respone to_BaiHat_ForKhuVuc_Respone(BaiHat baiHat);
}
