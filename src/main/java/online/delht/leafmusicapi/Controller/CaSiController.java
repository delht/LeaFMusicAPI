package online.delht.leafmusicapi.Controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import online.delht.leafmusicapi.Entity.CaSi;
import online.delht.leafmusicapi.Service.CaSiService;
import online.delht.leafmusicapi.dto.reponse.CaSi_Respone.CaSi_Album_GetRespone;
import online.delht.leafmusicapi.dto.reponse.CaSi_Respone.CaSi_BaiHat_GetRespone;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
