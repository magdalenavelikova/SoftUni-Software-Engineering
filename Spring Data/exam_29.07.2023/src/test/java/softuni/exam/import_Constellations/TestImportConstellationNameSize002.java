package softuni.exam.import_Constellations;
//TestImportConstellationNameSize002

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
public class TestImportConstellationNameSize002 {

    @Autowired
    private ConstellationServiceImpl constellationService;

    @Test
    void importConstellationsNameSize002() throws IOException {


        String expected = "Successfully imported constellation Sco - A scorpion with a prominent stinger.\n" +
                "Invalid constellation\n" +
                "Successfully imported constellation Taurus Cephix Pulsar - The bull from Greek mythology.\n" +
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
                "    \"name\": \"Sco\",\n" +
                "    \"description\": \"A scorpion with a prominent stinger.\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Ur\",\n" +
                "    \"description\": \"The Great Bear, containing the Big Dipper asterism.\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Taurus Cephix Pulsar\",\n" +
                "    \"description\": \"The bull from Greek mythology.\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Taurus Cephix PulsarX\",\n" +
                "    \"description\": \"The bull from Greek mythology.\"\n" +
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
