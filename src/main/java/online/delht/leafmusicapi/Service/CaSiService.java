package online.delht.leafmusicapi.Service;

import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import online.delht.leafmusicapi.Entity.CaSi;
import online.delht.leafmusicapi.Mapper.CaSiMapper;
import online.delht.leafmusicapi.Repository.CaSiRepository;
import online.delht.leafmusicapi.Utils.GetPubID_Util;
import online.delht.leafmusicapi.dto.reponse.CaSi_Respone.CaSi_Album_GetRespone;
import online.delht.leafmusicapi.dto.reponse.CaSi_Respone.CaSi_BaiHat_GetRespone;
import online.delht.leafmusicapi.dto.request.CaSi_Resquest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import online.delht.leafmusicapi.Cloudinary.DeleteFile;
import online.delht.leafmusicapi.Cloudinary.UploadFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class CaSiService {

    CaSiRepository caSiRepository;
    CaSiMapper caSiMapper;
//    ==========================================================================================

    public CaSi_Album_GetRespone getCaSiById(String id){
        CaSi caSi = caSiRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Khong tim thay ca si co id nay"));
        return caSiMapper.to_CaSi_Albums_GetRespone(caSi);
    }
    public CaSi_Album_GetRespone getCaSiByCaSi(String name){
        CaSi caSi = caSiRepository.findTenCaSiWithAlbumsByTenCaSi(name)
                .orElseThrow(()->new RuntimeException("Khong tim thay ca si co ten nay"));
        return caSiMapper.to_CaSi_Albums_GetRespone(caSi);
    }

    public CaSi_BaiHat_GetRespone getCaSiWithBaiHatId(String id){
        CaSi caSi = caSiRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Khong tim thay ca si co ten nay"));
        return caSiMapper.to_CaSi_BaiHat_GetRespone(caSi);
    }
    public CaSi_BaiHat_GetRespone getCaSiWithBaiHatName(String name){
        CaSi caSi = caSiRepository.findTenCaSiWithBaiHatsByTenCaSi(name)
                .orElseThrow(()->new RuntimeException("Khong tim thay ca si co ten nay"));
        return caSiMapper.to_CaSi_BaiHat_GetRespone(caSi);
    }


    //    ==========================================================================================
    DeleteFile deleteFile;
    UploadFile uploadFile;
    GetPubID_Util getPubIDUtil;

    public CaSi addCaSi(MultipartFile img, CaSi_Resquest caSiResquest) throws IOException {

        if (caSiRepository.existsBaiHatByTenCaSi(caSiResquest.getTen_casi())) {
            throw new RuntimeException("Tên ca sĩ đã tồn tại: " + caSiResquest.getTen_casi());
        }

        String folderImg = "LeaFMusic/Images/CaSi/";
        String fileUrlImg = uploadFile.uploadFile(img, folderImg);

        CaSi caSi = new CaSi();
        caSi.setTenCaSi(caSiResquest.getTen_casi());
        caSi.setUrlHinh(fileUrlImg);

        return caSiRepository.save(caSi);
    }

    @Transactional
    public void deleteCaSi(String id) throws IOException {

        CaSi caSi = caSiRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy ca sĩ với ID: " + id));

        // Xóa ảnh của ca sĩ
        String folderImg = "LeaFMusic/Images/CaSi/";
        String fileUrlImg = caSi.getUrlHinh();
        String publicIdImg = getPubIDUtil.layPublicIdTuURL(fileUrlImg, folderImg);
        log.info("Url file cần xóa {}", fileUrlImg);
        deleteFile.deleteFile(publicIdImg);

        caSiRepository.deleteById(id);
        log.info("Ca sĩ với ID {} đã được xóa thành công.", id);
    }

    public CaSi updateCaSi(String id, MultipartFile img, CaSi_Resquest request) throws IOException {

        CaSi caSiCu = caSiRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy ca sĩ với ID: " + id));

        String oldImgUrl = caSiCu.getUrlHinh();
        log.info("Url file cần xóa {}", oldImgUrl);

        caSiCu.setTenCaSi(request.getTen_casi());

        if (img != null && !img.isEmpty()) {
            String folderImg = "LeaFMusic/Images/CaSi/";

            String oldImgPublicId = getPubIDUtil.layPublicIdTuURL(oldImgUrl, folderImg);
            deleteFile.deleteFile(oldImgPublicId);

            String newImgUrl = uploadFile.uploadFile(img, folderImg);
            caSiCu.setUrlHinh(newImgUrl);
        }

        return caSiRepository.save(caSiCu);
    }




}
