package softuni.exam.import_Stars;
//TestImportStarDescriptionSIze003

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import softuni.exam.service.StarService;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class TestImportStarDescriptionSIze003 {

    @Autowired
    private StarService starService;

    @Test
    @Sql("/constellation-test-imports.sql")
    void   importStartsDescriptionSize() throws IOException {

        String expected = "Successfully imported star Antares - 523.88 light years\n" +
                "Invalid star";
        String[] expectedSplit = expected.split("\\r\\n?|\\n");

        copyRewriteFileForTest();

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
                "    \"description\": \"MassiV\",\n" +
                "    \"lightYears\": 523.88,\n" +
                "    \"name\": \"Antares\",\n" +
                "    \"starType\": \"RED_GIANT\",\n" +
                "    \"constellation\": 8\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"X-Ray\",\n" +
                "    \"lightYears\": 1789.23,\n" +
                "    \"name\": \"Arcturus\",\n" +
                "    \"starType\": \"NEUTRON_STAR\",\n" +
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
