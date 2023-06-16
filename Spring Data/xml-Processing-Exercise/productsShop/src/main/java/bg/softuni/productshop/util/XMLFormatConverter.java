package bg.softuni.productshop.util;


import bg.softuni.productshop.excetption.UnableToConvertException;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component("xml_format_converter")
public class XMLFormatConverter implements FormatConverter {
    private boolean prettyPrint = false;
    private final Map<String, Marshaller> marshallers = new HashMap<>();


    @Override
    public void setPrettyPrint() {
        this.prettyPrint = true;
    }

    @Override
    public String serialize(Object obj) throws UnableToConvertException {
        try {
            Marshaller marshaller = getMarshaller(obj);
            StringWriter sw = new StringWriter();
            marshaller.marshal(
                    obj,
                    sw
            );
            return sw.toString();
        } catch (JAXBException e) {
            e.printStackTrace();
            throw new UnableToConvertException();
        }

    }


    @Override
    public void serialize(Object obj, String filename) throws UnableToConvertException {
        try {
            Marshaller marshaller = getMarshaller(obj);
            FileWriter fw = new FileWriter(filename);

            marshaller.marshal(
                    obj,
                    fw
            );

        } catch (JAXBException | IOException e) {
            e.printStackTrace();
            throw new UnableToConvertException();
        }

    }

    @Override
    public <T> void serializeList(List<T> objectLists, String filename) {

        try {
            Marshaller marshaller = getMarshaller(objectLists.get(1));
            FileWriter fw = new FileWriter(filename);
            objectLists.forEach(obj -> {
                        try {
                            marshaller.marshal(
                                    obj,
                                    fw
                            );
                        } catch (JAXBException e) {
                            throw new RuntimeException(e);
                        }
                    }
            );


        } catch (IOException | JAXBException e) {
            e.printStackTrace();

        }
    }

    @Override
    public <T> T deserialize(String input, Class<T> toType) throws UnableToConvertException {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(toType);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
            return (T) unmarshaller.unmarshal(inputStream);

        } catch (JAXBException e) {
            e.printStackTrace();
            throw new UnableToConvertException();
        }

    }

    @Override
    public <T> T deserializeFromFile(String fileName, Class<T> toType) throws UnableToConvertException {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(toType);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            FileInputStream fileInputStream = new FileInputStream(fileName);
            return (T) unmarshaller.unmarshal(fileInputStream);

        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
            throw new UnableToConvertException();
        }

    }

    private Marshaller getMarshaller(Object obj) throws JAXBException {
        Marshaller marshaller = null;
        if (this.marshallers.containsKey(obj.getClass().getName())) {
            marshaller = this.marshallers.get(obj.getClass().getName());
        } else {
            JAXBContext jaxbContext = JAXBContext.newInstance(obj.getClass());
            marshaller = jaxbContext.createMarshaller();
            this.marshallers.put(obj.getClass().getName(), marshaller);
        }
        if (this.prettyPrint) {
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, this.prettyPrint);
        }
        return marshaller;
    }

}
