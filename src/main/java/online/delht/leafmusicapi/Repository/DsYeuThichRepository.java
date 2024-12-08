package online.delht.leafmusicapi.Repository;

import online.delht.leafmusicapi.Entity.DsYeuThich;
import online.delht.leafmusicapi.Entity.TaiKhoan;
import online.delht.leafmusicapi.dto.reponse.DsYeuThich_Respone.DsMacDinh_Respone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DsYeuThichRepository extends JpaRepository<DsYeuThich, String> {
    List<DsYeuThich> findByTaiKhoan_IdTaiKhoan(Integer idTaiKhoan);

//===========================================================================

//    List<DsYeuThich> findByBaiHat_IdBaiHat(Integer idBaiHat);
//
//    // Kiểm tra xem bài hát đã có trong danh sách yêu thích của tài khoản chưa
//    boolean existsByTaiKhoan_IdTaiKhoanAndBaiHat_IdBaiHat(Integer idTaiKhoan, Integer idBaiHat);
//
//    // Xóa bài hát yêu thích theo id tài khoản và id bài hát
//    void deleteByTaiKhoan_IdTaiKhoanAndBaiHat_IdBaiHat(Integer idTaiKhoan, Integer idBaiHat);
//
//    DsYeuThich findByTaiKhoan_IdTaiKhoanAndBaiHat_IdBaiHat(Integer idTaiKhoan, Integer idBaiHat);
//

    Optional<DsYeuThich> findByTaiKhoanAndLoaiDs(TaiKhoan taiKhoan, DsYeuThich.LoaiDanhSach loaiDs);

    @Query("SELECT new online.delht.leafmusicapi.dto.reponse.DsYeuThich_Respone.DsMacDinh_Respone(d.idDanhSach, d.loaiDs, d.tenDs) FROM DsYeuThich d WHERE d.loaiDs = :loaiDs AND d.taiKhoan.idTaiKhoan = :taiKhoanId")
    List<DsMacDinh_Respone> findByLoaiDsAndTaiKhoanId(@Param("loaiDs") DsYeuThich.LoaiDanhSach loaiDs, @Param("taiKhoanId") Integer taiKhoanId);



}
