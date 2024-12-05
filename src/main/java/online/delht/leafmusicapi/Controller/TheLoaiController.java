package online.delht.leafmusicapi.Controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import online.delht.leafmusicapi.Entity.TheLoai;
import online.delht.leafmusicapi.Service.TheLoaiService;
import online.delht.leafmusicapi.dto.reponse.Album_Respone.Album_List;
import online.delht.leafmusicapi.dto.reponse.TheLoai_Respone.TheLoai_BaiHat_Respone;
import online.delht.leafmusicapi.dto.reponse.TheLoai_Respone.TheLoai_Respone;
import online.delht.leafmusicapi.dto.request.TheLoai_Request;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/theloai")
public class TheLoaiController {
    TheLoaiService theLoaiService;

    @GetMapping("/get/id={id}")
    ResponseEntity<TheLoai_BaiHat_Respone> getTheLoaiId(@PathVariable String id) {
        TheLoai_BaiHat_Respone theloai = theLoaiService.getTheLoaiBaiHat(id);
        if (theloai == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(theloai);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addTheLoai(@RequestBody TheLoai_Request theLoaiRequest) {
        try {
            TheLoai theLoai = theLoaiService.addTheLoai(theLoaiRequest);
            return ResponseEntity.ok(theLoaiRequest);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/delete/id={id}")
    public ResponseEntity<?> deleteTheLoai(@PathVariable("id") String id) {
        try {
            theLoaiService.deleteTheLoai(id);
            return ResponseEntity.ok("Da xoa the loai voi id" + id);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Có lỗi khi xóa ca sĩ");
        }
    }

    @PutMapping("/update/id={id}")
    public ResponseEntity<?> updateTheLoai(@PathVariable("id") String id, @RequestBody TheLoai_Request theLoaiRequest) {
        try {
            TheLoai theLoai = theLoaiService.updateTheLoai(id, theLoaiRequest);
            return ResponseEntity.ok(theLoai);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ko the cap nhat the loai");
        }
    }

//    ====================================================

    @GetMapping("/getMot/id={id}")
    public TheLoai_Respone getTheLoaiById(@PathVariable String id) throws IOException {
        try {
            return theLoaiService.getTheLoaiResponefindBY(id);
        } catch (RuntimeException e) {
            throw new RuntimeException("Không tìm thấy thể loại với id: " + id);
        }
    }

    @GetMapping("/all")
    public List<TheLoai_Respone> getAllTheLoai() {
        return theLoaiService.getAllTheLoai();
    }

}

