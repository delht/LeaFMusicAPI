package online.delht.leafmusicapi.Config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfig { //Chuyen doi timelocal thanh mang obj chua cac gia tri thoi gian
    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule()); //  JavaTimeModule hỗ trợ LocalDateTime
        return objectMapper;
    }
}
