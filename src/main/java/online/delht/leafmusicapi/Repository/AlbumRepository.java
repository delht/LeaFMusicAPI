package online.delht.leafmusicapi.Repository;

import online.delht.leafmusicapi.Entity.Album;
import online.delht.leafmusicapi.dto.reponse.Album_Respone.Album_Respone;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlbumRepository extends JpaRepository<Album, String> {

    @EntityGraph(attributePaths = {"baiHats"})
    Optional<Album> findById(@Param("id") String album_id);
}
