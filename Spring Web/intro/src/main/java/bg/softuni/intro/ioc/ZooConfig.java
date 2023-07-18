package bg.softuni.intro.ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZooConfig {

  @Bean
  public Animal cat() {
    return new Cat();
  }

  @Bean("normalDog")
  public Animal dog() {
    return new Dog();
  }

  @Bean("mySuperDog")
  public Animal superDog() {
    //todo: add superpower to this dog
    return new Dog(true);
  }

}
