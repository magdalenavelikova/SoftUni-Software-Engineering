package softuni.exam.import_Astronomers;
//TestImportAstronomersNonExistingStar001

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
public class TestImportAstronomersNonExistingStar001 {

    @Autowired
    private AstronomerServiceImpl astronomerService;


    @Sql({"/constellation-test-imports.sql", "/stars-test-imports.sql"})
    @Test
    void importAstronomersValidateWithNonExistingStar001() throws IOException, JAXBException, NoSuchFieldException, IllegalAccessException {

        rewriteFileForTest();
        String expected = "Successfully imported astronomer Helena Bishop - 22836.19\n" +
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
                "        <average_observation_hours>22836.19</average_observation_hours>\n" +
                "        <birthday>1980-01-16</birthday>\n" +
                "        <first_name>Helena</first_name>\n" +
                "        <last_name>Bishop</last_name>\n" +
                "        <salary>294111.44</salary>\n" +
                "        <observing_star_id>80</observing_star_id>\n" +
                "    </astronomer>\n" +
                "    <astronomer>\n" +
                "        <average_observation_hours>31049.67</average_observation_hours>\n" +
                "        <birthday>1966-05-05</birthday>\n" +
                "        <first_name>Dorian</first_name>\n" +
                "        <last_name>Sawyer</last_name>\n" +
                "        <salary>161438.11</salary>\n" +
                "        <observing_star_id>101</observing_star_id>\n" +
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
