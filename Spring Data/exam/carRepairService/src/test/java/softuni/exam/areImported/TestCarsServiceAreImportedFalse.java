package softuni.exam.areImported;
//TestCarsServiceAreImportedFalse

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import softuni.exam.repository.CarsRepository;
import softuni.exam.service.impl.CarsServiceImpl;

@ExtendWith(MockitoExtension.class)
public class TestCarsServiceAreImportedFalse {

    @InjectMocks
    private CarsServiceImpl carsService;
    @Mock
    private CarsRepository carsRepository;


    @Test
    void areImportedShouldReturnFalse() {
        Mockito.when(carsRepository.count()).thenReturn(0L);
        Assertions.assertFalse(carsService.areImported());
    }
}