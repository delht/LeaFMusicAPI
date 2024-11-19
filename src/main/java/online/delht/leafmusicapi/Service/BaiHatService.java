package online.delht.leafmusicapi.Service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import online.delht.leafmusicapi.Entity.BaiHat;
import online.delht.leafmusicapi.Mapper.BaiHat.BaiHatMapper;
import online.delht.leafmusicapi.Repository.BaiHatRepository;
import online.delht.leafmusicapi.dto.reponse.BaiHat_Respone.BaiHat_GetRespone;
import online.delht.leafmusicapi.dto.request.BaiHat_CreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor //bo autowired
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true) //bo private
public class BaiHatService {
//    @Autowired
    private BaiHatRepository baiHatRepository;
//    @Autowired
    private BaiHatMapper baiHatMapper;

    public BaiHat createBaiHat(BaiHat_CreateRequest request) {
        if(baiHatRepository.existsBaiHatByTenBaiHat(request.getTenBaiHat()))
            throw new RuntimeException("Da co ten bai hat nay");
        BaiHat baiHat = baiHatMapper.toBaiHat(request);
        return baiHatRepository.save(baiHat);
    }

    public BaiHat_GetRespone getBaiHatById(String id) {
        BaiHat baiHat = baiHatRepository.findById(id).orElseThrow(()-> new RuntimeException("Khong tim thay bai hat"));

        return baiHatMapper.toBaiHat_GetRespone(baiHat);

    }
}
