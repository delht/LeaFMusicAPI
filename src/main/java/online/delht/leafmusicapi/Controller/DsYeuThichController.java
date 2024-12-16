package online.delht.leafmusicapi.Controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import online.delht.leafmusicapi.Entity.DsYeuThich;
import online.delht.leafmusicapi.Repository.BaiHatDsYeuThichRepository;
import online.delht.leafmusicapi.Service.BaiHatService;
import online.delht.leafmusicapi.Service.DsYeuThichService;
import online.delht.leafmusicapi.dto.reponse.BaiHat_Respone.BaiHat_DS_YeuThich;
import online.delht.leafmusicapi.dto.reponse.DsYeuThich_Respone.DsMacDinh_Respone;
import online.delht.leafmusicapi.dto.request.BaiHatDsYeuThich_Request;
import online.delht.leafmusicapi.dto.request.DsYeuThich_Request;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    BaiHatDsYeuThichRepository BaiHatDsYeuThichRepository;
    DsYeuThichService dsYeuThichService;

//    @PostMapping("/themBaiHat")
//    public ResponseEntity<?> themBaiHat(@RequestBody BaiHatDsYeuThich_Request request) {
//        // Xử lý thêm bài hát vào danh sách yêu thích
//        return ResponseEntity.ok("Bài hát đã được thêm vào danh sách yêu thích");
//    }

    @PostMapping("/addMacDinh")
    public ResponseEntity<String> addBaiHatToYeuThichMacDinh(@RequestBody BaiHatDsYeuThich_Request request) {
        try {
            dsYeuThichService.addBaiHatToYeuThichMacDinh(request);
            return ResponseEntity.ok("Bài hát đã được thêm vào danh sách yêu thích.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/removeMacDinh")
    public ResponseEntity<String> removeBaiHatFromYeuThichMaDinh(@RequestBody BaiHatDsYeuThich_Request request) {
        try {
            dsYeuThichService.removeBaiHatFromYeuThichMacDinh(request);
            return ResponseEntity.ok("Bài hát đã được xóa khỏi danh sách yêu thích.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/removeMacDinh/{idDs}/{idBaihat}")
    public ResponseEntity<String> removeBaiHatFromYeuThichMacDinh(@PathVariable("idDs") String idDs, @PathVariable("idBaihat") String idBaihat) {
        try {
            dsYeuThichService.removeBaiHatFromYeuThichMacDinh(idDs, idBaihat);
            return ResponseEntity.ok("Bài hát đã được xóa khỏi danh sách yêu thích.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }



//=============================================================================

    @PostMapping("/create")
    public ResponseEntity<String> createDsYeuThich(@RequestBody DsYeuThich_Request request) {
        try {
            // Gọi service để tạo mới danh sách yêu thích
            dsYeuThichService.createDsYeuThich(request);
            return ResponseEntity.status(HttpStatus.CREATED).body("Danh sách yêu thích đã được tạo.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/id={id}")
    public ResponseEntity<String> deleteDsYeuThich(@PathVariable("id") Integer idDs) {
        try {
            dsYeuThichService.deleteDsYeuThich(idDs);
            return ResponseEntity.status(HttpStatus.OK).body("Danh sách yêu thích đã được xóa.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/update/id={id}")
    public ResponseEntity<String> updateTenDs(@PathVariable("id") Integer idDs, @RequestBody DsYeuThich_Request dsYeuThichDto) {
        try {
            // Gọi service để sửa tên danh sách yêu thích
            dsYeuThichService.updateTenDs(idDs, dsYeuThichDto.getTenDs());
            return ResponseEntity.status(HttpStatus.OK).body("Tên danh sách yêu thích đã được cập nhật.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


    @PutMapping("/update2/id={id}")
    public ResponseEntity<String> updateTenDs2(@PathVariable("id") Integer idDs, @RequestBody String tenDs) {
        try {
            // Gọi service để sửa tên danh sách yêu thích
            dsYeuThichService.updateTenDs(idDs, tenDs);
            return ResponseEntity.status(HttpStatus.OK).body("Tên danh sách yêu thích đã được cập nhật.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }



//    =========================

    @PostMapping("/addCustom")
    public ResponseEntity<String> addBaiHatToYeuThichCustom(@RequestBody BaiHatDsYeuThich_Request request) {
        try {
            dsYeuThichService.addBaiHatToYeuThichCustom(request);
            return ResponseEntity.ok("Bài hát đã được thêm vào danh sách yêu thích.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/addCustom/{idDs}/{idBaiHat}")
    public ResponseEntity<String> addBaiHatToYeuThichCustom(@PathVariable("idDs") String idDs, @PathVariable("idBaiHat") String idBaihat) {
        try {
            dsYeuThichService.addBaiHatToYeuThichCustom(idDs, idBaihat);
            return ResponseEntity.ok("Bài hát đã được thêm vào danh sách yêu thích.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/removeCustom")
    public ResponseEntity<String> removeBaiHatFromYeuThichCustom(@RequestBody BaiHatDsYeuThich_Request request) {
        try {
            dsYeuThichService.removeBaiHatFromYeuThichCustom(request);
            return ResponseEntity.ok("Bài hát đã được xóa khỏi danh sách yêu thích.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/removeCustom/{idDs}/{idBaiHat}")
    public ResponseEntity<String> removeBaiHatFromYeuThichCustom(@PathVariable("idDs") String idDs, @PathVariable("idBaiHat") String idBaihat) {
        try {
            dsYeuThichService.removeBaiHatFromYeuThichCustom(idDs, idBaihat);
            return ResponseEntity.ok("Bài hát đã được xóa khỏi danh sách yêu thích.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

//    ============================================================
    BaiHatService baiHatService;

    @GetMapping("/baihat/id={id}")
    public List<BaiHat_DS_YeuThich> getBaiHatByDanhSach(@PathVariable("id") Integer idDs) {
        return baiHatService.getBaiHatByDanhSach(idDs);
    }

//    ==============================================================

    @GetMapping("/macdinh/id={id}")
    public List<DsMacDinh_Respone> getDsYeuThichMacDinh(@PathVariable("id") Integer idTaiKhoan) {
        return dsYeuThichService.getDsYeuThichMacDinhByTaiKhoan(idTaiKhoan);
    }

    @GetMapping("/custom/id={id}")
    public List<DsMacDinh_Respone> getDsYeuThichCustom(@PathVariable("id") Integer idTaiKhoan) {
        return dsYeuThichService.getDsYeuThichCustomByTaiKhoan(idTaiKhoan);
    }


}
