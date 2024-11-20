package online.delht.leafmusicapi.Controller;

import online.delht.leafmusicapi.Entity.BaiHat;
import online.delht.leafmusicapi.Service.BaiHatService;
import online.delht.leafmusicapi.dto.reponse.BaiHat_Respone.BaiHat_ChiTiet_GetRespone;
import online.delht.leafmusicapi.dto.request.BaiHat_CreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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





}
