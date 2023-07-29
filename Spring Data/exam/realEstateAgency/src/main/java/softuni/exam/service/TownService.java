package softuni.exam.service;

import java.io.IOException;

// TODO: Implement all methods
public interface TownService {

    boolean areImported();

    String readTownsFileContent() throws IOException;
	
	String importTowns() throws IOException;
}
