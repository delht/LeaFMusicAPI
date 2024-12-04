package online.delht.leafmusicapi.Controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import online.delht.leafmusicapi.Entity.BaiHat;
import online.delht.leafmusicapi.Entity.DsYeuThich;
import online.delht.leafmusicapi.Entity.TaiKhoan;
import online.delht.leafmusicapi.Mapper.DsYeuThichMapper;
import online.delht.leafmusicapi.Service.BaiHatService;
import online.delht.leafmusicapi.Service.DsYeuThichService;
import online.delht.leafmusicapi.Service.TaiKhoanService;
import online.delht.leafmusicapi.dto.reponse.BaiHat_Respone.BaiHat_DsYeuThich_Respone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/dsyeuthich")
public class DsYeuThichController {
    @Autowired
    private DsYeuThichService dsYeuThichService;
    DsYeuThichMapper dsYeuThichMapper;
    TaiKhoanService taiKhoanService;
    BaiHatService baiHatService;

    @GetMapping("/yeuthich/id={id}")
    public ResponseEntity<List<BaiHat_DsYeuThich_Respone>> getBaiHatYeuThich(@PathVariable("id") Integer idTaiKhoan) {
        List<DsYeuThich> dsYeuThichList = dsYeuThichService.findByTaiKhoan_IdTaiKhoan(idTaiKhoan);

        List<BaiHat_DsYeuThich_Respone> baiHatList = dsYeuThichMapper.toBaiHatDsYeuThichResponseList(dsYeuThichList);

        return ResponseEntity.ok(baiHatList);
    }


//    ===================================================================================










}
