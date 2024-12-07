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
import online.delht.leafmusicapi.dto.request.DsYeuThich_Request;
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
//    @Autowired
//    private DsYeuThichService dsYeuThichService;
//    DsYeuThichMapper dsYeuThichMapper;
//    TaiKhoanService taiKhoanService;
//    BaiHatService baiHatService;
//
//    @GetMapping("/yeuthich/id={id}")
//    public ResponseEntity<List<BaiHat_DsYeuThich_Respone>> getBaiHatYeuThich(@PathVariable("id") Integer idTaiKhoan) {
//        List<DsYeuThich> dsYeuThichList = dsYeuThichService.findByTaiKhoan_IdTaiKhoan(idTaiKhoan);
//
//        List<BaiHat_DsYeuThich_Respone> baiHatList = dsYeuThichMapper.toBaiHatDsYeuThichResponseList(dsYeuThichList);
//
//        return ResponseEntity.ok(baiHatList);
//    }
//
//
////    ===================================================================================
//
//    @PostMapping("/add")
//    public ResponseEntity<String> addBaiHatToYeuThich(@RequestBody DsYeuThich_Request request) {
//        try {
//            // Kiểm tra sự tồn tại của tài khoản và bài hát
//            TaiKhoan taiKhoan = taiKhoanService.getTaiKhoanById(request.getIdTaiKhoan());
//            BaiHat baiHat = baiHatService.getBaiHatById(request.getIdBaiHat());
//
//            if (taiKhoan == null || baiHat == null) {
//                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tài khoản hoặc bài hát không tồn tại");
//            }
//
//            // Tạo mới đối tượng DsYeuThich và lưu vào database
//            DsYeuThich dsYeuThich = new DsYeuThich();
//            dsYeuThich.setTaiKhoan(taiKhoan);
//            dsYeuThich.setBaiHat(baiHat);
//
//            dsYeuThichService.saveDsYeuThich(dsYeuThich);
//
//            return ResponseEntity.ok("Thêm bài hát yêu thích thành công");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Lỗi hệ thống");
//        }
//    }
//
//
//    @DeleteMapping("/delete")
//    public ResponseEntity<String> deleteBaiHatYeuThich(@RequestBody DsYeuThich_Request request) {
//        boolean isDeleted = dsYeuThichService.deleteBaiHatYeuThich(request.getIdTaiKhoan(), request.getIdBaiHat());
//        if (isDeleted) {
//            return ResponseEntity.ok("Xóa bài hát yêu thích thành công");
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bài hát hoặc tài khoản không tồn tại trong danh sách yêu thích");
//        }
//    }
//



}
