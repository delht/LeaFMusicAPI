package online.delht.leafmusicapi.Controller;

import online.delht.leafmusicapi.Entity.BaiHat;
import online.delht.leafmusicapi.Repository.BaiHatRepository;
import online.delht.leafmusicapi.Service.BaiHatService;
import online.delht.leafmusicapi.Cloudinary.UploadFile;
import online.delht.leafmusicapi.dto.reponse.BaiHat_Respone.BaiHat_ChiTiet_GetRespone;
import online.delht.leafmusicapi.dto.reponse.BaiHat_Respone.BaiHat_DS_YeuThich;
import online.delht.leafmusicapi.dto.reponse.BaiHat_Respone.BaiHat_GetRespone;
import online.delht.leafmusicapi.dto.reponse.BaiHat_Respone.BaiHat_List;
import online.delht.leafmusicapi.dto.request.BaiHat_CreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/baihat")
public class BaiHatController {

    @Autowired
    private BaiHatService baiHatService;

//    ==========================================================================================

    @PostMapping("/them")
    BaiHat createBaiHat(@RequestBody BaiHat_CreateRequest request) {
        return baiHatService.createBaiHat(request);
    }

    @GetMapping("/get/id={id}")
    ResponseEntity<BaiHat_ChiTiet_GetRespone> getBaiHatById(@PathVariable String id) {
        BaiHat_ChiTiet_GetRespone baihat = baiHatService.getBaiHatById(id);
        if (baihat == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(baihat);
    }

    @GetMapping("/get/name={name}")
    ResponseEntity<BaiHat_ChiTiet_GetRespone> getBaiHatByName(@PathVariable String name) {
        BaiHat_ChiTiet_GetRespone baihat = baiHatService.getBaiHatByTenBaiHat(name);
        if (baihat == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(baihat);
    }

//=============================================================

//    private final UploadFile uploadFile;
    @Autowired
    UploadFile uploadFile;
    @Autowired
    BaiHatRepository baiHatRepository;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadBaiHat(
            @RequestParam("file") MultipartFile file,
            @RequestParam("img") MultipartFile img,
            @RequestParam("request") String requestJson) {
        try {
            // chuyen JSON thanh obj BaiHat_CreateRequest
            ObjectMapper objectMapper = new ObjectMapper();
            BaiHat_CreateRequest request = objectMapper.readValue(requestJson, BaiHat_CreateRequest.class);


//            if (baiHatRepository.existsBaiHatByTenBaiHat(request.getTenBaiHat())) {
//                throw new RuntimeException("Tên bài hát đã tồn tại: " + request.getTenBaiHat());
//            }
//
//            String folderMp3 = "LeaFMusic/Mp3File/";
//            String fileUrl = uploadFile.uploadFile(file, folderMp3);
//
//            String folderImg = "LeaFMusic/Images/BaiHat/";
//            String fileUrlImg = uploadFile.uploadFile(img, folderImg);
//
//            request.setUrlFile(fileUrl);
//            request.setUrlHinh(fileUrlImg);

            BaiHat baiHat = baiHatService.createBaiHat2(file, img, request);

            return ResponseEntity.ok(baiHat);

        } catch (RuntimeException | IOException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.status(500).body("Co loi xay ra!");
        }
    }

//    ===========================================================


    @DeleteMapping("/delete/id={id}")
//    public ResponseEntity<?> deleteBaiHat(@RequestParam("id") String id) {
    public ResponseEntity<?> deleteBaiHat(@PathVariable String id) {
        try {
            baiHatService.deleteBaiHat(id);
            return ResponseEntity.ok("Baihat va file da dc xoa.");
        } catch (RuntimeException | IOException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

//    ===========================================================

    @PutMapping("/update/id={id}")
    public ResponseEntity<BaiHat_GetRespone> updateBaiHat(
            @PathVariable("id") String id,
            @RequestParam("file") MultipartFile file,
            @RequestParam("img") MultipartFile img,
            @RequestParam("request") String requestJson) {
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            BaiHat_CreateRequest request = objectMapper.readValue(requestJson, BaiHat_CreateRequest.class);

            BaiHat baiHat = baiHatService.updateBaiHat(id, file, img, request);

            BaiHat_GetRespone baiHatRespone = new BaiHat_GetRespone();
            baiHatRespone.setTenBaiHat(baiHat.getTenBaiHat());
            baiHatRespone.setUrlHinh(baiHat.getUrlHinh());
            baiHatRespone.setUrlFile(baiHat.getUrlFile());

            return ResponseEntity.ok(baiHatRespone);
        }catch (RuntimeException | IOException e) {
//            return ResponseEntity.badRequest().body(e.getMessage());
            return ResponseEntity.badRequest().body(null);
        }

    }


//    ===========================================================

    @GetMapping("/all")
    public List<BaiHat_List> getAllBaiHats() {
        return baiHatService.getAllBaiHats();
    }

    @GetMapping("/randombaihat5")
    public List<BaiHat_List> getRandomSongs(@RequestParam(defaultValue = "5") int count) {
        return baiHatService.getRandomSongs(count);
    }

//=================================

    @GetMapping("/getBH/id={id}")
    public BaiHat_GetRespone getBaiHat(@PathVariable("id") Integer id) {
        return baiHatService.getBaiHatById2(id);
    }


}
