package bg.softuni.resttemplate.model;

public class AuthorDTO {

  private String name;

  public String getName() {
    return name;
  }

  public AuthorDTO setName(String name) {
    this.name = name;
    return this;
  }

  @Override
  public String toString() {
    return "AuthorDTO{" +
        "name='" + name + '\'' +
        '}';
  }
}
