package online.delht.leafmusicapi.Repository;

import online.delht.leafmusicapi.Entity.KhuVucNhac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KhuVucNhacRepository extends JpaRepository<KhuVucNhac, Integer> {
}
