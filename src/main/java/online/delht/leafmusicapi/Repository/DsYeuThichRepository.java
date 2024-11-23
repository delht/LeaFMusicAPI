package online.delht.leafmusicapi.Repository;

import online.delht.leafmusicapi.Entity.DsYeuThich;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DsYeuThichRepository extends JpaRepository<DsYeuThich, String> {
}
