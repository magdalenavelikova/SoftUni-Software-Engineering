package softuni.exam.util;

import javax.xml.bind.JAXBException;

public interface XmlParser {
    <T> T fromFile(String filePath, Class<T> tClass) throws JAXBException;
}
