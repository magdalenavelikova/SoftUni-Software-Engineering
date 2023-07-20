package bg.softuni.cache.model;

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
}
