package online.delht.leafmusicapi.Controller;


import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import online.delht.leafmusicapi.Entity.Album;
import online.delht.leafmusicapi.Entity.BaiHat;
import online.delht.leafmusicapi.Entity.CaSi;
import online.delht.leafmusicapi.Repository.AlbumRepository;
import online.delht.leafmusicapi.Repository.BaiHatRepository;
import online.delht.leafmusicapi.Repository.CaSiRepository;
import online.delht.leafmusicapi.dto.reponse.SearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/timkiem2")
public class SearchController {

    @Autowired
    private BaiHatRepository songRepository;

    @Autowired
    private CaSiRepository artistRepository;

    @Autowired
    private AlbumRepository albumRepository;

    // API tìm kiếm chung
    @GetMapping 
    public List<SearchResult> search(@RequestParam("query") String query) {
        List<SearchResult> results = new ArrayList<>();

        // Tìm kiếm bài hát
        List<SearchResult> songs = songRepository.searchSongs(query);
        results.addAll(songs);

        // Tìm kiếm ca sĩ
        List<SearchResult> artists = artistRepository.searchArtists(query);
        results.addAll(artists);

        // Tìm kiếm album
        List<SearchResult> albums = albumRepository.searchAlbums(query);
        results.addAll(albums);

        return results;
    }
}