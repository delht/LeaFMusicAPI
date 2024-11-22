package online.delht.leafmusicapi.Repository;

import online.delht.leafmusicapi.Entity.BaiHat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BaiHatRepository extends JpaRepository<BaiHat, String> {
    boolean existsBaiHatByTenBaiHat(String tenBaiHat);
    Optional<BaiHat> findByTenBaiHat(String tenBaiHat);

}
