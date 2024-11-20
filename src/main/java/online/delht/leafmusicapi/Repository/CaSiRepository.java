package online.delht.leafmusicapi.Repository;

import online.delht.leafmusicapi.Entity.CaSi;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CaSiRepository extends JpaRepository<CaSi, String> {

    //Album
    /*@Query("SELECT c FROM CaSi c LEFT JOIN FETCH c.albums WHERE c.idCaSi = :id")
    Optional<CaSi> findByIdWithAlbums(@Param("id") String id);*/
    //  @EntityGraph(attributePaths = {"albums"})
    //  Optional<CaSi> findById_Album(@Param("id") String id);
    @EntityGraph(attributePaths = {"albums"})
    Optional<CaSi> findTenCaSiWithAlbumsByTenCaSi(@Param("name") String tenCaSi);

    //BaiHat
    //@EntityGraph(attributePaths = {"baiHats.theLoai", "baiHats.album", "baiHats.khuVucNhac"})
    @EntityGraph(attributePaths = {"baiHats"})
    Optional<CaSi> findTenCaSiWithBaiHatsByTenCaSi(@Param("name") String tenCaSi);
}
