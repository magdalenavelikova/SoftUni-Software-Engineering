package bg.softuni.intro.ioc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DemoZoo implements CommandLineRunner {

  private ZooService zooService;

  public DemoZoo(ZooService zooService) {
    this.zooService = zooService;
  }

  @Override
  public void run(String... args) throws Exception {
    zooService.doWork();
  }
}
