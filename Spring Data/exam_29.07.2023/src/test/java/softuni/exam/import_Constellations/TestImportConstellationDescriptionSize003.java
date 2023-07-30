package softuni.exam.import_Constellations;
//TestImportConstellationDescriptionSize003

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import softuni.exam.service.impl.ConstellationServiceImpl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
public class TestImportConstellationDescriptionSize003 {

    @Autowired
    private ConstellationServiceImpl constellationService;

    @Test
    void importConstellationsDescriptionSize002() throws IOException {

        String expected = "Successfully imported constellation Astar - MaidV.\n" +
                "Invalid constellation\n" +
                "Invalid constellation";
        String[] expectedSplit = expected.split("\\r\\n?|\\n");

        copyRewriteFileForTest();

        try {
            String actual = constellationService.importConstellations();
            String[] actualSplit = actual.split("\\r\\n?|\\n");
            Assertions.assertArrayEquals(expectedSplit, actualSplit);
        } finally {
            returnOriginalValue();
        }
    }

    private void copyRewriteFileForTest() throws IOException {
        File originalJsonFile = new File("src/main/resources/files/json/constellations.json");

        String testJSON = "[\n" +
                "  {\n" +
                "    \"name\": \"Astar\",\n" +
                "    \"description\": \"MaidV.\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Cepheus\",\n" +
                "    \"description\": \"Xero\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Wrongeus\",\n" +
                "    \"description\": \"Bad\"\n" +
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

    private void returnOriginalValue() {
        File originalJsonFileSrc = new File("src/main/resources/files/json/constellations.json");

        try {
            FileWriter f2 = new FileWriter(originalJsonFileSrc, false);
            String testOriginalFile = Files.readString(Path.of("src/test/resources/original-files/constellations.json"));
            f2.write(testOriginalFile);
            f2.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
