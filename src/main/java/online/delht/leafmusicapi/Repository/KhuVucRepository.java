package online.delht.leafmusicapi.Repository;

import online.delht.leafmusicapi.Entity.KhuVucNhac;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KhuVucRepository extends JpaRepository<KhuVucNhac, String> {

    boolean existsByTenKhuVuc(String tenKhuVuc);

    @EntityGraph(attributePaths = {"baiHats"})
    Optional<KhuVucNhac> findById(String id);


}
