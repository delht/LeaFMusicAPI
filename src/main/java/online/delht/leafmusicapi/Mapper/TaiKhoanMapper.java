package online.delht.leafmusicapi.Mapper;

import online.delht.leafmusicapi.Entity.TaiKhoan;
import online.delht.leafmusicapi.dto.request.TaiKhoan_Create_Request;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaiKhoanMapper {

    TaiKhoan toTaiKhoan(TaiKhoan_Create_Request taiKhoan);
}
