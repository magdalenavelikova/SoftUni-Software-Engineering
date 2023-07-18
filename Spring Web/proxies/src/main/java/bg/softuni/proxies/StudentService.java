package bg.softuni.proxies;

import java.util.List;

public class StudentService implements StudentServiceIfc {

  private static List<StudentDTO> allStudents = List.of(
      new StudentDTO("Pesho", 10, 20),
      new StudentDTO("Anna", 11, 21),
      new StudentDTO("Gosho", 9, 22)
  );

  @Override
  @Cacheable("students")
  public List<StudentDTO> getAllStudents() {
    System.out.println("Complex calculation of all students...");
    dummyWait();
    System.out.println("Students calculated");

    return allStudents;
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
