package online.delht.leafmusicapi.Service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import online.delht.leafmusicapi.Entity.DsYeuThich;
import online.delht.leafmusicapi.Entity.TaiKhoan;
import online.delht.leafmusicapi.Mapper.DsYeuThichMapper;
import online.delht.leafmusicapi.Mapper.TaiKhoanMapper;
import online.delht.leafmusicapi.Repository.DsYeuThichRepository;
import online.delht.leafmusicapi.Repository.TaiKhoanRepository;
import online.delht.leafmusicapi.Utils.PasswordUtil;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor //bo autowired
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true) //bo private
@Slf4j
public class TaiKhoanService {

    private TaiKhoanRepository taiKhoanRepository;
    private DsYeuThichRepository dsYeuThichRepository;
    TaiKhoanMapper taiKhoanMapper;
    DsYeuThichMapper dsYeuThichMapper;

    // Hàm tạo tài khoản
    public TaiKhoan taoTaiKhoan(String username, String password) {

        if (taiKhoanRepository.existsByUsername(username)) {
            throw new RuntimeException("Email này đã được đăng ký");
        }

        String passwordmahoa = PasswordUtil.maHoaPassword(password);

        TaiKhoan taiKhoan = new TaiKhoan();
        taiKhoan.setUsername(username);
        taiKhoan.setPassword(passwordmahoa);
        taiKhoan.setVaiTro(TaiKhoan.VaiTro.user);
        taiKhoan = taiKhoanRepository.save(taiKhoan);


        DsYeuThich dsYeuThich = new DsYeuThich();
        dsYeuThich.setTaiKhoan(taiKhoan);
//        dsYeuThich.setTenDs("Danh sách yêu thích của "+ username);
        dsYeuThich.setTenDs("Danh sách yêu thích");
        dsYeuThich.setLoaiDs(DsYeuThich.LoaiDanhSach.macdinh);
        dsYeuThichRepository.save(dsYeuThich);

        return taiKhoan;
    }

    public boolean dangNhap(String username, String password) {
        TaiKhoan taiKhoan = taiKhoanRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Ko co tai khoan"));

        String passwordmahoa = PasswordUtil.maHoaPassword(password);

        return taiKhoan.getPassword().equals(passwordmahoa);
    }

//    ==========================================================================
    public TaiKhoan getTaiKhoanById(Integer idTaiKhoan) {
        return taiKhoanRepository.findById(String.valueOf(idTaiKhoan)).orElse(null);
    }

    public TaiKhoan dangNhap2(String username, String password) {
        String passwordmahoa = PasswordUtil.maHoaPassword(password);

        Optional<TaiKhoan> taiKhoanOptional = taiKhoanRepository.findByUsername(username);

        if (taiKhoanOptional.isPresent()) {
            TaiKhoan taiKhoan = taiKhoanOptional.get();

            if (taiKhoan.getPassword().equals(passwordmahoa)) {
                return taiKhoan;
            }
        }
        return null;
    }

//==============================================================================

    public boolean doiMatKhau(String idTaiKhoan, String oldPassword, String newPassword) {

        TaiKhoan taiKhoan = taiKhoanRepository.findById(idTaiKhoan)
                .orElseThrow(() -> new RuntimeException("Tài khoản không tồn tại."));


        String oldPasswordHashed = PasswordUtil.maHoaPassword(oldPassword);

        if (!taiKhoan.getPassword().equals(oldPasswordHashed)) {
            throw new RuntimeException("Mật khẩu cũ không đúng.");
        }

        String newPasswordHashed = PasswordUtil.maHoaPassword(newPassword);

        taiKhoan.setPassword(newPasswordHashed);
        taiKhoanRepository.save(taiKhoan);

        return true;
    }

//    =================================================================================
//    =================================================================================
//    =================================================================================

    public boolean doiMatKhauMail(String username, String newPassword) {
        TaiKhoan taiKhoan = taiKhoanRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Tài khoản không tồn tại."));

        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_+=<>?";
        Random rand = new Random();
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < 8; i++) {  // Tạo mật khẩu dài 8 ký tự
            password.append(characters.charAt(rand.nextInt(characters.length())));
        }
        String newPasswordHashed =  password.toString();

        newPasswordHashed = PasswordUtil.maHoaPassword(newPassword);

        taiKhoan.setPassword(newPasswordHashed);
        taiKhoanRepository.save(taiKhoan);

        return true;
    }






}
