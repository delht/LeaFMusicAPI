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
import online.delht.leafmusicapi.dto.request.TaiKhoan_Create_Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
//    public TaiKhoan taoTaiKhoan(String username, String password) {
//
//        if (taiKhoanRepository.existsByUsername(username)) {
//            throw new RuntimeException("Da cos username");
//        }
//
//
//        TaiKhoan taiKhoan = new TaiKhoan();
//        taiKhoan.setUsername(username);
//        taiKhoan.setPassword(password);
//        taiKhoan.setVaiTro(TaiKhoan.VaiTro.user);
//        taiKhoan = taiKhoanRepository.save(taiKhoan);
//
//
//        DsYeuThich dsYeuThich = new DsYeuThich();
//        dsYeuThich.setTaiKhoan(taiKhoan);
//        dsYeuThich.setTenDanhSach("Ds yeu thich cua"+ username);
//        dsYeuThichRepository.save(dsYeuThich);
//
//        return taiKhoan;
//    }
    public TaiKhoan createTaiKhoan(TaiKhoan_Create_Request taiKhoan) {

        //dieu kien trung ten

        TaiKhoan tk = taiKhoanMapper.toTaiKhoan(taiKhoan);

//        DsYeuThich dsYeuThich = new DsYeuThich();
////        dsYeuThich.setTaiKhoan(tk.setIdTaiKhoan());
////        dsYeuThich.setTenDanhSach("Ds yeu thich cua"+ tk.getUsername());
        DsYeuThich dsYeuThich = dsYeuThichMapper.dsYeuThich(taiKhoan);

        dsYeuThichRepository.save(dsYeuThich);

        return tk;
    }


    public boolean dangNhap(String username, String password) {
        TaiKhoan taiKhoan = taiKhoanRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Ko co tai khoan"));

        return taiKhoan.getPassword().equals(password);
    }
}