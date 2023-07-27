package softuni.exam.areImported;
//TestMechanicsServiceAreImportedFalse

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import softuni.exam.repository.MechanicsRepository;
import softuni.exam.service.impl.MechanicsServiceImpl;

@ExtendWith(MockitoExtension.class)
public class TestMechanicsServiceAreImportedFalse {

    @InjectMocks
    private MechanicsServiceImpl mechanicsService;
    @Mock
    private MechanicsRepository mockMechanicsRepository;

    @Test
    void areImportedShouldReturnFalse() {
        Mockito.when(mockMechanicsRepository.count()).thenReturn(0L);
        Assertions.assertFalse(mechanicsService.areImported());
    }
}