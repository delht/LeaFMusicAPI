package online.delht.leafmusicapi.Service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import online.delht.leafmusicapi.Entity.DsYeuThich;
import online.delht.leafmusicapi.Entity.TaiKhoan;
import online.delht.leafmusicapi.Mapper.DsYeuThichMapper;
import online.delht.leafmusicapi.Mapper.TaiKhoanMapper;
import online.delht.leafmusicapi.Repository.TaiKhoanRepository;
import online.delht.leafmusicapi.Utils.PasswordUtil;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor //bo autowired
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true) //bo private
@Slf4j
public class TaiKhoanService {

    private TaiKhoanRepository taiKhoanRepository;
    TaiKhoanMapper taiKhoanMapper;
    DsYeuThichMapper dsYeuThichMapper;

    // Hàm tạo tài khoản
    public TaiKhoan taoTaiKhoan(String username, String password) {

        if (taiKhoanRepository.existsByUsername(username)) {
            throw new RuntimeException("Da cos username");
        }

        String passwordmahoa = PasswordUtil.maHoaPassword(password);

        TaiKhoan taiKhoan = new TaiKhoan();
        taiKhoan.setUsername(username);
        taiKhoan.setPassword(passwordmahoa);
        taiKhoan.setVaiTro(TaiKhoan.VaiTro.user);
        taiKhoan = taiKhoanRepository.save(taiKhoan);


        DsYeuThich dsYeuThich = new DsYeuThich();
        dsYeuThich.setTaiKhoan(taiKhoan);
//        dsYeuThich.setTenDanhSach("Ds yeu thich cua"+ username);

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




}
