package bg.softuni.docker;

import bg.softuni.docker.model.StudentDTO;
import bg.softuni.docker.model.StudentEntity;
import bg.softuni.docker.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBInit implements CommandLineRunner {

  private StudentRepository studentRepository;

  public DBInit(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    var pesho = new StudentEntity().setAge(62).setName("Pesho Petrov");
    var anna = new StudentEntity().setAge(52).setName("Anna Dimitrova");

    studentRepository.save(pesho);
    studentRepository.save(anna);
  }
}
