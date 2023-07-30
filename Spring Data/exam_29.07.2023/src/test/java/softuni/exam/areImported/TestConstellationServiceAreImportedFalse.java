//package softuni.exam.areImported;
////TestConstellationServiceAreImportedFalse
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//import softuni.exam.repository.ConstellationRepository;
//import softuni.exam.service.impl.ConstellationServiceImpl;
//
//@ExtendWith(MockitoExtension.class)
//public class TestConstellationServiceAreImportedFalse {
//
//    @InjectMocks
//    private ConstellationServiceImpl constellationService;
//    @Mock
//    private ConstellationRepository mockConstellationRepository;
//
//    @Test
//    void areImportedShouldReturnFalse() {
//        Mockito.when(mockConstellationRepository.count()).thenReturn(0L);
//        Assertions.assertFalse(constellationService.areImported());
//    }
//}