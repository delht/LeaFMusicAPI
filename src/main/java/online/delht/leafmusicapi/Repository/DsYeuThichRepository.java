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

}
