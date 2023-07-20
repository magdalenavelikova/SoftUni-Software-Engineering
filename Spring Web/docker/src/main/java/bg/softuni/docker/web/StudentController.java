package bg.softuni.docker.web;

import bg.softuni.docker.model.StudentDTO;
import bg.softuni.docker.model.StudentEntity;
import bg.softuni.docker.repository.StudentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class StudentController {

  private StudentRepository studentRepository;

  public StudentController(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  @GetMapping("/all")
  public List<StudentDTO> all() {

    return studentRepository.findAll().stream().
        map(this::map).collect(Collectors.toList());
  }

  private StudentDTO map(StudentEntity entity) {
    return new StudentDTO().setAge(entity.getAge()).setName(entity.getName());
  }

}
