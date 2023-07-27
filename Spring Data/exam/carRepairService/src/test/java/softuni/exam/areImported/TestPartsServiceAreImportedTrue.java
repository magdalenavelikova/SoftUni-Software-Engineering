package softuni.exam.areImported;
//TestPartsServiceAreImportedTrue

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import softuni.exam.repository.PartsRepository;
import softuni.exam.service.impl.PartsServiceImpl;

@ExtendWith(MockitoExtension.class)
public class TestPartsServiceAreImportedTrue {

    @InjectMocks
    private PartsServiceImpl partsService;
    @Mock
    private PartsRepository mockPartsRepository;

    @Test
    void areImportedShouldReturnTrue() {
        Mockito.when(mockPartsRepository.count()).thenReturn(1L);
        Assertions.assertTrue(partsService.areImported());
    }
}