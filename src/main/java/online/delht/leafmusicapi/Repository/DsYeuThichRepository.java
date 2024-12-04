package online.delht.leafmusicapi.Repository;

import online.delht.leafmusicapi.Entity.DsYeuThich;
import online.delht.leafmusicapi.Entity.TaiKhoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DsYeuThichRepository extends JpaRepository<DsYeuThich, Integer> {
    List<DsYeuThich> findByTaiKhoan_IdTaiKhoan(Integer idTaiKhoan);

//===========================================================================

    List<DsYeuThich> findByBaiHat_IdBaiHat(Integer idBaiHat);

    // Kiểm tra xem bài hát đã có trong danh sách yêu thích của tài khoản chưa
    boolean existsByTaiKhoan_IdTaiKhoanAndBaiHat_IdBaiHat(Integer idTaiKhoan, Integer idBaiHat);

    // Xóa bài hát yêu thích theo id tài khoản và id bài hát
    void deleteByTaiKhoan_IdTaiKhoanAndBaiHat_IdBaiHat(Integer idTaiKhoan, Integer idBaiHat);

    DsYeuThich findByTaiKhoan_IdTaiKhoanAndBaiHat_IdBaiHat(Integer idTaiKhoan, Integer idBaiHat);



}
