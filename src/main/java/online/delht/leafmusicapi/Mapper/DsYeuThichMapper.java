package online.delht.leafmusicapi.Mapper;

import online.delht.leafmusicapi.Entity.DsYeuThich;
import online.delht.leafmusicapi.dto.reponse.BaiHat_Respone.BaiHat_DsYeuThich_Respone;
import online.delht.leafmusicapi.dto.request.TaiKhoan_Create_Request;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DsYeuThichMapper {

//    @Mapping(target = "taiKhoan", source = "idTaiKhoan")
    DsYeuThich dsYeuThich(TaiKhoan_Create_Request tk);


    // Ánh xạ từ DsYeuThich sang BaiHat_DsYeuThich_Respone
//    @Mappings({
//            @Mapping(source = "baiHat.idBaiHat", target = "idBaiHat"),
//            @Mapping(source = "baiHat.tenBaiHat", target = "tenBaiHat")
//    })
//    BaiHat_DsYeuThich_Respone toBaiHatDsYeuThichResponse(DsYeuThich dsYeuThich);

    // Ánh xạ danh sách DsYeuThich sang danh sách BaiHat_DsYeuThich_Respone
    List<BaiHat_DsYeuThich_Respone> toBaiHatDsYeuThichResponseList(List<DsYeuThich> dsYeuThichList);

}
