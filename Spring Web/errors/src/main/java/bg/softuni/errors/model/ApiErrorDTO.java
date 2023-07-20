package bg.softuni.errors.model;

public class ApiErrorDTO {

  private final Long objectId;
  private final String message;

  public ApiErrorDTO(Long objectId, String message) {
    this.objectId = objectId;
    this.message = message;
  }

  public Long getObjectId() {
    return objectId;
  }

  public String getMessage() {
    return message;
  }
}
