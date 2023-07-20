package bg.softuni.errors.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.Properties;

@Configuration
public class ErrorConfig {

  @Bean
  public SimpleMappingExceptionResolver simpleMappingExceptionResolver() {
    SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();

    Properties properties = new Properties();
    properties.setProperty(NullPointerException.class.getSimpleName(), "npe");

    resolver.setExceptionMappings(properties);

    return resolver;
  }

}
