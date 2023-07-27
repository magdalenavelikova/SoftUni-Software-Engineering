package softuni.exam.export;
//TestTasksServiceExport001

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import softuni.exam.service.TasksService;

import java.io.IOException;

@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class TestTasksServiceExport001 {

    @Autowired
    private TasksService tasksService;

    @Sql("/export-test-001.sql")
    @Test
    void testTasksServiceExport001() throws IOException {
        String actual = tasksService.getCoupeCarTasksOrderByPrice();

        String expected = "Car Ferrari 599 GTB Fiorano with 78182km\n" +
                "-Mechanic: Hanan McCane - task №9:\n" +
                " --Engine: 2.0\n" +
                "---Price: 1317.13$\n" +
                "Car Dodge Intrepid with 339010km\n" +
                "-Mechanic: Lizbeth Glendenning - task №6:\n" +
                " --Engine: 1.1\n" +
                "---Price: 1144.42$\n" +
                "Car Honda Civic with 314484km\n" +
                "-Mechanic: Hanan McCane - task №4:\n" +
                " --Engine: 1.5\n" +
                "---Price: 969.34$\n" +
                "Car Saab 900 with 265506km\n" +
                "-Mechanic: Hanan McCane - task №8:\n" +
                " --Engine: 1.4\n" +
                "---Price: 885.94$\n" +
                "Car Dodge Intrepid with 339010km\n" +
                "-Mechanic: Hanan McCane - task №10:\n" +
                " --Engine: 1.1\n" +
                "---Price: 330.49$\n" +
                "Car Nissan Quest with 283813km\n" +
                "-Mechanic: Hanan McCane - task №5:\n" +
                " --Engine: 2.7\n" +
                "---Price: 280.38$\n";

        String[] actualSplit = actual.split("\\r\\n?|\\n");
        String[] expectedSplit = expected.split("\\r\\n?|\\n");

        Assertions.assertArrayEquals(expectedSplit,actualSplit);
    }

}
