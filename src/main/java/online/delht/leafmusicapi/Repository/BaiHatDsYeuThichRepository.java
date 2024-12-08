package online.delht.leafmusicapi.Repository;

import online.delht.leafmusicapi.Entity.BaiHat;
import online.delht.leafmusicapi.Entity.BaiHatDsYeuThich;
import online.delht.leafmusicapi.Entity.DsYeuThich;
import org.springframework.data.jpa.repository.JpaRepository;
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

}
