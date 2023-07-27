package softuni.exam.import_Tasks;
//TestImportTasksNonExistingMechanicName001

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import softuni.exam.service.TasksService;
import softuni.exam.service.impl.TasksServiceImpl;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.lang.reflect.Field;

@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class TestImportTasksNonExistingMechanicName001 {

    @Autowired
    private TasksService tasksService;

    @Sql({"/import-tasks-000.sql"})
    @Test
    void testImportTasksNonExistingMechanicName001() throws IOException, JAXBException, NoSuchFieldException, IllegalAccessException {
        String testXML = "src/test/resources/import-tasks-001.xml";

        // change the value of private static  FILE_PATH using Reflection
        Field field = TasksServiceImpl.class.getDeclaredField("TASKS_FILE_PATH");
        field.setAccessible(true);
        String previousPath = field.get(tasksService).toString();
        field.set(null, testXML);


        String actual = tasksService.importTasks();
        String[] actualSplit = actual.split("\\r\\n?|\\n");
        String expected = "Successfully imported task 1464.86\n" +
                "Invalid task";
        String[] expectedSplit = expected.split("\\r\\n?|\\n");

        field.set(null,previousPath);
        Assertions.assertArrayEquals(expectedSplit, actualSplit);
    }
}
