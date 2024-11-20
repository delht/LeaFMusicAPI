package online.delht.leafmusicapi.Service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import online.delht.leafmusicapi.Entity.CaSi;
import online.delht.leafmusicapi.Mapper.BaiHat.CaSiMapper;
import online.delht.leafmusicapi.Repository.CaSiRepository;
import online.delht.leafmusicapi.dto.reponse.CaSi_Respone.CaSi_Album_GetRespone;
import online.delht.leafmusicapi.dto.reponse.CaSi_Respone.CaSi_BaiHat_GetRespone;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor //bo autowired
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CaSiService {

    CaSiRepository caSiRepositoryiRepository;
    CaSiMapper caSiMapper;
//    ==========================================================================================

    public CaSi_Album_GetRespone getCaSiById(String id){
        CaSi caSi = caSiRepositoryiRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Khong tim thay ca si co id nay"));
        return caSiMapper.to_CaSi_Albums_GetRespone(caSi);
    }
    public CaSi_Album_GetRespone getCaSiByCaSi(String name){
        CaSi caSi = caSiRepositoryiRepository.findTenCaSiWithAlbumsByTenCaSi(name)
                .orElseThrow(()->new RuntimeException("Khong tim thay ca si co ten nay"));
        return caSiMapper.to_CaSi_Albums_GetRespone(caSi);
    }

    public CaSi_BaiHat_GetRespone getCaSiWithBaiHatId(String id){
        CaSi caSi = caSiRepositoryiRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Khong tim thay ca si co ten nay"));
        return caSiMapper.to_CaSi_BaiHat_GetRespone(caSi);
    }
    public CaSi_BaiHat_GetRespone getCaSiWithBaiHatName(String name){
        CaSi caSi = caSiRepositoryiRepository.findTenCaSiWithBaiHatsByTenCaSi(name)
                .orElseThrow(()->new RuntimeException("Khong tim thay ca si co ten nay"));
        return caSiMapper.to_CaSi_BaiHat_GetRespone(caSi);
    }

}
