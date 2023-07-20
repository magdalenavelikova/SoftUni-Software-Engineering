package bg.softuni.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class IncredibleMachine {

  private static final Logger LOGGER = LoggerFactory.getLogger(IncredibleMachine.class);

  public void saySomething() {
    LOGGER.info("I'm saying something!");
  }

  public void boom() {
    throw new NullPointerException("Ups, I did something wrong!");
  }

  public void echo(String whatToEcho) {
    LOGGER.info("I'm echoing this {}", whatToEcho);
  }

  public String concat(String a, String b) {
    return a + b;
  }
}
