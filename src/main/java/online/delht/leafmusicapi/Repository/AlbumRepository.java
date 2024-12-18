package online.delht.leafmusicapi.Repository;

import online.delht.leafmusicapi.Entity.Album;
import online.delht.leafmusicapi.dto.reponse.Album_Respone.Album_Respone;
import online.delht.leafmusicapi.dto.reponse.SearchResult;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlbumRepository extends JpaRepository<Album, String> {

    boolean existsAlbumByTenAlbum(String tenAlbum);

    @EntityGraph(attributePaths = {"baiHats"})
    Optional<Album> findById(@Param("id") String id);

//    =============================================

    @Query("SELECT new online.delht.leafmusicapi.dto.reponse.SearchResult(al.idAlbum, al.tenAlbum, 'album') " +
            "FROM Album al WHERE al.tenAlbum LIKE %:query%")
    List<SearchResult> searchAlbums(@Param("query") String query);

}
