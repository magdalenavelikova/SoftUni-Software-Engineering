//package softuni.exam.areImported;
////TestConstellationServiceAreImportedTrue
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
//public class TestConstellationServiceAreImportedTrue {
//
//    @InjectMocks
//    private ConstellationServiceImpl constellationService;
//    @Mock
//    private ConstellationRepository mockConstellationRepository;
//
//    @Test
//    void areImportedShouldReturnTrue() {
//        Mockito.when(mockConstellationRepository.count()).thenReturn(1L);
//        Assertions.assertTrue(constellationService.areImported());
//    }
//}