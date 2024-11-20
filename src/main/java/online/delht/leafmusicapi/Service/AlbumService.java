package online.delht.leafmusicapi.Service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import online.delht.leafmusicapi.Entity.Album;
import online.delht.leafmusicapi.Mapper.AlbumMapper;
import online.delht.leafmusicapi.Repository.AlbumRepository;
import online.delht.leafmusicapi.dto.reponse.Album_Respone.Album_BaiHat_Respone;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor //bo autowired
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AlbumService {
    AlbumRepository albumRepository;
    AlbumMapper albumMapper;

    public Album_BaiHat_Respone getAlbumBaiHat(String id) {
        Album album = albumRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Album not found"));
        return albumMapper.to_Album_BaiHat_Respone(album);
    }
}
