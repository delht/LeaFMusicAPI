package online.delht.leafmusicapi.Service;

import online.delht.leafmusicapi.Entity.BaiHat;
import online.delht.leafmusicapi.Repository.BaiHatRepository;
import online.delht.leafmusicapi.dto.reponse.BaiHat_GetRespone;
import online.delht.leafmusicapi.dto.reponse.CaSi_GetRespone;
import online.delht.leafmusicapi.dto.request.BaiHat_CreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaiHatService {
    @Autowired
    private BaiHatRepository baiHatRepository;

    public BaiHat createBaiHat(BaiHat_CreateRequest request) {
        BaiHat baiHat = new BaiHat();

        baiHat.setTenBaiHat(request.getTenBaiHat());
        baiHat.setCaSi(request.getCaSi());
        baiHat.setTheLoai(request.getTheLoai());
        baiHat.setKhuVucNhac(request.getKhuVucNhac());
        baiHat.setUrlHinh(request.getUrlHinh());
        baiHat.setNgayPhatHanh(request.getNgayPhatHanh());

        return baiHatRepository.save(baiHat);
    }

//    public BaiHat getBaiHatById(String id) {
//        return baiHatRepository.findById(id).orElseThrow(() -> new RuntimeException("BaiHat not found"));
//    }

    public BaiHat_GetRespone getBaiHatById(String id) {
        BaiHat baiHat = baiHatRepository.findById(id).orElseThrow(()-> new RuntimeException("Khong co bai hat vs id nay"));

        CaSi_GetRespone caSiGetRespone = CaSi_GetRespone.builder()
                .tenCaSi(baiHat.getCaSi().getTenCaSi())
                .build();

        return BaiHat_GetRespone.builder()
                .tenBaiHat(baiHat.getTenBaiHat())
                .caSi(caSiGetRespone)
                .theLoai(baiHat.getTheLoai().getTenTheLoai())
                .build();

    }
}
