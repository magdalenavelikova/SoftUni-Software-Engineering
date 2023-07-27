package softuni.exam.import_Cars;
//TestImportTasksNonExistingMechanicName001

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import softuni.exam.service.CarsService;
import softuni.exam.service.impl.CarsServiceImpl;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.lang.reflect.Field;


@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class TestImportCarMakeSize002 {

    @Autowired
    private CarsService carsService;

    @Sql({"/import-cars-000.sql"})
    @Test
    void testImportCarsSamePlateNumber001() throws IOException, JAXBException, NoSuchFieldException, IllegalAccessException {
        String testXML = "src/test/resources/import-cars-002.xml";

        // change the value of private static  FILE_PATH using Reflection
        Field field = CarsServiceImpl.class.getDeclaredField("CARS_FILE_PATH");
        field.setAccessible(true);
        String previousPath = field.get(carsService).toString();
        field.set(null, testXML);


        String actual = carsService.importCars();
        String[] actualSplit = actual.split("\\r\\n?|\\n");
        String expected = "Successfully imported car To - Camry\n" +
                "Successfully imported car Mercedes-Benz is correct andOK - SL-Class\n" +
                "Invalid car\n" +
                "Invalid car";
        String[] expectedSplit = expected.split("\\r\\n?|\\n");

        field.set(null,previousPath);
        Assertions.assertArrayEquals(expectedSplit, actualSplit);
    }
}
