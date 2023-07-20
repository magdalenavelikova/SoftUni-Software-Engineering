package bg.softuni.cache.service;

import bg.softuni.cache.model.StudentDTO;
import bg.softuni.cache.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentsService {

  private static final Logger LOGGER =
      LoggerFactory.getLogger(StudentsService.class);

  private final StudentRepository studentRepository;

  public StudentsService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  @Cacheable("students")
  public List<StudentDTO> getAllStudents() {
    LOGGER.info("Getting all students.");
    return studentRepository.getAllStudents();
  }

  @Cacheable("students")
  public StudentDTO getStudentByName(String name) {
    LOGGER.info("Getting student by name {}.", name);
    return studentRepository.findStudentByName(name);
  }

  @CacheEvict(cacheNames="students", allEntries=true)
  public void refresh() {

  }

}
