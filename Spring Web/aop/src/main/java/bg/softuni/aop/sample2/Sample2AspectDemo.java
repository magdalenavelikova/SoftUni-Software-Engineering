package bg.softuni.aop.sample2;

import bg.softuni.aop.IncredibleMachine;
import bg.softuni.aop.sample1.Sample1AspectDemo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(
    value = "sample2.enabled",
    havingValue = "true"
)
public class Sample2AspectDemo implements CommandLineRunner {

  private static final Logger LOGGER = LoggerFactory.getLogger(Sample2AspectDemo.class);

  private final IncredibleMachine incredibleMachine;

  public Sample2AspectDemo(IncredibleMachine incredibleMachine) {

    this.incredibleMachine = incredibleMachine;
  }

  @Override
  public void run(String... args) throws Exception {
    LOGGER.info(incredibleMachine.concat("Hello, ", "world!"));
  }
}
