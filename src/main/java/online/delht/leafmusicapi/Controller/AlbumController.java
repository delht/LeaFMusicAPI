package online.delht.leafmusicapi.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import online.delht.leafmusicapi.Entity.Album;
import online.delht.leafmusicapi.Service.AlbumService;
import online.delht.leafmusicapi.dto.reponse.Album_Respone.Album_BaiHat_Respone;
import online.delht.leafmusicapi.dto.reponse.Album_Respone.Album_List;
import online.delht.leafmusicapi.dto.reponse.CaSi_Respone.CaSi_List;
import online.delht.leafmusicapi.dto.request.Album_Request;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor //bo autowired
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/album")
public class AlbumController {
    AlbumService albumService;

    @GetMapping("/get/id={id}")
    ResponseEntity<Album_BaiHat_Respone> getAlbumId(@PathVariable String id) {
        Album_BaiHat_Respone album = albumService.getAlbumBaiHat(id);
        if (album == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(album);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addAlbum(
            @RequestParam("img") MultipartFile img, @RequestParam("album") String albumRequestJson) { // Dùng String cho dữ liệu JSON
        try {
            System.out.println("Data Json: " + albumRequestJson);
            System.out.println("Data img: " + img.getOriginalFilename());
//            System.out.println("testController");

            Album_Request albumRequest;
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                albumRequest = objectMapper.readValue(albumRequestJson, Album_Request.class);
                System.out.println("Parsed Album_Request: " + albumRequest);
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Loi Album_Request: " + e.getMessage());
            }

            Album album = albumService.addAlbum(img, albumRequest);

            System.out.println("Da them album: " + album);

            return ResponseEntity.ok(album);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Có lỗi khi xử lý file ảnh Controller");
        }
    }

    @DeleteMapping("/delete/id={id}")
    public ResponseEntity<?> deleteAlbum(@PathVariable("id") String id) {
        try {
            albumService.deleteAlbum(id);
            return ResponseEntity.ok().build();
        }catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("/update/id={id}")
    public ResponseEntity<?> updateAlbum(
            @PathVariable("id") String id,
            @RequestParam("img") MultipartFile img,
            @RequestParam("album") String albumRequestJson) {
        try {
            System.out.println("Data Json: " + albumRequestJson);
            System.out.println("Data img: " + img.getOriginalFilename());

            // Chuyển đổi dữ liệu JSON thành đối tượng Album_Request
            Album_Request albumRequest;
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                albumRequest = objectMapper.readValue(albumRequestJson, Album_Request.class);
                System.out.println("Parsed Album_Request: " + albumRequest);
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Lỗi Album_Request: " + e.getMessage());
            }

            Album album = albumService.updateAlbum(id, img, albumRequest);

            System.out.println("Đã cập nhật album: " + album);

            return ResponseEntity.ok(albumRequest);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Có lỗi khi xử lý file ảnh Controller");
        }
    }

//========================================================================================================

    @GetMapping("/all")
    public List<Album_List> getAllAlbum() {
        return albumService.getAllAlbums();
    }

}
