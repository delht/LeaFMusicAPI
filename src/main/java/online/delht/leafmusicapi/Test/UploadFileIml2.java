package online.delht.leafmusicapi.Test;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class UploadFileIml2 implements UploadFile2 {

    private final Cloudinary cloudinary;

    @Override
    public String uploadFile(MultipartFile file) throws IOException {
        assert file.getOriginalFilename() != null;

        String publicValue = generatePublicValue(file.getOriginalFilename());
        log.info("Generated public value: {}", publicValue);
        String extension = getFileName(file.getOriginalFilename())[1];
        log.info("File extension: {}", extension);

        File fileToUpload = convert(file);
        log.info("Converted file: {}", fileToUpload);

        try {
            // Upload file to Cloudinary
            cloudinary.uploader().upload(fileToUpload, ObjectUtils.asMap(
                    "public_id", publicValue,
                    "resource_type", "raw" // Support for MP3 or any non-image files
            ));
        } finally {
            // Clean up temporary file after upload
            cleanDisk(fileToUpload);
        }

        // Generate file URL
        String fileUrl = cloudinary.url().resourceType("raw")
                .generate(StringUtils.join(publicValue, ".", extension));
        log.info("Uploaded file URL: {}", fileUrl);

        return fileUrl;
    }

    private File convert(MultipartFile file) throws IOException {
        assert file.getOriginalFilename() != null;
        String tempFileName = StringUtils.join(generatePublicValue(file.getOriginalFilename()), ".", getFileName(file.getOriginalFilename())[1]);
        File convFile = new File(tempFileName);

        try (InputStream is = file.getInputStream()) {
            Files.copy(is, convFile.toPath());
        }

        return convFile;
    }

    private void cleanDisk(File file) {
        try {
            log.info("Cleaning up temporary file: {}", file.toPath());
            Files.delete(file.toPath());
        } catch (IOException e) {
            log.error("Error cleaning up file: {}", e.getMessage());
        }
    }

    private String generatePublicValue(String originalName) {
        String fileName = getFileName(originalName)[0];
        return StringUtils.join(UUID.randomUUID().toString(), "_", fileName);
    }

    private String[] getFileName(String originalName) {
        return originalName.split("\\.");
    }
}


