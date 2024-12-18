package online.delht.leafmusicapi.Repository;

import online.delht.leafmusicapi.Entity.BaiHat;
import online.delht.leafmusicapi.dto.reponse.BaiHat_Respone.BaiHat_GetRespone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BaiHatRepository extends JpaRepository<BaiHat, String> {
    boolean existsBaiHatByTenBaiHat(String tenBaiHat);
    Optional<BaiHat> findByTenBaiHat(String tenBaiHat);



    // Tìm bài hát có tên chứa chuỗi nhập vào (không phân biệt hoa thường)
    @Query("SELECT new online.delht.leafmusicapi.dto.reponse.BaiHat_Respone.BaiHat_GetRespone(b.idBaiHat, b.tenBaiHat, b.caSi.tenCaSi, b.theLoai.tenTheLoai, b.album.tenAlbum, b.khuVucNhac.tenKhuVuc, b.urlHinh, b.urlFile, b.ngayPhatHanh) " +
            "FROM BaiHat b WHERE b.tenBaiHat LIKE %:tenBaiHat%")
    List<BaiHat_GetRespone> findByTenContainingIgnoreCase(@Param("tenBaiHat") String tenBaiHat);


}
