package bg.softuni.docker.model;

public class StudentDTO {

  private int age;
  private String name;

  public int getAge() {
    return age;
  }

  public StudentDTO setAge(int age) {
    this.age = age;
    return this;
  }

  public String getName() {
    return name;
  }

  public StudentDTO setName(String name) {
    this.name = name;
    return this;
  }
}
