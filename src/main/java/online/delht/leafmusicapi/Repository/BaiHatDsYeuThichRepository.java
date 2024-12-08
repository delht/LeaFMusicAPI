package online.delht.leafmusicapi.Repository;

import online.delht.leafmusicapi.Entity.BaiHat;
import online.delht.leafmusicapi.Entity.BaiHatDsYeuThich;
import online.delht.leafmusicapi.Entity.DsYeuThich;
import online.delht.leafmusicapi.dto.reponse.BaiHat_Respone.BaiHat_DS_YeuThich;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface BaiHatDsYeuThichRepository extends JpaRepository<BaiHatDsYeuThich, String> {
    List<BaiHatDsYeuThich> findByDsYeuThich_IdDanhSach(Integer idDsYeuThich);

    boolean existsByDsYeuThich_IdDanhSachAndBaiHat_IdBaiHat(Integer idDsYeuThich, Integer idBaiHat);

    void deleteByDsYeuThich_IdDanhSachAndBaiHat_IdBaiHat(Integer idDsYeuThich, Integer idBaiHat);

    BaiHatDsYeuThich save(BaiHatDsYeuThich baiHatDsYeuThich);

    Optional<BaiHatDsYeuThich> findByDsYeuThichAndBaiHat(DsYeuThich dsYeuThich, BaiHat baiHat);





//    @Query("SELECT b FROM BaiHat b WHERE b.idBaiHat IN (SELECT bdy.baiHat.idBaiHat FROM BaiHatDsYeuThich bdy WHERE bdy.dsYeuThich.idDanhSach = :idDs)")
//    List<BaiHat_DS_YeuThich> findBaiHatByIdDanhSach(@Param("idDs") Integer idDs);

//    @Query("SELECT new online.delht.leafmusicapi.dto.reponse.BaiHat_Respone.BaiHat_DS_YeuThich(b.idBaiHat, b.tenBaiHat, b.urlFile) " +
//            "FROM BaiHat b " +
//            "WHERE b.idBaiHat IN (SELECT bdy.baiHat.idBaiHat FROM BaiHatDsYeuThich bdy WHERE bdy.dsYeuThich.idDanhSach = :idDs)")
//    List<BaiHat_DS_YeuThich> findBaiHatByIdDanhSach(@Param("idDs") Integer idDs);

    @Query("SELECT new online.delht.leafmusicapi.dto.reponse.BaiHat_Respone.BaiHat_DS_YeuThich(b.idBaiHat, b.tenBaiHat, b.urlFile) " +
            "FROM BaiHat b " +
            "JOIN BaiHatDsYeuThich bdy ON b.idBaiHat = bdy.baiHat.idBaiHat " +
            "WHERE bdy.dsYeuThich.idDanhSach = :idDs")
    List<BaiHat_DS_YeuThich> findBaiHatByIdDanhSach(@Param("idDs") Integer idDs);

}
