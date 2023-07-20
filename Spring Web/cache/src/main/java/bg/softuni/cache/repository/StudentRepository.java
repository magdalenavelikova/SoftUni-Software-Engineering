package bg.softuni.cache.repository;

import bg.softuni.cache.model.StudentDTO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class StudentRepository {

  private static List<StudentDTO> allStudents = List.of(
      new StudentDTO("Pesho", 10, 20),
      new StudentDTO("Anna", 11, 21),
      new StudentDTO("Gosho", 9, 22)
  );

  public List<StudentDTO> getAllStudents() {
    dummyWait();

    return allStudents;
  }

  public StudentDTO findStudentByName(String name) {
    dummyWait();

    return allStudents.
        stream().
        filter(s -> s.getName().equals(name)).
        findAny().
        orElse(null);
  }

  private void dummyWait() {
    try {
      Thread.sleep(5000);
      // Dummy - imagine we need to perform complex operation to fetch student data...
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
