package bg.softuni.docker.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StudentEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private int age;

  public Long getId() {
    return id;
  }

  public StudentEntity setId(Long id) {
    this.id = id;
    return this;
  }

  public String getName() {
    return name;
  }

  public StudentEntity setName(String name) {
    this.name = name;
    return this;
  }

  public int getAge() {
    return age;
  }

  public StudentEntity setAge(int age) {
    this.age = age;
    return this;
  }
}
