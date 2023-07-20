package bg.softuni.cache.web;

import bg.softuni.cache.model.StudentDTO;
import bg.softuni.cache.service.StudentsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/students")
@RestController
public class StudentsController {

  private final StudentsService studentsService;

  public StudentsController(StudentsService studentsService) {
    this.studentsService = studentsService;
  }

  @GetMapping("/all")
  public ResponseEntity<List<StudentDTO>> getAllStudents() {
    return ResponseEntity.ok(studentsService.getAllStudents());
  }

  @GetMapping("/search")
  public ResponseEntity<StudentDTO> getStudentByName(
      @RequestParam("name") String name
  ) {

    var student = studentsService.getStudentByName(name);
    if (student == null) {
      return ResponseEntity.
          notFound().
          build();
    }
    return ResponseEntity.ok(student);
  }

  @GetMapping("/evict")
  public ResponseEntity<StudentDTO> evict() {
    studentsService.refresh();
    return ResponseEntity.noContent().build();
  }

}
