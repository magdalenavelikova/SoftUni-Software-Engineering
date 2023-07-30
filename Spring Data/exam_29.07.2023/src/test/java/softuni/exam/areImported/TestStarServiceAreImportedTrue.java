//package softuni.exam.areImported;
////TestStarServiceAreImportedTrue
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//import softuni.exam.repository.StarRepository;
//import softuni.exam.service.impl.StarServiceImpl;
//
//@ExtendWith(MockitoExtension.class)
//public class TestStarServiceAreImportedTrue {
//
//    @InjectMocks
//    private StarServiceImpl starService;
//    @Mock
//    private StarRepository mockStarRepository;
//
//    @Test
//    void areImportedShouldReturnTrue() {
//        Mockito.when(mockStarRepository.count()).thenReturn(1L);
//        Assertions.assertTrue(starService.areImported());
//    }
//}