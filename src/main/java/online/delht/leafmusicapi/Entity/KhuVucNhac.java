package online.delht.leafmusicapi.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "khuvuc_nhac") // Ánh xạ với bảng khuvuc_nhac
public class KhuVucNhac {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_khuvuc") // Ánh xạ với cột id_khuvuc
    private Integer idKhuVuc;

    @Column(name = "ten_khuvuc", nullable = false) // Ánh xạ với cột ten_khuvuc
    private String tenKhuVuc;

    // Getters and Setters
    public Integer getIdKhuVuc() {
        return idKhuVuc;
    }

    public void setIdKhuVuc(Integer idKhuVuc) {
        this.idKhuVuc = idKhuVuc;
    }

    public String getTenKhuVuc() {
        return tenKhuVuc;
    }

    public void setTenKhuVuc(String tenKhuVuc) {
        this.tenKhuVuc = tenKhuVuc;
    }
}
