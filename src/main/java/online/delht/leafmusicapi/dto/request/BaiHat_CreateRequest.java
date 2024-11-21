package online.delht.leafmusicapi.dto.request;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import online.delht.leafmusicapi.Entity.Album;
import online.delht.leafmusicapi.Entity.CaSi;
import online.delht.leafmusicapi.Entity.KhuVucNhac;
import online.delht.leafmusicapi.Entity.TheLoai;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaiHat_CreateRequest {

    private String tenBaiHat;
    private CaSi caSi;
    private TheLoai theLoai;
    private Album album;
    private KhuVucNhac khuVucNhac;
    private String urlHinh;
    private String urlFile;
    private LocalDateTime ngayPhatHanh;

}
