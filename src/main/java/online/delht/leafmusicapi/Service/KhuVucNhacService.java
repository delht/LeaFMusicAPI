package online.delht.leafmusicapi.Service;

import online.delht.leafmusicapi.Entity.KhuVucNhac;
import online.delht.leafmusicapi.Repository.KhuVucNhacRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhuVucNhacService {

    private final KhuVucNhacRepository khuvucNhacRepository;

    public KhuVucNhacService(KhuVucNhacRepository khuvucNhacRepository) {
        this.khuvucNhacRepository = khuvucNhacRepository;
    }

    public List<KhuVucNhac> getAllKhuVucNhac() {
        return khuvucNhacRepository.findAll();
    }

    public KhuVucNhac getKhuVucNhacById(Integer id) {
        return khuvucNhacRepository.findById(id).orElse(null);
    }
}
