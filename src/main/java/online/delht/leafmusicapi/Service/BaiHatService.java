package online.delht.leafmusicapi.Service;

import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import online.delht.leafmusicapi.Cloudinary.DeleteFile;
import online.delht.leafmusicapi.Entity.BaiHat;
import online.delht.leafmusicapi.Mapper.BaiHatMapper;
import online.delht.leafmusicapi.Repository.BaiHatRepository;
import online.delht.leafmusicapi.dto.reponse.BaiHat_Respone.BaiHat_ChiTiet_GetRespone;
import online.delht.leafmusicapi.dto.reponse.BaiHat_Respone.BaiHat_GetRespone;
import online.delht.leafmusicapi.dto.request.BaiHat_CreateRequest;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor //bo autowired
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true) //bo private
@Slf4j
public class BaiHatService {
//    @Autowired
    BaiHatRepository baiHatRepository;
//    @Autowired
    BaiHatMapper baiHatMapper;


    public BaiHat_ChiTiet_GetRespone getBaiHatById(String id) {
        BaiHat baiHat = baiHatRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Khong tim thay bai hat theo id nay"));
        return baiHatMapper.toBaiHat_ChiTiet_GetRespone(baiHat);
    }
    public BaiHat_ChiTiet_GetRespone getBaiHatByTenBaiHat(String tenBaiHat) {
        BaiHat baiHat = baiHatRepository.findByTenBaiHat(tenBaiHat)
                .orElseThrow(()-> new RuntimeException("Khong tim thay bai hat theo ten"));
        return  baiHatMapper.toBaiHat_ChiTiet_GetRespone(baiHat);
    }

    //    ========================================================================

    public BaiHat createBaiHat(BaiHat_CreateRequest request) {
        if(baiHatRepository.existsBaiHatByTenBaiHat(request.getTenBaiHat()))
            throw new RuntimeException("Da co ten bai hat nay");
        BaiHat baiHat = baiHatMapper.toBaiHat(request);
        return baiHatRepository.save(baiHat);
    }

    public BaiHat createBaiHat2(BaiHat_CreateRequest request) {
        // Chuyển đổi từ DTO sang Entity
        BaiHat baiHat = baiHatMapper.toBaiHat(request);

        return baiHatRepository.save(baiHat);
    }

    //    ========================================================================

    DeleteFile deleteFile;

    @Transactional
    public void deleteBaiHat(String id) throws IOException {

        BaiHat baiHat = baiHatRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ko tim thay baihat vs id: " + id));



        String fileUrl = baiHat.getUrlFile();
        String publicId = layPublicIdTuURL(fileUrl);

//        String test = "LeaFMusic/Mp3File/"+publicId+".mp3";

        log.info("Url file can xoa {}", fileUrl);


        deleteFile.deleteFile(publicId);
//        deleteFile.deleteFile(test);

        baiHatRepository.deleteById(id);
        log.info("Baihat vs ID {} xoa thanh cong.", id);
    }

//    private String layPublicIdTuURL(String fileUrl) {
//        int start = fileUrl.indexOf("LeaFMusic/Mp3File/") + "LeaFMusic/Mp3File/".length();
//        int end = fileUrl.lastIndexOf(".");
//        return fileUrl.substring(start, end);
//    }

    private String layPublicIdTuURL(String fileUrl) {
        int start = fileUrl.indexOf("LeaFMusic/Mp3File/");
        return fileUrl.substring(start);
    }

    //    ========================================================================

}
