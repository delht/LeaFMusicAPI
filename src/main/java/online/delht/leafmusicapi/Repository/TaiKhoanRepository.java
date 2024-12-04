package online.delht.leafmusicapi.Repository;

import online.delht.leafmusicapi.Entity.TaiKhoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaiKhoanRepository extends JpaRepository<TaiKhoan, String> {
    boolean existsByUsername(String username);
    Optional<TaiKhoan> findByUsername(String username);
}
