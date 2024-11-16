package online.delht.leafmusicapi.Controller;

import online.delht.leafmusicapi.Entity.KhuVucNhac;
import online.delht.leafmusicapi.Service.KhuVucNhacService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KhuVucNhacController {

    private final KhuVucNhacService khuvucNhacService;

    public KhuVucNhacController(KhuVucNhacService khuvucNhacService) {
        this.khuvucNhacService = khuvucNhacService;
    }

    @GetMapping("/khuvuc")
    public List<KhuVucNhac> getAllKhuVucNhac() {
        return khuvucNhacService.getAllKhuVucNhac();
    }

    @GetMapping("/khuvuc/{id}")
    public KhuVucNhac getKhuVucNhacById(@PathVariable Integer id) {
        return khuvucNhacService.getKhuVucNhacById(id);
    }
}
