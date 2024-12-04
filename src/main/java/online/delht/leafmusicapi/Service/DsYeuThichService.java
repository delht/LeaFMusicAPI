package online.delht.leafmusicapi.Service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import online.delht.leafmusicapi.Entity.BaiHat;
import online.delht.leafmusicapi.Entity.DsYeuThich;
import online.delht.leafmusicapi.Repository.BaiHatRepository;
import online.delht.leafmusicapi.Repository.DsYeuThichRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j

public class DsYeuThichService {
    @Autowired
    private DsYeuThichRepository dsYeuThichRepository;

    @Autowired
    private BaiHatRepository baiHatRepository;

    public List<BaiHat> getLikedSongs(Integer idTaiKhoan) {
        List<DsYeuThich> dsYeuThichList = dsYeuThichRepository.findByTaiKhoan_IdTaiKhoan(idTaiKhoan);
        return dsYeuThichList.stream()
                .map(dsYeuThich -> dsYeuThich.getBaiHat())
                .collect(Collectors.toList());
    }

    public List<DsYeuThich> findByTaiKhoan_IdTaiKhoan(Integer idTaiKhoan) {
        return dsYeuThichRepository.findByTaiKhoan_IdTaiKhoan(idTaiKhoan);
    }

//    ============================================================





}
