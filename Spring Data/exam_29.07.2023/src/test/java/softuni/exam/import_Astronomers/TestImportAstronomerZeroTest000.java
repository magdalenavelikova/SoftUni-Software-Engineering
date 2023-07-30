package softuni.exam.import_Astronomers;
//TestImportAstronomerZeroTest000

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import softuni.exam.service.impl.AstronomerServiceImpl;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
public class TestImportAstronomerZeroTest000 {

    @Autowired
    private AstronomerServiceImpl astronomerService;

    @Sql({"/constellation-test-imports.sql", "/stars-test-imports.sql"})
    @Test
    void importAstronomersZeroTest() throws IOException, JAXBException {
        String expected = "Successfully imported astronomer Drake Hawthorne - 176858.79\n" +
                "Invalid astronomer\n" +
                "Invalid astronomer\n" +
                "Successfully imported astronomer Elena Sullivan - 55537.43\n" +
                "Invalid astronomer\n" +
                "Successfully imported astronomer Victor Adams - 72795.68\n" +
                "Successfully imported astronomer Cassandra Bellamy - 105443.87\n" +
                "Successfully imported astronomer Nathaniel Reynolds - 106936.42\n" +
                "Successfully imported astronomer Serena Chandler - 241603.80\n" +
                "Successfully imported astronomer Gabriel Fletcher - 153446.68\n" +
                "Successfully imported astronomer Lorelei Blackwell - 244764.96\n" +
                "Successfully imported astronomer Sebastian Maxwell - 183403.70\n" +
                "Successfully imported astronomer Aurora Hamilton - 150617.05\n" +
                "Successfully imported astronomer Julian Whitaker - 16667.34\n" +
                "Successfully imported astronomer Genevieve Archer - 121317.97\n" +
                "Successfully imported astronomer Elias Donovan - 148528.89\n" +
                "Successfully imported astronomer Isadora Fitzgerald - 55643.78\n" +
                "Successfully imported astronomer Lysander Spencer - 209054.25\n" +
                "Successfully imported astronomer Astrid Webster - 34635.09\n" +
                "Successfully imported astronomer Leander Valentine - 83542.93\n" +
                "Successfully imported astronomer Helena Bishop - 22836.19\n" +
                "Successfully imported astronomer Dorian Sawyer - 31049.67\n" +
                "Successfully imported astronomer Vivienne Griffin - 20537.90";
        String[] expectedSplit = expected.split("\\r\\n?|\\n");

        String actual = astronomerService.importAstronomers();
        String[] actualSplit = actual.split("\\r\\n?|\\n");



        Assertions.assertArrayEquals(expectedSplit, actualSplit);
    }
}

