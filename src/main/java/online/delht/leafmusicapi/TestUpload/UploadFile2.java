package online.delht.leafmusicapi.TestUpload;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UploadFile2 {
    String uploadFile(MultipartFile file) throws IOException;
}