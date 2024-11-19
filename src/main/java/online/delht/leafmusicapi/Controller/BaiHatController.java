package online.delht.leafmusicapi.Controller;

import online.delht.leafmusicapi.Entity.BaiHat;
import online.delht.leafmusicapi.Service.BaiHatService;
import online.delht.leafmusicapi.dto.reponse.BaiHat_Respone.BaiHat_GetRespone;
import online.delht.leafmusicapi.dto.request.BaiHat_CreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/baihat")
public class BaiHatController {
    @Autowired
    private BaiHatService baiHatService;

    @PostMapping("/them")
    BaiHat createBaiHat(@RequestBody BaiHat_CreateRequest request) {
        return baiHatService.createBaiHat(request);
    }

    @GetMapping("/get/{id}")
    ResponseEntity<BaiHat_GetRespone> getBaiHat(@PathVariable String id) {
        BaiHat_GetRespone baihat = baiHatService.getBaiHatById(id);
        if (baihat == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(baihat);
    }

}
