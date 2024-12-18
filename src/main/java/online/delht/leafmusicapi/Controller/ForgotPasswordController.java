package online.delht.leafmusicapi.Controller;

import jakarta.servlet.http.HttpSession;
import online.delht.leafmusicapi.Service.EmailService;
import online.delht.leafmusicapi.Service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/auth")
public class ForgotPasswordController {

    @Autowired
    private EmailService emailService;

    @Autowired
    private HttpSession session;

    @Autowired
    private TaiKhoanService taikhoanService;


    // API gửi mã xác nhận
    @PostMapping("/forgot-password")
    public ResponseEntity<?> forgotPassword(@RequestParam String email) {
        // Kiểm tra định dạng email
        if (!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            return ResponseEntity.badRequest().body("Email không hợp lệ.");
        }

        // Tạo mã xác nhận
        String verificationCode = UUID.randomUUID().toString().substring(0, 6); // 6 ký tự ngẫu nhiên

        // Lưu mã xác nhận vào session
        session.setAttribute("verificationCode", verificationCode);
        session.setAttribute("email", email);

        // Gửi email
        String subject = "Mã xác nhận quên mật khẩu";
        String body = "Mã xác nhận của bạn là: " + verificationCode;
        emailService.sendEmail(email, subject, body);

        return ResponseEntity.ok("Mã xác nhận đã được gửi đến email của bạn.");
    }

    // API xác nhận mã và đổi mật khẩu
    @PostMapping("/reset-password")
    public ResponseEntity<?> resetPassword(
            @RequestParam String code,
            @RequestParam String newPassword) {

        // Lấy mã và email từ session
        String savedCode = (String) session.getAttribute("verificationCode");
        String savedEmail = (String) session.getAttribute("email");

        if (savedCode == null || savedEmail == null) {
            return ResponseEntity.badRequest().body("Yêu cầu quên mật khẩu đã hết hạn.");
        }

        // Kiểm tra mã xác nhận
        if (!savedCode.equals(code)) {
            return ResponseEntity.badRequest().body("Mã xác nhận không chính xác.");
        }

        // Gọi service để đổi mật khẩu cho tài khoản có email đã lưu
        boolean isChanged = taikhoanService.doiMatKhauMail(savedEmail, newPassword);

        if (isChanged) {
            session.removeAttribute("verificationCode");
            session.removeAttribute("email");
            return ResponseEntity.ok("Mật khẩu của bạn đã được thay đổi.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Không thể thay đổi mật khẩu.");
        }
    }

}
