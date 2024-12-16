package online.delht.leafmusicapi.Service;

import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import online.delht.leafmusicapi.Entity.BaiHat;
import online.delht.leafmusicapi.Entity.BaiHatDsYeuThich;
import online.delht.leafmusicapi.Entity.DsYeuThich;
import online.delht.leafmusicapi.Entity.TaiKhoan;
import online.delht.leafmusicapi.Repository.BaiHatDsYeuThichRepository;
import online.delht.leafmusicapi.Repository.BaiHatRepository;
import online.delht.leafmusicapi.Repository.DsYeuThichRepository;
import online.delht.leafmusicapi.Repository.TaiKhoanRepository;
import online.delht.leafmusicapi.dto.reponse.DsYeuThich_Respone.DsMacDinh_Respone;
import online.delht.leafmusicapi.dto.request.BaiHatDsYeuThich_Request;
import online.delht.leafmusicapi.dto.request.DsYeuThich_Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j

public class DsYeuThichService {
//    @Autowired
//    private DsYeuThichRepository dsYeuThichRepository;
//
//    @Autowired
//    private BaiHatRepository baiHatRepository;
//
//    public List<BaiHat> getLikedSongs(Integer idTaiKhoan) {
//        List<DsYeuThich> dsYeuThichList = dsYeuThichRepository.findByTaiKhoan_IdTaiKhoan(idTaiKhoan);
//        return dsYeuThichList.stream()
//                .map(dsYeuThich -> dsYeuThich.getBaiHat())
//                .collect(Collectors.toList());
//    }
//
//    public List<DsYeuThich> findByTaiKhoan_IdTaiKhoan(Integer idTaiKhoan) {
//        return dsYeuThichRepository.findByTaiKhoan_IdTaiKhoan(idTaiKhoan);
//    }
//
////    ============================================================
//
//    public void saveDsYeuThich(DsYeuThich dsYeuThich) {
//        dsYeuThichRepository.save(dsYeuThich);
//    }
//
//    public boolean deleteBaiHatYeuThich(Integer idTaiKhoan, Integer idBaiHat) {
//        DsYeuThich dsYeuThich = dsYeuThichRepository.findByTaiKhoan_IdTaiKhoanAndBaiHat_IdBaiHat(idTaiKhoan, idBaiHat);
//
//        if (dsYeuThich != null) {
//            dsYeuThichRepository.delete(dsYeuThich);
//            return true;
//        }
//        return false;
//    }

    DsYeuThichRepository dsYeuThichRepository;
    BaiHatRepository baiHatRepository;
    BaiHatDsYeuThichRepository baiHatDsYeuThichRepository;
    TaiKhoanRepository taiKhoanRepository;


//    public void addBaiHatToMacDinh(int idBaiHat, int idTaiKhoan) {
//        DsYeuThich dsYeuThich = dsYeuThichRepository.findByTaiKhoanAndLoaiDs(idTaiKhoan, DsYeuThich.LoaiDanhSach.macdinh);
//
//
//        BaiHatDsYeuThich baiHatDsYeuThich = new BaiHatDsYeuThich();
//        baiHatDsYeuThich.setDsYeuThich(dsYeuThich);
//        baiHatDsYeuThich.setBaiHat(baiHatRepository.findById(String.valueOf(idBaiHat)).orElseThrow());  // Gán bài hát
//
//        baiHatDsYeuThichRepository.save(baiHatDsYeuThich);
//    }

//    @Transactional
//    public void themBaiHatVaoDanhSachYeuThich(Integer idDanhSachYeuThich, Integer idBaiHat) {
//        // Lấy danh sách yêu thích theo idDanhSachYeuThich
//        DsYeuThich dsYeuThich = dsYeuThichRepository.findById(String.valueOf(idDanhSachYeuThich))
//                .orElseThrow(() -> new RuntimeException("Danh sách yêu thích không tồn tại"));
//
//        // Kiểm tra xem danh sách có loại là 'macdinh' hay không
//        if (!dsYeuThich.getLoaiDs().equals(DsYeuThich.LoaiDanhSach.macdinh)) {
//            throw new RuntimeException("Danh sách yêu thích không phải loại mặc định");
//        }
//
//        // Lấy bài hát theo id
//        BaiHat baiHat = baiHatRepository.findById(String.valueOf(idBaiHat))
//                .orElseThrow(() -> new RuntimeException("Bài hát không tồn tại"));
//
//        // Kiểm tra xem bài hát đã có trong danh sách yêu thích chưa
//        Optional<BaiHatDsYeuThich> baiHatDaCo = baiHatDsYeuThichRepository.findByDsYeuThichAndBaiHat(dsYeuThich, baiHat);
//        if (baiHatDaCo.isPresent()) {
//            throw new RuntimeException("Bài hát đã có trong danh sách yêu thích");
//        }
//
//        // Tạo mới đối tượng BaiHatDsYeuThich để liên kết bài hát và danh sách yêu thích
//        BaiHatDsYeuThich baiHatDsYeuThich = new BaiHatDsYeuThich();
//        baiHatDsYeuThich.setDsYeuThich(dsYeuThich);
//        baiHatDsYeuThich.setBaiHat(baiHat);
//
//        // Lưu vào bảng BaiHatDsYeuThich
//        baiHatDsYeuThichRepository.save(baiHatDsYeuThich);
//    }

//    =========================================================================================

    public void addBaiHatToYeuThichMacDinh(BaiHatDsYeuThich_Request request) {
        // Kiểm tra xem id_ds có thuộc loại "macdinh" không
        Optional<DsYeuThich> dsYeuThichOptional = dsYeuThichRepository.findById(String.valueOf(request.getIdDs()));
        if (dsYeuThichOptional.isPresent()) {
            DsYeuThich dsYeuThich = dsYeuThichOptional.get();
            if (dsYeuThich.getLoaiDs() == DsYeuThich.LoaiDanhSach.macdinh) {
                // Kiểm tra xem bài hát có tồn tại trong bảng baihat không
                Optional<BaiHat> baiHatOptional = baiHatRepository.findById(String.valueOf(request.getIdBaihat()));
                if (baiHatOptional.isPresent()) {
                    BaiHat baiHat = baiHatOptional.get();

                    // Kiểm tra sự tồn tại của bài hát trong danh sách yêu thích
                    Optional<BaiHatDsYeuThich> baiHatDsYeuThichOptional = baiHatDsYeuThichRepository.findByDsYeuThichAndBaiHat(dsYeuThich, baiHat);
                    if (baiHatDsYeuThichOptional.isPresent()) {
                        throw new RuntimeException("Bài hát đã có trong danh sách yêu thích.");
                    }

                    // Tạo và lưu đối tượng mới vào bảng baihat_ds_yeuthich
                    BaiHatDsYeuThich baiHatDsYeuThich = new BaiHatDsYeuThich();
                    baiHatDsYeuThich.setDsYeuThich(dsYeuThich);
                    baiHatDsYeuThich.setBaiHat(baiHat);
                    baiHatDsYeuThichRepository.save(baiHatDsYeuThich);
                } else {
                    throw new RuntimeException("Bài hát không tồn tại.");
                }
            } else {
                throw new RuntimeException("Danh sách yêu thích không phải loại 'macdinh'.");
            }
        } else {
            throw new RuntimeException("Danh sách yêu thích không tồn tại.");
        }
    }

    public void removeBaiHatFromYeuThichMacDinh(BaiHatDsYeuThich_Request request) {
        // Kiểm tra xem id_ds có thuộc loại "macdinh" không
        Optional<DsYeuThich> dsYeuThichOptional = dsYeuThichRepository.findById(String.valueOf(request.getIdDs()));
        if (dsYeuThichOptional.isPresent()) {
            DsYeuThich dsYeuThich = dsYeuThichOptional.get();
            if (dsYeuThich.getLoaiDs() == DsYeuThich.LoaiDanhSach.macdinh) {
                // Kiểm tra xem bài hát có tồn tại trong bảng baihat không
                Optional<BaiHat> baiHatOptional = baiHatRepository.findById(String.valueOf(request.getIdBaihat()));
                if (baiHatOptional.isPresent()) {
                    BaiHat baiHat = baiHatOptional.get();

                    // Kiểm tra sự tồn tại của bài hát trong danh sách yêu thích
                    Optional<BaiHatDsYeuThich> baiHatDsYeuThichOptional = baiHatDsYeuThichRepository.findByDsYeuThichAndBaiHat(dsYeuThich, baiHat);
                    if (baiHatDsYeuThichOptional.isPresent()) {
                        // Nếu tìm thấy bài hát trong danh sách yêu thích, xóa nó
                        BaiHatDsYeuThich baiHatDsYeuThich = baiHatDsYeuThichOptional.get();
                        baiHatDsYeuThichRepository.delete(baiHatDsYeuThich);
                    } else {
                        throw new RuntimeException("Bài hát không có trong danh sách yêu thích.");
                    }
                } else {
                    throw new RuntimeException("Bài hát không tồn tại.");
                }
            } else {
                throw new RuntimeException("Danh sách yêu thích không phải loại 'macdinh'.");
            }
        } else {
            throw new RuntimeException("Danh sách yêu thích không tồn tại.");
        }
    }


    public void removeBaiHatFromYeuThichMacDinh(String idDs, String idBaihat) {
        // Kiểm tra xem id_ds có thuộc loại "macdinh" không
        Optional<DsYeuThich> dsYeuThichOptional = dsYeuThichRepository.findById(idDs);
        if (dsYeuThichOptional.isPresent()) {
            DsYeuThich dsYeuThich = dsYeuThichOptional.get();
            if (dsYeuThich.getLoaiDs() == DsYeuThich.LoaiDanhSach.macdinh) {
                // Kiểm tra xem bài hát có tồn tại trong bảng baihat không
                Optional<BaiHat> baiHatOptional = baiHatRepository.findById(idBaihat);
                if (baiHatOptional.isPresent()) {
                    BaiHat baiHat = baiHatOptional.get();

                    // Kiểm tra sự tồn tại của bài hát trong danh sách yêu thích
                    Optional<BaiHatDsYeuThich> baiHatDsYeuThichOptional = baiHatDsYeuThichRepository.findByDsYeuThichAndBaiHat(dsYeuThich, baiHat);
                    if (baiHatDsYeuThichOptional.isPresent()) {
                        // Nếu tìm thấy bài hát trong danh sách yêu thích, xóa nó
                        BaiHatDsYeuThich baiHatDsYeuThich = baiHatDsYeuThichOptional.get();
                        baiHatDsYeuThichRepository.delete(baiHatDsYeuThich);
                    } else {
                        throw new RuntimeException("Bài hát không có trong danh sách yêu thích.");
                    }
                } else {
                    throw new RuntimeException("Bài hát không tồn tại.");
                }
            } else {
                throw new RuntimeException("Danh sách yêu thích không phải loại 'macdinh'.");
            }
        } else {
            throw new RuntimeException("Danh sách yêu thích không tồn tại.");
        }
    }



//    =========================================================================================

    public void createDsYeuThich(DsYeuThich_Request request) {
        // Kiểm tra xem tài khoản có tồn tại hay không
        TaiKhoan taiKhoan = taiKhoanRepository.findById(String.valueOf(request.getIdTaiKhoan()))
                .orElseThrow(() -> new RuntimeException("Tài khoản không tồn tại"));

        // Tạo mới đối tượng DsYeuThich
        DsYeuThich dsYeuThich = new DsYeuThich();
        dsYeuThich.setTenDs(request.getTenDs());
        dsYeuThich.setTaiKhoan(taiKhoan);

        // Set giá trị loaiDs mặc định là 'custom'
        dsYeuThich.setLoaiDs(DsYeuThich.LoaiDanhSach.custom);

        // Lưu vào cơ sở dữ liệu
        dsYeuThichRepository.save(dsYeuThich);
    }

    public void deleteDsYeuThich(Integer idDs) {
        // Kiểm tra xem danh sách yêu thích có tồn tại không
        DsYeuThich dsYeuThich = dsYeuThichRepository.findById(String.valueOf(idDs))
                .orElseThrow(() -> new RuntimeException("Danh sách yêu thích không tồn tại"));

        // Xóa danh sách yêu thích
        dsYeuThichRepository.delete(dsYeuThich);
    }

    public void updateTenDs(Integer idDs, String tenDs) {
        // Tìm danh sách yêu thích theo id_ds
        DsYeuThich dsYeuThich = dsYeuThichRepository.findById(String.valueOf(idDs))
                .orElseThrow(() -> new RuntimeException("Danh sách yêu thích không tồn tại"));

        // Cập nhật tên danh sách yêu thích
        dsYeuThich.setTenDs(tenDs);

        // Lưu lại vào cơ sở dữ liệu
        dsYeuThichRepository.save(dsYeuThich);
    }


//    =======================

    public void addBaiHatToYeuThichCustom(BaiHatDsYeuThich_Request request) {
        // Kiểm tra xem id_ds có thuộc loại "custom" không
        Optional<DsYeuThich> dsYeuThichOptional = dsYeuThichRepository.findById(String.valueOf(request.getIdDs()));
        if (dsYeuThichOptional.isPresent()) {
            DsYeuThich dsYeuThich = dsYeuThichOptional.get();
            if (dsYeuThich.getLoaiDs() == DsYeuThich.LoaiDanhSach.custom) {
                // Kiểm tra xem bài hát có tồn tại trong bảng baihat không
                Optional<BaiHat> baiHatOptional = baiHatRepository.findById(String.valueOf(request.getIdBaihat()));
                if (baiHatOptional.isPresent()) {
                    BaiHat baiHat = baiHatOptional.get();

                    // Kiểm tra sự tồn tại của bài hát trong danh sách yêu thích
                    Optional<BaiHatDsYeuThich> baiHatDsYeuThichOptional = baiHatDsYeuThichRepository.findByDsYeuThichAndBaiHat(dsYeuThich, baiHat);
                    if (baiHatDsYeuThichOptional.isPresent()) {
                        throw new RuntimeException("Bài hát đã có trong danh sách yêu thích.");
                    }

                    // Tạo và lưu đối tượng mới vào bảng baihat_ds_yeuthich
                    BaiHatDsYeuThich baiHatDsYeuThich = new BaiHatDsYeuThich();
                    baiHatDsYeuThich.setDsYeuThich(dsYeuThich);
                    baiHatDsYeuThich.setBaiHat(baiHat);
                    baiHatDsYeuThichRepository.save(baiHatDsYeuThich);
                } else {
                    throw new RuntimeException("Bài hát không tồn tại.");
                }
            } else {
                throw new RuntimeException("Danh sách yêu thích không phải loại 'custom'.");
            }
        } else {
            throw new RuntimeException("Danh sách yêu thích không tồn tại.");
        }
    }


    public void addBaiHatToYeuThichCustom(String idDs, String idBaihat) {
        // Kiểm tra xem id_ds có thuộc loại "custom" không
        Optional<DsYeuThich> dsYeuThichOptional = dsYeuThichRepository.findById(String.valueOf(idDs));
        if (dsYeuThichOptional.isPresent()) {
            DsYeuThich dsYeuThich = dsYeuThichOptional.get();
            if (dsYeuThich.getLoaiDs() == DsYeuThich.LoaiDanhSach.custom) {
                // Kiểm tra xem bài hát có tồn tại trong bảng baihat không
                Optional<BaiHat> baiHatOptional = baiHatRepository.findById(String.valueOf(idBaihat));
                if (baiHatOptional.isPresent()) {
                    BaiHat baiHat = baiHatOptional.get();

                    // Kiểm tra sự tồn tại của bài hát trong danh sách yêu thích
                    Optional<BaiHatDsYeuThich> baiHatDsYeuThichOptional = baiHatDsYeuThichRepository.findByDsYeuThichAndBaiHat(dsYeuThich, baiHat);
                    if (baiHatDsYeuThichOptional.isPresent()) {
                        throw new RuntimeException("Bài hát đã có trong danh sách yêu thích.");
                    }

                    // Tạo và lưu đối tượng mới vào bảng baihat_ds_yeuthich
                    BaiHatDsYeuThich baiHatDsYeuThich = new BaiHatDsYeuThich();
                    baiHatDsYeuThich.setDsYeuThich(dsYeuThich);
                    baiHatDsYeuThich.setBaiHat(baiHat);
                    baiHatDsYeuThichRepository.save(baiHatDsYeuThich);
                } else {
                    throw new RuntimeException("Bài hát không tồn tại.");
                }
            } else {
                throw new RuntimeException("Danh sách yêu thích không phải loại 'custom'.");
            }
        } else {
            throw new RuntimeException("Danh sách yêu thích không tồn tại.");
        }
    }


    public void removeBaiHatFromYeuThichCustom(BaiHatDsYeuThich_Request request) {
        // Kiểm tra xem id_ds có thuộc loại "custom" không
        Optional<DsYeuThich> dsYeuThichOptional = dsYeuThichRepository.findById(String.valueOf(request.getIdDs()));
        if (dsYeuThichOptional.isPresent()) {
            DsYeuThich dsYeuThich = dsYeuThichOptional.get();
            if (dsYeuThich.getLoaiDs() == DsYeuThich.LoaiDanhSach.custom) {
                // Kiểm tra xem bài hát có tồn tại trong bảng baihat không
                Optional<BaiHat> baiHatOptional = baiHatRepository.findById(String.valueOf(request.getIdBaihat()));
                if (baiHatOptional.isPresent()) {
                    BaiHat baiHat = baiHatOptional.get();

                    // Kiểm tra sự tồn tại của bài hát trong danh sách yêu thích
                    Optional<BaiHatDsYeuThich> baiHatDsYeuThichOptional = baiHatDsYeuThichRepository.findByDsYeuThichAndBaiHat(dsYeuThich, baiHat);
                    if (baiHatDsYeuThichOptional.isPresent()) {
                        // Nếu tìm thấy bài hát trong danh sách yêu thích, xóa nó
                        BaiHatDsYeuThich baiHatDsYeuThich = baiHatDsYeuThichOptional.get();
                        baiHatDsYeuThichRepository.delete(baiHatDsYeuThich);
                    } else {
                        throw new RuntimeException("Bài hát không có trong danh sách yêu thích.");
                    }
                } else {
                    throw new RuntimeException("Bài hát không tồn tại.");
                }
            } else {
                throw new RuntimeException("Danh sách yêu thích không phải loại 'custom'.");
            }
        } else {
            throw new RuntimeException("Danh sách yêu thích không tồn tại.");
        }
    }

    public void removeBaiHatFromYeuThichCustom(String idDs, String idBaihat) {
        // Kiểm tra xem id_ds có thuộc loại "custom" không
        Optional<DsYeuThich> dsYeuThichOptional = dsYeuThichRepository.findById(String.valueOf(idDs));
        if (dsYeuThichOptional.isPresent()) {
            DsYeuThich dsYeuThich = dsYeuThichOptional.get();
            if (dsYeuThich.getLoaiDs() == DsYeuThich.LoaiDanhSach.custom) {
                // Kiểm tra xem bài hát có tồn tại trong bảng baihat không
                Optional<BaiHat> baiHatOptional = baiHatRepository.findById(String.valueOf(idBaihat));
                if (baiHatOptional.isPresent()) {
                    BaiHat baiHat = baiHatOptional.get();

                    // Kiểm tra sự tồn tại của bài hát trong danh sách yêu thích
                    Optional<BaiHatDsYeuThich> baiHatDsYeuThichOptional = baiHatDsYeuThichRepository.findByDsYeuThichAndBaiHat(dsYeuThich, baiHat);
                    if (baiHatDsYeuThichOptional.isPresent()) {
                        // Nếu tìm thấy bài hát trong danh sách yêu thích, xóa nó
                        BaiHatDsYeuThich baiHatDsYeuThich = baiHatDsYeuThichOptional.get();
                        baiHatDsYeuThichRepository.delete(baiHatDsYeuThich);
                    } else {
                        throw new RuntimeException("Bài hát không có trong danh sách yêu thích.");
                    }
                } else {
                    throw new RuntimeException("Bài hát không tồn tại.");
                }
            } else {
                throw new RuntimeException("Danh sách yêu thích không phải loại 'custom'.");
            }
        } else {
            throw new RuntimeException("Danh sách yêu thích không tồn tại.");
        }
    }

//    ================================================================================

    public List<DsMacDinh_Respone> getDsYeuThichMacDinhByTaiKhoan(Integer idTaiKhoan) {
        return dsYeuThichRepository.findByLoaiDsAndTaiKhoanId(DsYeuThich.LoaiDanhSach.macdinh, idTaiKhoan);
    }

    public List<DsMacDinh_Respone> getDsYeuThichCustomByTaiKhoan(Integer idTaiKhoan) {
        return dsYeuThichRepository.findByLoaiDsAndTaiKhoanId(DsYeuThich.LoaiDanhSach.custom, idTaiKhoan);
    }

}
