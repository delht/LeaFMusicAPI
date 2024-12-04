package online.delht.leafmusicapi.Controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import online.delht.leafmusicapi.Entity.KhuVucNhac;
import online.delht.leafmusicapi.Entity.TheLoai;
import online.delht.leafmusicapi.Service.KhuVucService;
import online.delht.leafmusicapi.dto.reponse.KhuVuc_Respone.KhuVuc_BaiHat_Respone;
import online.delht.leafmusicapi.dto.request.KhuVuc_Request;
import online.delht.leafmusicapi.dto.request.TheLoai_Request;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/khuvuc")
public class KhuVucController {

    KhuVucService khuVucService;

    @GetMapping("/get/id={id}")
    public ResponseEntity<KhuVuc_BaiHat_Respone> getKhuVuc_BaiHatId(@PathVariable String id) {
        KhuVuc_BaiHat_Respone khuvuc = khuVucService.getKhuVucByKhuVucId(id);
        if (khuvuc == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(khuvuc);
    }


    @PostMapping("/add")
    public ResponseEntity<?> addKhuVuc(@RequestBody KhuVuc_Request khuVucRequest) {
        try {
            KhuVucNhac khuVuc = khuVucService.addKhuVuc(khuVucRequest);
            return ResponseEntity.ok(khuVucRequest);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/delete/id={id}")
    public ResponseEntity<?> deleteKhuVuc(@PathVariable("id") String id) {
        try {
            khuVucService.deleteKhuVuc(id);
            return ResponseEntity.ok("Da xoa khu vuc voi id" + id);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Có lỗi khi xóa khu vuc");
        }
    }

    @PutMapping("/update/id={id}")
    public ResponseEntity<?> updateKhuVuc(@PathVariable("id") String id, @RequestBody KhuVuc_Request khuVucRequest) {
        try {
            KhuVucNhac khuVucCu = khuVucService.updateTheLoai(id, khuVucRequest);
            return ResponseEntity.ok(khuVucCu);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ko the cap nhat khu vuc");
        }
    }



}
