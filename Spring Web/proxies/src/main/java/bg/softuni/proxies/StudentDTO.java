package bg.softuni.proxies;

public class StudentDTO {

  private final String name;
  private final int avgScore;
  private final int age;

  public StudentDTO(String name, int avgScore, int age) {
    this.name = name;
    this.avgScore = avgScore;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public int getAvgScore() {
    return avgScore;
  }

  public int getAge() {
    return age;
  }

  @Override
  public String toString() {
    return "StudentDTO{" +
        "name='" + name + '\'' +
        ", avgScore=" + avgScore +
        ", age=" + age +
        '}';
  }
}
