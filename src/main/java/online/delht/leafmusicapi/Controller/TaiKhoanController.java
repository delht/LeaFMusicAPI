package online.delht.leafmusicapi.Controller;

import online.delht.leafmusicapi.Entity.TaiKhoan;
import online.delht.leafmusicapi.Service.TaiKhoanService;
import online.delht.leafmusicapi.dto.request.TaiKhoan_Create_Request;
import online.delht.leafmusicapi.dto.request.TaiKhoan_DangNhap_Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/taikhoan")
public class TaiKhoanController {

    @Autowired
    private TaiKhoanService taiKhoanService;


//    @PostMapping("/tao")
//    public ResponseEntity<?> taoTaiKhoan(@RequestBody TaiKhoan_Create_Request request) {
//        try {
//            TaiKhoan taiKhoan = taiKhoanService.taoTaiKhoan(request.getUsername(), request.getPassword());
//            return ResponseEntity.ok("Tài khoản được tạo thành công với ID: " + taiKhoan.getIdTaiKhoan());
//        } catch (RuntimeException e) {
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }
//    }

    @PostMapping("/tao")
    public ResponseEntity<?> taoTaiKhoan(@RequestBody TaiKhoan_Create_Request taiKhoan) {
        TaiKhoan tk = taiKhoanService.createTaiKhoan(taiKhoan);
        return new ResponseEntity<>(tk, HttpStatus.OK);
    }

    @PostMapping("/dangnhap")
    public ResponseEntity<?> dangNhap(@RequestBody TaiKhoan_DangNhap_Request request) {
        try {
            boolean isLoggedIn = taiKhoanService.dangNhap(request.getUsername(), request.getPassword());
            if (isLoggedIn) {
                return ResponseEntity.ok("Đăng nhập thành công!");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Sai tên đăng nhập hoặc mật khẩu!");
            }
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }



}