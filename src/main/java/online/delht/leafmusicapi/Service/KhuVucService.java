package online.delht.leafmusicapi.Service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import online.delht.leafmusicapi.Entity.KhuVucNhac;
import online.delht.leafmusicapi.Mapper.KhuVucMapper;
import online.delht.leafmusicapi.Repository.KhuVucRepository;
import online.delht.leafmusicapi.dto.reponse.KhuVuc_Respone.KhuVuc_BaiHat_Respone;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class KhuVucService {
    KhuVucRepository khuVucRepository;
    KhuVucMapper khuVucMapper;

    public KhuVuc_BaiHat_Respone getKhuVucByKhuVucId(String id) {
        KhuVucNhac khuVucNhac = khuVucRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Khong co khu vuc nhac"));
        return khuVucMapper.to_KhuVuc_BaiHat_Respone(khuVucNhac);
    }
}
