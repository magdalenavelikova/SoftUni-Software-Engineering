//package softuni.exam.areImported;
////TestAstronomerServiceAreImportedTrue
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//import softuni.exam.repository.AstronomerRepository;
//import softuni.exam.service.impl.AstronomerServiceImpl;
//
//@ExtendWith(MockitoExtension.class)
//public class TestAstronomerServiceAreImportedTrue {
//
//    @InjectMocks
//    private AstronomerServiceImpl astronomerService;
//    @Mock
//    private AstronomerRepository mockAstronomerRepository;
//
//    @Test
//    void areImportedShouldReturnTrue() {
//        Mockito.when(mockAstronomerRepository.count()).thenReturn(1L);
//        Assertions.assertTrue(astronomerService.areImported());
//    }
//}