package softuni.exam.import_Constellations;
//TestImportConstellationDuplicateEntries001

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
public class TestImportConstellationDuplicateEntries001 {

    @Autowired
    private ConstellationServiceImpl constellationService;


    @Test
    void importConstellationsDuplicateEntries001() throws IOException {
        String expected = "Successfully imported constellation Orion - A mighty hunter wielding a club and a bow.\n" +
                "Invalid constellation\n" +
                "Successfully imported constellation Pegasus - A winged horse.\n" +
                "Invalid constellation\n" +
                "Successfully imported constellation Perseus - A hero who slayed Medusa and saved Andromeda.\n" +
                "Invalid constellation\n" +
                "Successfully imported constellation Sagitta - The arrow used by Hercules.";
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
                "    \"name\": \"Orion\",\n" +
                "    \"description\": \"A mighty hunter wielding a club and a bow.\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Orion\",\n" +
                "    \"description\": \"A mighty hunter wielding a club and a bow.\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Pegasus\",\n" +
                "    \"description\": \"A winged horse.\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Pegasus\",\n" +
                "    \"description\": \"A winged horse.\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Perseus\",\n" +
                "    \"description\": \"A hero who slayed Medusa and saved Andromeda.\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Perseus\",\n" +
                "    \"description\": \"A hero who slayed Medusa and saved Andromeda.\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Sagitta\",\n" +
                "    \"description\": \"The arrow used by Hercules.\"\n" +
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
