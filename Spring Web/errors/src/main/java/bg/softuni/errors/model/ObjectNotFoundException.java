package bg.softuni.errors.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ObjectNotFoundException extends RuntimeException{

  private final Long objectId;

  public ObjectNotFoundException(Long objectId) {

    this.objectId = objectId;
  }

  public Long getObjectId() {
    return objectId;
  }
}
