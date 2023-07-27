package softuni.exam.import_Mechanics;
//TestImportMechanicPhoneSize004

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import softuni.exam.service.MechanicsService;
import softuni.exam.service.impl.MechanicsServiceImpl;

import java.io.IOException;

@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class TestImportMechanicPhoneSize004 {

    @Autowired
    private MechanicsServiceImpl mechanicsService;

    @Test
    void testImportMechanicPhoneSize004() throws IOException {
        MechanicsService spyMechanicService = Mockito.spy(mechanicsService);

        String testJSON = "[\n" +
                "  {\n" +
                "    \"email\": \"lrann0@t-online.de\",\n" +
                "    \"firstName\": \"Lorna\",\n" +
                "    \"lastName\": \"Rann\",\n" +
                "    \"phone\": \"46\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"ksterland1@hubpages.com\",\n" +
                "    \"firstName\": \"Krystal\",\n" +
                "    \"lastName\": \"Sterland\",\n" +
                "    \"phone\": \"2\"\n" +
                "  }\n" +
                "]";

        Mockito.when(spyMechanicService.readMechanicsFromFile()).thenReturn(testJSON);

        String expected = "Successfully imported mechanic Lorna Rann\n" +
                "Invalid mechanic";
        String[] expectedSplit = expected.split("\\r\\n?|\\n");

        String actual = spyMechanicService.importMechanics();
        String[] actualSplit = actual.split("\\r\\n?|\\n");

        Assertions.assertArrayEquals(expectedSplit,actualSplit);
    }
}
