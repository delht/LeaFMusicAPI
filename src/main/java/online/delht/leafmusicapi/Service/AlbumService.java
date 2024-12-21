package online.delht.leafmusicapi.Service;

import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import online.delht.leafmusicapi.Cloudinary.DeleteFile;
import online.delht.leafmusicapi.Cloudinary.UploadFile;
import online.delht.leafmusicapi.Entity.Album;
import online.delht.leafmusicapi.Entity.CaSi;
import online.delht.leafmusicapi.Mapper.AlbumMapper;
import online.delht.leafmusicapi.Repository.AlbumRepository;
import online.delht.leafmusicapi.Repository.CaSiRepository;
import online.delht.leafmusicapi.Utils.GetPubID_Util;
import online.delht.leafmusicapi.dto.reponse.Album_Respone.Album_BaiHat_Respone;
import online.delht.leafmusicapi.dto.reponse.Album_Respone.Album_List;
import online.delht.leafmusicapi.dto.reponse.CaSi_Respone.CaSi_List;
import online.delht.leafmusicapi.dto.request.Album_Request;
import online.delht.leafmusicapi.dto.request.CaSi_Resquest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor //bo autowired
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AlbumService {
    AlbumRepository albumRepository;
    AlbumMapper albumMapper;

    //lay album theo id
    public Album_BaiHat_Respone getAlbumBaiHat(String id) {
        Album album = albumRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Khong tim thay album"));
        return albumMapper.to_Album_BaiHat_Respone(album);
    }

    //    ================================== Xu ly file
    DeleteFile deleteFile;
    UploadFile uploadFile;
    GetPubID_Util getPubIDUtil;

    CaSiRepository CaSiRepository;

    @Transactional
    public Album addAlbum(MultipartFile img, Album_Request albumRequest) throws IOException {
        try {
            CaSi caSi = CaSiRepository.findById(String.valueOf(albumRequest.getId_casi()))
                    .orElseThrow(() -> new RuntimeException("khong co ca si vs album ID: " + albumRequest.getId_casi()));

            System.out.println("test");

            String folderImg = "LeaFMusic/Images/Album/";
            String fileUrlImg = uploadFile.uploadFile(img, folderImg);

            Album album = albumMapper.toAlbum(albumRequest);
            album.setCaSi(new CaSi(albumRequest.getId_casi()));
            album.setUrlHinh(fileUrlImg);

            System.out.println("Luu album: " + album.getTenAlbum() + ", Image URL: " + fileUrlImg);

            return albumRepository.save(album);
        } catch (IOException e) {
            throw new IOException("Error khi xu ly anh", e);
        }
    }

    public void deleteAlbum(String id) throws IOException {
        Album album = albumRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Khong tim thay album co id: "+id));

        String folderImg = "LeaFMusic/Images/Album/";
        String fileUrlImg = album.getUrlHinh();
        String publicIdImg = getPubIDUtil.layPublicIdTuURL(fileUrlImg, folderImg);

        log.info("Url file cần xóa {}", fileUrlImg);
        deleteFile.deleteFile(publicIdImg);

        albumRepository.delete(album);
        log.info("Album với ID {} đã được xóa thành công.", id);
    }

    public Album updateAlbum(String id, MultipartFile img, Album_Request request) throws IOException {
        Album albumCu = albumRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy album với ID: " + id));

        String oldImgUrl = albumCu.getUrlHinh();
        log.info("Url file cần xóa: {}", oldImgUrl);

        albumCu = albumMapper.toAlbum(request);

        if (img != null && !img.isEmpty()) {
            String folderImg = "LeaFMusic/Images/Album/";
            String fileUrlImg = uploadFile.uploadFile(img, folderImg);
            albumCu.setUrlHinh(fileUrlImg);

            String publicIdImg = getPubIDUtil.layPublicIdTuURL(oldImgUrl, folderImg);
            deleteFile.deleteFile(publicIdImg);
        } else {
            albumCu.setUrlHinh(albumCu.getUrlHinh());
        }

        CaSi caSiCu = albumCu.getCaSi();
        if (request.getId_casi() != 0 && (caSiCu == null || request.getId_casi() != caSiCu.getIdCaSi())) {
            CaSi caSi = CaSiRepository.findById(String.valueOf(request.getId_casi()))
                    .orElseThrow(() -> new RuntimeException("Ca sĩ không tồn tại với ID: " + request.getId_casi()));
            albumCu.setCaSi(caSi);
        }

        albumCu.setIdAlbum(Integer.valueOf(id));
        log.info("Đang cập nhật album: " + albumCu.getTenAlbum());

        return albumRepository.save(albumCu);
    }

//========================================================================================

    public List<Album_List> getAllAlbums() {
        List<Album_List> albumLists = new ArrayList<>();

        for (Album album : albumRepository.findAll()) {
            Album_List album_list = Album_List.builder()
                    .idAlbum(album.getIdAlbum())
                    .tenAlbum(album.getTenAlbum())
                    .urlHinh(album.getUrlHinh())
                    .build();
            albumLists.add(album_list);
        }
        return albumLists;
    }

}
