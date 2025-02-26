package online.delht.leafmusicapi.Service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import online.delht.leafmusicapi.Entity.Album;
import online.delht.leafmusicapi.Entity.TheLoai;
import online.delht.leafmusicapi.Mapper.TheLoaiMapper;
import online.delht.leafmusicapi.Repository.TheLoaiRepository;
import online.delht.leafmusicapi.dto.reponse.Album_Respone.Album_List;
import online.delht.leafmusicapi.dto.reponse.TheLoai_Respone.TheLoai_BaiHat_Respone;
import online.delht.leafmusicapi.dto.reponse.TheLoai_Respone.TheLoai_Respone;
import online.delht.leafmusicapi.dto.request.TheLoai_Request;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TheLoaiService {
    TheLoaiRepository theLoaiRepository;
    TheLoaiMapper theLoaiMapper;

    public TheLoai_BaiHat_Respone getTheLoaiBaiHat(String id) {
        TheLoai theLoai = theLoaiRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Khong co the loai theo id nay"));
        return theLoaiMapper.to_TheLoai_BaiHat_Respone(theLoai);
    }

    public TheLoai addTheLoai(TheLoai_Request theLoaiRequest) throws IOException {
        if (theLoaiRepository.existsTheLoaiByTenTheLoai(theLoaiRequest.getTen_theloai())) {
            throw new RuntimeException("Tên thể loại đã tồn tại: " + theLoaiRequest.getTen_theloai());
        }
        TheLoai theLoai = new TheLoai();
        theLoai.setTenTheLoai(theLoaiRequest.getTen_theloai());
        return theLoaiRepository.save(theLoai);
    }

    public void deleteTheLoai(String id) throws IOException{
        if (!theLoaiRepository.existsById(id)){
            throw new RuntimeException("Khong co the loai theo id nay");
        }
        theLoaiRepository.deleteById(String.valueOf(id));
    }

    public TheLoai updateTheLoai(String id, TheLoai_Request theLoaiRequest) throws IOException {
        TheLoai theLoaiCu = theLoaiRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không có thể loại theo id này"));

        if (theLoaiRepository.existsTheLoaiByTenTheLoai(theLoaiRequest.getTen_theloai()) &&
                !theLoaiRequest.getTen_theloai().equals(theLoaiCu.getTenTheLoai())) {
            throw new RuntimeException("Tên thể loại đã tồn tại");
        }

        theLoaiCu.setTenTheLoai(theLoaiRequest.getTen_theloai());
        return theLoaiRepository.save(theLoaiCu);
    }

//    ======================================================

    public TheLoai_Respone getTheLoaiResponefindBY(String id) throws IOException {
        if (!theLoaiRepository.existsById(id)) {
            throw new RuntimeException("Không có thể loại theo id này");
        }
        TheLoai theLoai = theLoaiRepository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy thể loại"));

        TheLoai_Respone theLoaiRespone = new TheLoai_Respone();
        theLoaiRespone.setIdTheLoai(theLoai.getIdTheLoai());
        theLoaiRespone.setTenTheLoai(theLoai.getTenTheLoai());

        return theLoaiRespone;
    }

    public List<TheLoai_Respone> getAllTheLoai() {
        List<TheLoai_Respone> theLoaiRespones = new ArrayList<>();

        for (TheLoai theLoai : theLoaiRepository.findAll()) {
            TheLoai_Respone theLoaiRespone = TheLoai_Respone.builder()
                    .idTheLoai(theLoai.getIdTheLoai())
                    .tenTheLoai(theLoai.getTenTheLoai())
                    .build();
            theLoaiRespones.add(theLoaiRespone);
        }
        return theLoaiRespones;
    }


}
