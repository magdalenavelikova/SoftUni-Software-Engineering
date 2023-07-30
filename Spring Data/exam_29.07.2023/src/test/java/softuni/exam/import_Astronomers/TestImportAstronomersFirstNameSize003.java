package softuni.exam.import_Astronomers;
//TestImportAstronomersFirstNameSize003

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import softuni.exam.service.impl.AstronomerServiceImpl;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
public class TestImportAstronomersFirstNameSize003 {

    @Autowired
    private AstronomerServiceImpl astronomerService;


    @Sql({"/constellation-test-imports.sql", "/stars-test-imports.sql"})
    @Test
    void importAstronomersValidateFirstNameSize003() throws IOException, JAXBException {

        rewriteFileForTest();
        String expected = "Successfully imported astronomer Av Spencer - 209054.25\n" +
                "Successfully imported astronomer Wesley Alfonso de Mara MaraVeg Spencer - 209054.25\n" +
                "Invalid astronomer\n" +
                "Invalid astronomer";
        String[] expectedSplit = expected.split("\\r\\n?|\\n");

        try {
            String actual = astronomerService.importAstronomers();
            String[] actualSplit = actual.split("\\r\\n?|\\n");
            Assertions.assertArrayEquals(expectedSplit, actualSplit);
        } finally {
            returnOriginalValue();
        }
    }
    private void rewriteFileForTest() {
        File originalJsonFile = getOriginalFile();

        String testXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<astronomers>\n" +
                "    <astronomer>\n" +
                "        <average_observation_hours>209054.25</average_observation_hours>\n" +
                "        <birthday>1988-05-03</birthday>\n" +
                "        <first_name>Av</first_name>\n" +
                "        <last_name>Spencer</last_name>\n" +
                "        <salary>108576.5</salary>\n" +
                "        <observing_star_id>78</observing_star_id>\n" +
                "    </astronomer>\n" +
                "    <astronomer>\n" +
                "        <average_observation_hours>209054.25</average_observation_hours>\n" +
                "        <birthday>1988-05-03</birthday>\n" +
                "        <first_name>Wesley Alfonso de Mara MaraVeg</first_name>\n" +
                "        <last_name>Spencer</last_name>\n" +
                "        <salary>108576.5</salary>\n" +
                "        <observing_star_id>78</observing_star_id>\n" +
                "    </astronomer>\n" +
                "    <astronomer>\n" +
                "        <average_observation_hours>34635.09</average_observation_hours>\n" +
                "        <birthday>1995-08-14</birthday>\n" +
                "        <first_name>X</first_name>\n" +
                "        <last_name>Wesley</last_name>\n" +
                "        <salary>104422.67</salary>\n" +
                "        <observing_star_id>87</observing_star_id>\n" +
                "    </astronomer>\n" +
                "    <astronomer>\n" +
                "        <average_observation_hours>83542.93</average_observation_hours>\n" +
                "        <birthday>1980-12-10</birthday>\n" +
                "        <first_name>Xristo Alfonso de Mara Maraxegi</first_name>\n" +
                "        <last_name>Spencer</last_name>\n" +
                "        <salary>377608.72</salary>\n" +
                "        <observing_star_id>91</observing_star_id>\n" +
                "    </astronomer>\n" +
                "</astronomers>\n";

        try {
            FileWriter f2 = new FileWriter(originalJsonFile, false);
            f2.write(testXML);
            f2.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private File getOriginalFile() {
        return new File("src/main/resources/files/xml/astronomers.xml");
    }

    private void returnOriginalValue() {

        try {
            FileWriter f2 = new FileWriter(getOriginalFile(), false);
            String testOriginalFile = Files.readString(Path.of("src/test/resources/original-files/astronomers.xml"));
            f2.write(testOriginalFile);
            f2.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
