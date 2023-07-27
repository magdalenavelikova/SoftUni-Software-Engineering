package softuni.exam.service;


import java.io.IOException;

// TODO: Implement all methods
public interface MechanicsService {

    boolean areImported();

    String readMechanicsFromFile() throws IOException;

    String importMechanics() throws IOException;
}
