package bg.softuni.hateoas.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class OrderEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;


  @ManyToOne
  private CourseEntity course;

  @ManyToOne
  private StudentEntity student;

  public Long getId() {
    return id;
  }

  public OrderEntity setId(Long id) {
    this.id = id;
    return this;
  }

  public CourseEntity getCourse() {
    return course;
  }

  public OrderEntity setCourse(CourseEntity course) {
    this.course = course;
    return this;
  }

  public StudentEntity getStudent() {
    return student;
  }

  public OrderEntity setStudent(StudentEntity student) {
    this.student = student;
    return this;
  }
}
