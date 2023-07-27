package softuni.exam.import_Parts;
//TestImportPartNameSIze002

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import softuni.exam.service.PartsService;
import softuni.exam.service.impl.PartsServiceImpl;

import java.io.IOException;

@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class TestImportPartNameSIze002 {

    @Autowired
    private PartsServiceImpl partsService;

    @Test
    void importPartNameSize002() throws IOException {
        PartsService spyConstellationService = Mockito.spy(partsService);

        String testJSON = "[\n" +
                "  {\n" +
                "    \"partName\": \"Sp\",\n" +
                "    \"price\": 440.36,\n" +
                "    \"quantity\": 27\n" +
                "  },\n" +
                "  {\n" +
                "    \"partName\": \"Glow it its correct\",\n" +
                "    \"price\": 410.57,\n" +
                "    \"quantity\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"partName\": \"X\",\n" +
                "    \"price\": 93.68,\n" +
                "    \"quantity\": 13\n" +
                "  },\n" +
                "  {\n" +
                "    \"partName\": \"XGlow it its correct\",\n" +
                "    \"price\": 471.74,\n" +
                "    \"quantity\": 38\n" +
                "  }\n" +
                "]";

        Mockito.when(spyConstellationService.readPartsFileContent()).thenReturn(testJSON);

        String expected = "Successfully imported part Sp - 440.36\n" +
                "Successfully imported part Glow it its correct - 410.57\n" +
                "Invalid part\n" +
                "Invalid part";
        String[] expectedSplit = expected.split("\\r\\n?|\\n");

        String actual = spyConstellationService.importParts();
        String[] actualSplit = actual.split("\\r\\n?|\\n");

        Assertions.assertArrayEquals(expectedSplit,actualSplit);
    }
}
