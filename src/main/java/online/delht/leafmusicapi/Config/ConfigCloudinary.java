package online.delht.leafmusicapi.Config;

import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ConfigCloudinary {
    @Bean
    public Cloudinary cloudinary() {
        Map<String, String> config = new HashMap<>();
        config.put("cloud_name", "cloud_name");
        config.put("api_key", "api_key");
        config.put("api_secret", "api_secret");
        return new Cloudinary(config);
    }
}