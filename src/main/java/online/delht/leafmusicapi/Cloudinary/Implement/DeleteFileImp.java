package online.delht.leafmusicapi.Cloudinary.Implement;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import online.delht.leafmusicapi.Cloudinary.DeleteFile;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class DeleteFileImp implements DeleteFile {

    private final Cloudinary cloudinary;

    @Override
    public void deleteFile(String publicId) throws IOException {
        try {
            log.info("xoa file vs Public ID: {}", publicId);

            //Phuong thuc xoa tu thu vieen cloadinary
            Map response = cloudinary.uploader().destroy(publicId, ObjectUtils.asMap("resource_type", "raw"));
            log.info("Response tu Cloudinary: {}", response);

            if (!"ok".equals(response.get("result"))) { //ket qua tra ve la "ok"
                throw new RuntimeException("Cloudinary ko xoa dc file. Response: " + response);
            }

        } catch (IOException e) {
            log.error("ko the xoa file vs Public ID {}: {}", publicId, e.getMessage());
            throw e;
        }
    }

}
