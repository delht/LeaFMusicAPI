package online.delht.leafmusicapi.Mapper;

import online.delht.leafmusicapi.Entity.DsYeuThich;
import online.delht.leafmusicapi.dto.request.TaiKhoan_Create_Request;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DsYeuThichMapper {

//    @Mapping(target = "taiKhoan", source = "idTaiKhoan")
    DsYeuThich dsYeuThich(TaiKhoan_Create_Request tk);
}
