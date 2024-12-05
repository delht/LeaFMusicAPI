package online.delht.leafmusicapi.Repository;

import online.delht.leafmusicapi.Entity.Album;
import online.delht.leafmusicapi.Entity.TheLoai;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TheLoaiRepository extends JpaRepository<TheLoai, String> {

    boolean existsTheLoaiByTenTheLoai(String tenTheLoai);

    @EntityGraph(attributePaths = {"baiHats"})
    Optional<TheLoai> findById(@Param("id") String id);
}
