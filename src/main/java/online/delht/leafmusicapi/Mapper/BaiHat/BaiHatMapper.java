package online.delht.leafmusicapi.Mapper.BaiHat;

import online.delht.leafmusicapi.Entity.BaiHat;
import online.delht.leafmusicapi.dto.reponse.BaiHat_Respone.BaiHat_GetRespone;
import online.delht.leafmusicapi.dto.request.BaiHat_CreateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BaiHatMapper {
    BaiHat toBaiHat(BaiHat_CreateRequest request);

    @Mapping(source = "caSi.tenCaSi", target = "caSi.tenCaSi")
//    @Mapping(source = "theLoai.tenTheLoai", target = "theLoai")
    BaiHat_GetRespone toBaiHat_GetRespone(BaiHat request);

//    void baiHatToBaiHat(@MappingTarget BaiHat baiHat, BaiHat_GetRespone request);
}
