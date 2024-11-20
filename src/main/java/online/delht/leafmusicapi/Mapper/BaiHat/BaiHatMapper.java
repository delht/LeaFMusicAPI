package online.delht.leafmusicapi.Mapper.BaiHat;

import online.delht.leafmusicapi.Entity.BaiHat;
import online.delht.leafmusicapi.dto.reponse.BaiHat_Respone.BaiHat_ChiTiet_GetRespone;
import online.delht.leafmusicapi.dto.reponse.BaiHat_Respone.BaiHat_GetRespone;
import online.delht.leafmusicapi.dto.request.BaiHat_CreateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BaiHatMapper {
    BaiHat toBaiHat(BaiHat_CreateRequest request); //Lay gia tri truyen vao

    @Mappings({
            @Mapping(source = "caSi.idCaSi", target = "caSi.idCaSi"),
            @Mapping(source = "theLoai.idTheLoai", target = "theLoai.idTheLoai"),
            @Mapping(source = "album.idAlbum", target = "album.idAlbum"),
            @Mapping(source = "khuVucNhac.idKhuVuc", target = "khuVuc.idKhuVuc")
    })
    BaiHat_ChiTiet_GetRespone toBaiHat_ChiTiet_GetRespone(BaiHat request);

}
