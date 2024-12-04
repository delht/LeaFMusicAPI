package online.delht.leafmusicapi.Service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import online.delht.leafmusicapi.Entity.KhuVucNhac;
import online.delht.leafmusicapi.Entity.TheLoai;
import online.delht.leafmusicapi.Mapper.KhuVucMapper;
import online.delht.leafmusicapi.Repository.KhuVucRepository;
import online.delht.leafmusicapi.dto.reponse.KhuVuc_Respone.KhuVuc_BaiHat_Respone;
import online.delht.leafmusicapi.dto.request.KhuVuc_Request;
import online.delht.leafmusicapi.dto.request.TheLoai_Request;
import org.springframework.stereotype.Service;

import java.io.IOException;

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

    public KhuVucNhac addKhuVuc(KhuVuc_Request khuVucRequest) throws IOException {
        if (khuVucRepository.existsByTenKhuVuc(khuVucRequest.getTen_khuvuc())) {
            throw new RuntimeException("Tên khu vuc đã tồn tại: " + khuVucRequest.getTen_khuvuc());
        }
        KhuVucNhac khuVucNhac = new KhuVucNhac();
        khuVucNhac.setTenKhuVuc(khuVucRequest.getTen_khuvuc());
        return khuVucRepository.save(khuVucNhac);
    }

    public void deleteKhuVuc(String id) throws IOException{
        if (!khuVucRepository.existsById(id)){
            throw new RuntimeException("Khong co khu vuc theo id nay");
        }
        khuVucRepository.deleteById(String.valueOf(id));
    }

    public KhuVucNhac updateTheLoai(String id, KhuVuc_Request khuVucRequest) throws IOException {
        KhuVucNhac khuVucCu = khuVucRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không có khu vuc theo id này"));

        if (khuVucRepository.existsByTenKhuVuc(khuVucRequest.getTen_khuvuc()) &&
                !khuVucRequest.getTen_khuvuc().equals(khuVucCu.getTenKhuVuc())) {
            throw new RuntimeException("Tên khu vực đã tồn tại");
        }

        khuVucCu.setTenKhuVuc(khuVucRequest.getTen_khuvuc());
        return khuVucRepository.save(khuVucCu);
    }


}
