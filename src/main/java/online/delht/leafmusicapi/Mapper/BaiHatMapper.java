package online.delht.leafmusicapi.Mapper;

import online.delht.leafmusicapi.Entity.BaiHat;
import online.delht.leafmusicapi.dto.reponse.BaiHat_Respone.BaiHat_ChiTiet_GetRespone;
import online.delht.leafmusicapi.dto.reponse.BaiHat_Respone.BaiHat_GetRespone;
import online.delht.leafmusicapi.dto.request.BaiHat_CreateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BaiHatMapper {

    @Mappings({
            @Mapping(target = "caSi.idCaSi", source = "caSi"),
            @Mapping(target = "theLoai.idTheLoai", source = "theLoai"),
            @Mapping(target = "album.idAlbum", source = "album"),
            @Mapping(target = "khuVucNhac.idKhuVuc", source = "khuVucNhac"),
            @Mapping(target = "urlHinh", source = "urlHinh"),
            @Mapping(target = "urlFile", source = "urlFile"),
            @Mapping(target = "ngayPhatHanh", expression = "java(java.time.LocalDateTime.parse(request.getNgayPhatHanh()))")
    })
    BaiHat toBaiHat(BaiHat_CreateRequest request); //Lay gia tri truyen vao


    @Mappings({
            @Mapping(source = "caSi.idCaSi", target = "caSi.idCaSi"),
            @Mapping(source = "theLoai.idTheLoai", target = "theLoai.idTheLoai"),
            @Mapping(source = "album.idAlbum", target = "album.idAlbum"),
            @Mapping(source = "khuVucNhac.idKhuVuc", target = "khuVuc.idKhuVuc")
    })
    BaiHat_ChiTiet_GetRespone toBaiHat_ChiTiet_GetRespone(BaiHat respone);

//  DUNG DC
//    @Mappings({
//            @Mapping(target = "caSi.idCaSi", source = "caSi"),
//            @Mapping(target = "theLoai.idTheLoai", source = "theLoai"),
//            @Mapping(target = "album.idAlbum", source = "album"),
//            @Mapping(target = "khuVucNhac.idKhuVuc", source = "khuVucNhac"),
//            @Mapping(target = "ngayPhatHanh", expression = "java(java.time.LocalDateTime.parse(request.getNgayPhatHanh()))")
//    })
//    BaiHat toBaiHat2(BaiHat_CreateRequest request);


    //    ============================================================= Khong su dung

        @Mappings({
            @Mapping(target = "caSi", source = "caSi"),
            @Mapping(target = "theLoai", source = "theLoai"),
            @Mapping(target = "album", source = "album"),
//            @Mapping(target = "khuVucNhac", source = "khuVucNhac"),
//            @Mapping(target = "ngayPhatHanh", expression = "java(java.time.LocalDateTime.parse(request.getNgayPhatHanh()))")
    })
    BaiHat_ChiTiet_GetRespone toBaiHat2(BaiHat request); //Lay gia tri truyen vao


    // Phương thức để chuyển từ Entity BaiHat sang DTO BaiHat_GetRespone
    @Mapping(source = "caSi.tenCaSi", target = "caSi")
    @Mapping(source = "theLoai.tenTheLoai", target = "theLoai")
    @Mapping(source = "album.tenAlbum", target = "album")
    @Mapping(source = "khuVucNhac.tenKhuVuc", target = "khuVucNhac")
    @Mapping(source = "urlHinh", target = "urlHinh")
    @Mapping(source = "urlFile", target = "urlFile")
    @Mapping(source = "ngayPhatHanh", target = "ngayPhatHanh")
    BaiHat_GetRespone toBaiHat_GetRespone(BaiHat baiHat);


}





