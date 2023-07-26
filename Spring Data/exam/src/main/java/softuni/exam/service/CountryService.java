package softuni.exam.service;


import softuni.exam.excetption.UnableToConvertException;

import java.io.IOException;
import java.util.Optional;

// TODO: Implement all methods
public interface CountryService {

    boolean areImported();

    String readCountriesFromFile() throws IOException, UnableToConvertException;
	
	String importCountries() throws IOException, UnableToConvertException;
}
