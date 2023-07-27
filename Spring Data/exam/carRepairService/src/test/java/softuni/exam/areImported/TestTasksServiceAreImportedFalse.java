package softuni.exam.areImported;
//TestTasksServiceAreImportedFalse

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import softuni.exam.repository.TasksRepository;
import softuni.exam.service.TasksService;
import softuni.exam.service.impl.TasksServiceImpl;

@ExtendWith(MockitoExtension.class)
public class TestTasksServiceAreImportedFalse {

    @InjectMocks
    private TasksServiceImpl tasksService;
    @Mock
    private TasksRepository mockTasksRepository;

    @Test
    void areImportedShouldReturnFalse() {
        Mockito.when(mockTasksRepository.count()).thenReturn(0L);
        Assertions.assertFalse(tasksService.areImported());
    }
}