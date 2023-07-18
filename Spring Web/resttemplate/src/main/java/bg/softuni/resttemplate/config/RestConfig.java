package bg.softuni.resttemplate.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfig {

  @Bean
  public RestTemplate create(RestTemplateBuilder restTemplateBuilder) {
    return restTemplateBuilder.build();
  }

}
