package bg.softuni.errors.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends RuntimeException{

  private final Long id;

  public ProductNotFoundException(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }
}
