package bg.softuni.intro.ioc;

import java.util.List;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ZooService {

  private final Animal animal1;
  private final Animal animal2;

  public ZooService(@Qualifier("normalDog") Animal animal1,
      @Qualifier("cat") Animal animal2) {
    this.animal1 = animal1;
    this.animal2 = animal2;
  }

  public void doWork() {
    animal1.makeNoise();
    animal2.makeNoise();
  }

//  private List<Animal> animals;

//  public ZooService(List<Animal> animals) {
//    this.animals = animals;
//  }
//
//  public void doWork() {
//    animals.stream().forEach(
//        Animal::makeNoise
//    );
//  }
}
