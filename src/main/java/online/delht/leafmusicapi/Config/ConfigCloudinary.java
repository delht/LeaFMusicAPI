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
        config.put("cloud_name", "dw0rr01cm");
        config.put("api_key", "599532481659284");
        config.put("api_secret", "O-Nr5-IDi3kun7avda2RkdvgjSM");
        return new Cloudinary(config);
    }
}
