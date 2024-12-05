package online.delht.leafmusicapi.Service;

import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import online.delht.leafmusicapi.Cloudinary.DeleteFile;
import online.delht.leafmusicapi.Cloudinary.UploadFile;
import online.delht.leafmusicapi.Entity.*;
import online.delht.leafmusicapi.Mapper.BaiHatMapper;
import online.delht.leafmusicapi.Repository.*;
import online.delht.leafmusicapi.Utils.GetPubID_Util;
import online.delht.leafmusicapi.dto.reponse.BaiHat_Respone.BaiHat_ChiTiet_GetRespone;
import online.delht.leafmusicapi.dto.reponse.BaiHat_Respone.BaiHat_GetRespone;
import online.delht.leafmusicapi.dto.reponse.BaiHat_Respone.BaiHat_List;
import online.delht.leafmusicapi.dto.request.BaiHat_CreateRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
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

    public BaiHat createBaiHat2(MultipartFile file, MultipartFile img, BaiHat_CreateRequest request) throws IOException {


        if (baiHatRepository.existsBaiHatByTenBaiHat(request.getTenBaiHat())) {
            throw new RuntimeException("Tên bài hát đã tồn tại: " + request.getTenBaiHat());
        }

        String folderMp3 = "LeaFMusic/Mp3File/";
        String fileUrl = uploadFile.uploadFile(file, folderMp3);

        String folderImg = "LeaFMusic/Images/BaiHat/";
        String fileUrlImg = uploadFile.uploadFile(img, folderImg);

        request.setUrlFile(fileUrl);
        request.setUrlHinh(fileUrlImg);


        // Chuyển đổi từ DTO sang Entity
        BaiHat baiHat = baiHatMapper.toBaiHat(request);

        return baiHatRepository.save(baiHat);
    }

    //    ========================================================================

    DeleteFile deleteFile;
    UploadFile uploadFile;
    GetPubID_Util getPubIDUtil;

    @Transactional
    public void deleteBaiHat(String id) throws IOException {

        BaiHat baiHat = baiHatRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ko tim thay baihat vs id: " + id));

        //xoa file mp3
        String folderMp3 = "LeaFMusic/Mp3File/";
        String fileUrlMp3 = baiHat.getUrlFile();
        String publicIdMp3 = getPubIDUtil.layPublicIdTuURL(fileUrlMp3, folderMp3);
        log.info("Url file can xoa {}", fileUrlMp3);
        deleteFile.deleteFile(publicIdMp3);

        //xoa file img
        String folderImg = "LeaFMusic/Images/BaiHat/";
        String fileUrlImg = baiHat.getUrlHinh();
        String publicIdImg = getPubIDUtil.layPublicIdTuURL(fileUrlImg, folderImg);
        log.info("Url file can xoa {}", fileUrlImg);
        deleteFile.deleteFile(publicIdImg);


        baiHatRepository.deleteById(id);
        log.info("Baihat vs ID {} xoa thanh cong.", id);
    }

//    private String layPublicIdTuURL(String fileUrl) {
//        int start = fileUrl.indexOf("LeaFMusic/Mp3File/") + "LeaFMusic/Mp3File/".length();
//        int end = fileUrl.lastIndexOf(".");
//        return fileUrl.substring(start, end);
//    }

//    private String layPublicIdTuURL(String fileUrl, String folder) {
//        int start = fileUrl.indexOf(folder);
//        return fileUrl.substring(start);
//    }

    //    ========================================================================

    public BaiHat updateBaiHat(String id, MultipartFile file, MultipartFile img, BaiHat_CreateRequest request) throws IOException {


        BaiHat baiHatCu=baiHatRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy bài hát với ID: " + id));

        String oldImgUrl=baiHatCu.getUrlHinh();
        String oldFileUrl=baiHatCu.getUrlFile();

        log.info("Url file can xoa {}", oldImgUrl);
        log.info("Url file can xoa {}", oldFileUrl);


        baiHatCu = baiHatMapper.toBaiHat(request);
//        baiHatCu = baiHatMapper.toBaiHat2(request);
        baiHatCu.setIdBaiHat(Integer.valueOf(id));

        Integer testid = baiHatCu.getIdBaiHat();
        log.info("id: ", testid);



//
//        // Tìm Album mới từ cơ sở dữ liệu và gán
//        if (request.getAlbum() != null) {
//            Album album = albumRepository.findById(String.valueOf(Integer.parseInt(request.getAlbum())))
//                    .orElseThrow(() -> new RuntimeException("Không tìm thấy Album với ID: " + request.getAlbum()));
//            baiHat.setAlbum(album);
//        }
//
//        // Tương tự với các thực thể khác
//        if (request.getCaSi() != null) {
//            CaSi caSi = caSiRepository.findById(String.valueOf(Integer.parseInt(request.getCaSi())))
//                    .orElseThrow(() -> new RuntimeException("Không tìm thấy CaSi với ID: " + request.getCaSi()));
//            baiHat.setCaSi(caSi);
//        }
//
//        if (request.getTheLoai() != null) {
//            TheLoai theLoai = theLoaiRepository.findById(String.valueOf(Integer.parseInt(request.getTheLoai())))
//                    .orElseThrow(() -> new RuntimeException("Không tìm thấy TheLoai với ID: " + request.getTheLoai()));
//            baiHat.setTheLoai(theLoai);
//        }
//
//        if (request.getKhuVucNhac() != null) {
//            KhuVucNhac khuVucNhac = khuVucRepository.findById(request.getKhuVucNhac())
//                    .orElseThrow(() -> new RuntimeException("Không tìm thấy KhuVucNhac với ID: " + request.getKhuVucNhac()));
//            baiHat.setKhuVucNhac(khuVucNhac);
//        }
//
//        baiHat.setNgayPhatHanh(LocalDateTime.parse(request.getNgayPhatHanh()));

//        ====================================================

        //mp3


        if (file != null && !file.isEmpty()) {
            String folderMp3 = "LeaFMusic/Mp3File/";

            // Xóa file cũ trên Cloudinary
//            String oldFileUrl = baiHat.getUrlFile();

            log.info("Url file can xoa {}", oldFileUrl);

            String oldPublicId = getPubIDUtil.layPublicIdTuURL(oldFileUrl, folderMp3);
            deleteFile.deleteFile(oldPublicId);

            String newFileUrl = uploadFile.uploadFile(file, folderMp3);
            baiHatCu.setUrlFile(newFileUrl);
        }
        //img
        if (img != null && !img.isEmpty()) {
            String folderImg = "LeaFMusic/Images/BaiHat/";

//            String oldImgUrl = baiHat.getUrlHinh();
            String oldImgPublicId = getPubIDUtil.layPublicIdTuURL(oldImgUrl, folderImg);
            deleteFile.deleteFile(oldImgPublicId);

            String newImgUrl = uploadFile.uploadFile(img, folderImg);
            baiHatCu.setUrlHinh(newImgUrl);
        }

        return baiHatRepository.save(baiHatCu);
//        return null;
    }

    //    ========================================================================

    public BaiHat findById(String idBaiHat) {
        return baiHatRepository.findById(idBaiHat)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy bài hát với ID này"));
    }

    public BaiHat getBaiHatById(Integer idBaiHat) {
        return baiHatRepository.findById(String.valueOf(idBaiHat)).orElse(null);
    }


    //    ========================================================================

    public List<BaiHat_List> getAllBaiHats() {
        List<BaiHat_List> baiHatList = new ArrayList<>();

        for (BaiHat baiHat : baiHatRepository.findAll()) {
            BaiHat_List baiHat_list = BaiHat_List.builder()
                    .idBaiHat(baiHat.getIdBaiHat())
                    .tenBaiHat(baiHat.getTenBaiHat())
                    .build();
            baiHatList.add(baiHat_list);
        }

        return baiHatList;
    }

}
