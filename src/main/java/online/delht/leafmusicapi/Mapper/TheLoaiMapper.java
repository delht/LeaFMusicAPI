package online.delht.leafmusicapi.Mapper;

import online.delht.leafmusicapi.Entity.BaiHat;
import online.delht.leafmusicapi.Entity.CaSi;
import online.delht.leafmusicapi.Entity.TheLoai;
import online.delht.leafmusicapi.dto.reponse.BaiHat_Respone.BaiHat_ForTheLoai_Respone;
import online.delht.leafmusicapi.dto.reponse.TheLoai_Respone.TheLoai_BaiHat_Respone;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TheLoaiMapper {

    @Mapping(source = "baiHats", target = "baiHats") // Map toàn bộ danh sách baiHats
    TheLoai_BaiHat_Respone to_TheLoai_BaiHat_Respone(TheLoai theLoai);

    @Mappings({
            @Mapping(source = "idBaiHat", target = "idBaiHat"),
            @Mapping(source = "tenBaiHat", target = "tenBaiHat"),
//            @Mapping(source = "caSi", target = "caSi"),
            @Mapping(target = "caSi", expression = "java(baiHat.getCaSi() != null ? baiHat.getCaSi().getTenCaSi() : null)"),
            @Mapping(source = "album.tenAlbum", target = "album"),
            @Mapping(source = "khuVucNhac.tenKhuVuc", target = "khuVucNhac"),
            @Mapping(source = "urlHinh", target = "urlHinh"),
            @Mapping(source = "ngayPhatHanh", target = "ngayPhatHanh")
    })
    BaiHat_ForTheLoai_Respone to_BaiHat_ForTheLoai_Respone(BaiHat baiHat);

    default String mapCaSiToString(CaSi caSi) {
        return (caSi != null) ? caSi.getTenCaSi() : null; // Lấy tên ca sĩ hoặc trả về null nếu không tồn tại
    }
}
