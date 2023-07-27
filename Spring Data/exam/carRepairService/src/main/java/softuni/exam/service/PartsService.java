package softuni.exam.service;

import java.io.IOException;

// TODO: Implement all methods
public interface PartsService {

    boolean areImported();

    String readPartsFileContent() throws IOException;

    String importParts() throws IOException;
}
