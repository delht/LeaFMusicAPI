package online.delht.leafmusicapi.Service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import online.delht.leafmusicapi.Entity.TheLoai;
import online.delht.leafmusicapi.Mapper.TheLoaiMapper;
import online.delht.leafmusicapi.Repository.TheLoaiRepository;
import online.delht.leafmusicapi.dto.reponse.TheLoai_Respone.TheLoai_BaiHat_Respone;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor //bo autowired
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TheLoaiService {
    TheLoaiRepository theLoaiRepository;
    TheLoaiMapper theLoaiMapper;

    public TheLoai_BaiHat_Respone getTheLoaiBaiHat(String id) {
        TheLoai theLoai = theLoaiRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Khong co the loai theo id nay"));
        return theLoaiMapper.to_TheLoai_BaiHat_Respone(theLoai);
    }
}
