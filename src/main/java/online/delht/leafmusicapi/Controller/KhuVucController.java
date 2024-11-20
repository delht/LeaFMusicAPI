package online.delht.leafmusicapi.Controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import online.delht.leafmusicapi.Service.KhuVucService;
import online.delht.leafmusicapi.dto.reponse.KhuVuc_Respone.KhuVuc_BaiHat_Respone;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor //bo autowired
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

}
