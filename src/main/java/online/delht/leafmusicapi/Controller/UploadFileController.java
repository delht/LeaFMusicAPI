package online.delht.leafmusicapi.Controller;

import lombok.RequiredArgsConstructor;
import online.delht.leafmusicapi.TestUpload.UploadFile;
import online.delht.leafmusicapi.TestUpload.UploadFile2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequestMapping("/upload")
@RestController
@RequiredArgsConstructor
public class UploadFileController {

    private final UploadFile uploadFile;

    @PostMapping("/file")
    public String uploadFile(@RequestParam("file")MultipartFile file) throws IOException {
        String urlFile= uploadFile.uploadFile(file);
        return urlFile;
    }


}
