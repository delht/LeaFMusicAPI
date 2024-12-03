package online.delht.leafmusicapi.Controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import online.delht.leafmusicapi.Service.AlbumService;
import online.delht.leafmusicapi.dto.reponse.Album_Respone.Album_BaiHat_Respone;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
