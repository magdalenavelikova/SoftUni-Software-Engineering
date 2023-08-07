package bg.softuni.modelmapper.util;

import bg.softuni.modelmapper.exception.UnableToConvertException;

public interface FormatConverter {
    void setPrettyPrint();

    String serialize(Object obj) throws UnableToConvertException;
    void serialize(Object obj,String filename) throws UnableToConvertException;
    <T> T deserialize(String input, Class<T> toType) throws UnableToConvertException;
    <T> T deserializeFromFile(String fileName, Class<T> toType) throws UnableToConvertException;

}
