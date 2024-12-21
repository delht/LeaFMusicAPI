package online.delht.leafmusicapi.Repository;

import online.delht.leafmusicapi.Entity.CaSi;
import online.delht.leafmusicapi.dto.reponse.SearchResult;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CaSiRepository extends JpaRepository<CaSi, String> {

    boolean existsBaiHatByTenCaSi(String tenCaSi);
    boolean existsBaiHatByIdCaSi(int idCaSi);

    //Album
    @EntityGraph(attributePaths = {"albums"})
    Optional<CaSi> findTenCaSiWithAlbumsByTenCaSi(@Param("name") String tenCaSi);

    //BaiHat
    @EntityGraph(attributePaths = {"baiHats"})
    Optional<CaSi> findTenCaSiWithBaiHatsByTenCaSi(@Param("name") String tenCaSi);

//    ====================================================
@Query("SELECT new online.delht.leafmusicapi.dto.reponse.SearchResult(a.idCaSi, a.tenCaSi, 'casi', a.urlHinh) " +
        "FROM CaSi a WHERE a.tenCaSi LIKE %:query%")
List<SearchResult> searchArtists(@Param("query") String query);



}
