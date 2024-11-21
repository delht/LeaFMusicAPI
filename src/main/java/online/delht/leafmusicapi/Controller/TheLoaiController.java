package online.delht.leafmusicapi.Controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import online.delht.leafmusicapi.Service.TheLoaiService;
import online.delht.leafmusicapi.dto.reponse.TheLoai_Respone.TheLoai_BaiHat_Respone;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
