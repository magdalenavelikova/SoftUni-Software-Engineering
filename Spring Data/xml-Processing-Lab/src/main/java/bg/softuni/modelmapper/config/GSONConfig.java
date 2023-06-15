package bg.softuni.modelmapper.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GSONConfig {
    @Bean
    public GsonBuilder gsonBuilder(){
        return new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation();

    }

}
