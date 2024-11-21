package online.delht.leafmusicapi.Controller;

import online.delht.leafmusicapi.Entity.BaiHat;
import online.delht.leafmusicapi.Repository.BaiHatRepository;
import online.delht.leafmusicapi.Service.BaiHatService;
import online.delht.leafmusicapi.TestUpload.UploadFile;
import online.delht.leafmusicapi.dto.reponse.BaiHat_Respone.BaiHat_ChiTiet_GetRespone;
import online.delht.leafmusicapi.dto.request.BaiHat_CreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

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
            @RequestParam("request") String requestJson
    ) {
        try {
            // chuyen JSON thanh obj BaiHat_CreateRequest
            ObjectMapper objectMapper = new ObjectMapper();
            BaiHat_CreateRequest request = objectMapper.readValue(requestJson, BaiHat_CreateRequest.class);


            if (baiHatRepository.existsBaiHatByTenBaiHat(request.getTenBaiHat())) {
                throw new RuntimeException("Tên bài hát đã tồn tại: " + request.getTenBaiHat());
            }

            String foldername = "LeaFMusic/";
            String fileUrl = uploadFile.uploadFile(file, foldername);

            request.setUrlFile(fileUrl);

            BaiHat baiHat = baiHatService.createBaiHat2(request);

            return ResponseEntity.ok(baiHat);

        } catch (RuntimeException | IOException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.status(500).body("Đã xảy ra lỗi không mong muốn!");
        }
    }




}
