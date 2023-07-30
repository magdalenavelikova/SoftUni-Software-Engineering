package softuni.exam.import_Stars;
//TestImportStarDuplicateNames001

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import softuni.exam.service.impl.StarServiceImpl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
public class TestImportStarDuplicateNames001 {

    @Autowired
    private StarServiceImpl starService;

    @Test
    @Sql("/constellation-test-imports.sql")
    void   importStartsDuplicateNames() throws IOException {

        copyRewriteFileForTest();

        String expected = "Successfully imported star Antares - 523.88 light years\n" +
                "Invalid star\n" +
                "Successfully imported star Caph - 7021.67 light years\n" +
                "Invalid star";
        String[] expectedSplit = expected.split("\\r\\n?|\\n");

        try {
            String actual = starService.importStars();
            String[] actualSplit = actual.split("\\r\\n?|\\n");
            Assertions.assertArrayEquals(expectedSplit, actualSplit);
        } finally {
            returnOriginalValue();
        }
    }

    private void copyRewriteFileForTest() throws IOException {
        File originalJsonFile = getOriginalFile();

        String testJSON = "[\n" +
                "  {\n" +
                "    \"description\": \"Massive celestial objectV\",\n" +
                "    \"lightYears\": 523.88,\n" +
                "    \"name\": \"Antares\",\n" +
                "    \"starType\": \"RED_GIANT\",\n" +
                "    \"constellation\": 9\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Massive celesti objeXct\",\n" +
                "    \"lightYears\": 1789.23,\n" +
                "    \"name\": \"Antares\",\n" +
                "    \"starType\": \"NEUTRON_STAR\",\n" +
                "    \"constellation\": 9\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Radiant celestisal enVtity\",\n" +
                "    \"lightYears\": 7021.67,\n" +
                "    \"name\": \"Caph\",\n" +
                "    \"starType\": \"RED_GIANT\",\n" +
                "    \"constellation\": 9\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Radiant celestial entiXty\",\n" +
                "    \"lightYears\": 7021.67,\n" +
                "    \"name\": \"Caph\",\n" +
                "    \"starType\": \"RED_GIANT\",\n" +
                "    \"constellation\": 9\n" +
                "  }\n" +
                "]";

        try {
            FileWriter f2 = new FileWriter(originalJsonFile, false);
            f2.write(testJSON);
            f2.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private File getOriginalFile() {
        return new File("src/main/resources/files/json/stars.json");
    }

    private void returnOriginalValue() {

        try {
            FileWriter f2 = new FileWriter(getOriginalFile(), false);
            String testOriginalFile = Files.readString(Path.of("src/test/resources/original-files/stars.json"));
            f2.write(testOriginalFile);
            f2.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
