package online.delht.leafmusicapi.Controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import online.delht.leafmusicapi.Entity.CaSi;
import online.delht.leafmusicapi.Service.CaSiService;
import online.delht.leafmusicapi.dto.reponse.BaiHat_Respone.BaiHat_List;
import online.delht.leafmusicapi.dto.reponse.CaSi_Respone.CaSi_Album_GetRespone;
import online.delht.leafmusicapi.dto.reponse.CaSi_Respone.CaSi_BaiHat_GetRespone;
import online.delht.leafmusicapi.dto.reponse.CaSi_Respone.CaSi_List;
import online.delht.leafmusicapi.dto.request.CaSi_Resquest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor //bo autowired
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/casi")
public class CaSiController {
    CaSiService caSiService;

    //Album
    @GetMapping("/get/id=album{id}")
    ResponseEntity<CaSi_Album_GetRespone> getCaSiById(@PathVariable String id) {
        CaSi_Album_GetRespone casi = caSiService.getCaSiById(id);
        if(casi == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(casi);
    }
    @GetMapping("/get/name=album{name}")
    ResponseEntity<CaSi_Album_GetRespone> getCaSiByName(@PathVariable String name) {
        CaSi_Album_GetRespone casi = caSiService.getCaSiByCaSi(name);
        if(casi == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(casi);
    }

    @GetMapping("/get/id=baihat{id}")
    ResponseEntity<CaSi_BaiHat_GetRespone> getCaSiByIdBH(@PathVariable String id) {
        CaSi_BaiHat_GetRespone casi = caSiService.getCaSiWithBaiHatId(id);
        if(casi == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(casi);
    }
    @GetMapping("/get/name=baihat{name}")
    ResponseEntity<CaSi_BaiHat_GetRespone> getCaSiByNameBH(@PathVariable String name) {
        CaSi_BaiHat_GetRespone casi = caSiService.getCaSiWithBaiHatName(name);
        if(casi == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(casi);
    }

    //    ==========================================================================================

    @PostMapping("/add")
    public ResponseEntity<?> addCaSi(@RequestParam("img") MultipartFile img, @RequestParam("ten_casi") String tenCaSi) {
        try {
            CaSi_Resquest caSiResquest = new CaSi_Resquest();
            caSiResquest.setTen_casi(tenCaSi);

            CaSi caSi = caSiService.addCaSi(img, caSiResquest);
            return ResponseEntity.ok(caSi);
        } catch (RuntimeException e) {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Có lỗi khi tải lên hình ảnh");
        }
    }

    @DeleteMapping("/delete/id={id}")
    public ResponseEntity<?> deleteCaSi(@PathVariable("id") String id) {
        try {
            caSiService.deleteCaSi(id);
            return ResponseEntity.ok("Ca sĩ đã được xóa thành công");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Có lỗi khi xóa ca sĩ");
        }
    }

    @PutMapping("/update/id={id}")
    public ResponseEntity<?> updateCaSi(@PathVariable("id") String id, @RequestParam("img") MultipartFile img, @RequestParam("ten_casi") String tenCaSi) {
        try {
            CaSi_Resquest caSiResquest = new CaSi_Resquest();
            caSiResquest.setTen_casi(tenCaSi);

            CaSi caSi = caSiService.updateCaSi(id, img, caSiResquest);
            return ResponseEntity.ok(caSi);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Có lỗi khi cập nhật ca sĩ");
        }
    }

    //    ===========================================================

    @GetMapping("/all")
    public List<CaSi_List> getAllCaSi() {
        return caSiService.getAllCaSis();
    }

}
