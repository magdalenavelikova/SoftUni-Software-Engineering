//package softuni.exam.areImported;
////TestStarServiceAreImportedFalse
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
//public class TestStarServiceAreImportedFalse {
//
//    @InjectMocks
//    private StarServiceImpl starService;
//    @Mock
//    private StarRepository mockStarRepository;
//
//    @Test
//    void areImportedShouldReturnFalse() {
//        Mockito.when(mockStarRepository.count()).thenReturn(0L);
//        Assertions.assertFalse(starService.areImported());
//    }
//}