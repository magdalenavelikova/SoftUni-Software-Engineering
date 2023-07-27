package softuni.exam.import_Cars;
//TestImportTasksZeroTest000

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import softuni.exam.service.CarsService;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class TestImportCarsZeroTest000 {

    @Autowired
    private CarsService carsService;

    @Sql("/import-cars-000.sql")
    @Test
    void testImportCarsZeroTest000() throws IOException, JAXBException {
        String expected = "Successfully imported car Mitsubishi - Tundra\n" +
                "Invalid car\n" +
                "Invalid car\n" +
                "Successfully imported car Land Rover - Range Rover\n" +
                "Successfully imported car Dodge - Intrepid\n" +
                "Invalid car\n" +
                "Successfully imported car Honda - S2000\n" +
                "Successfully imported car Audi - A8\n" +
                "Successfully imported car Mercedes-Benz - E-Class\n" +
                "Successfully imported car Infiniti - II\n" +
                "Successfully imported car BMW - 325\n" +
                "Successfully imported car Ferrari - 599 GTB Fiorano\n" +
                "Successfully imported car BMW - 3 Series\n" +
                "Successfully imported car Saab - 900\n" +
                "Successfully imported car Nissan - Quest\n" +
                "Successfully imported car Dodge - Intrepid\n" +
                "Successfully imported car Pontiac - Trans Sport\n" +
                "Successfully imported car Lincoln - MKX\n" +
                "Successfully imported car Saab - 9-5\n" +
                "Successfully imported car Honda - Civic\n" +
                "Successfully imported car Mazda - MPV\n" +
                "Successfully imported car Buick - Coachbuilder\n" +
                "Successfully imported car Dodge - D150\n" +
                "Successfully imported car Acura - RL\n" +
                "Successfully imported car Saab - 9000\n" +
                "Successfully imported car Buick - Regal\n" +
                "Successfully imported car Ford - F150\n" +
                "Successfully imported car Chevrolet - Express 3500\n" +
                "Successfully imported car Pontiac - Torrent\n" +
                "Successfully imported car Volkswagen - CC\n" +
                "Successfully imported car Cadillac - XLR\n" +
                "Successfully imported car BMW - 545\n" +
                "Successfully imported car Chevrolet - Aveo\n" +
                "Successfully imported car Lexus - IS-F\n" +
                "Successfully imported car Jeep - Wrangler\n" +
                "Successfully imported car Pontiac - Bonneville\n" +
                "Successfully imported car Subaru - Legacy\n" +
                "Successfully imported car Toyota - Camry\n" +
                "Successfully imported car Cadillac - Seville\n" +
                "Successfully imported car Mercedes-Benz - 300D\n" +
                "Successfully imported car Porsche - Boxster\n" +
                "Successfully imported car Ford - Taurus\n" +
                "Successfully imported car Mercury - Monterey\n" +
                "Successfully imported car Chevrolet - Classic\n" +
                "Successfully imported car Acura - TL\n" +
                "Successfully imported car Ford - Thunderbird\n" +
                "Successfully imported car Chrysler - Town & Country\n" +
                "Successfully imported car Eagle - Premier\n" +
                "Successfully imported car Mercury - Mystique\n" +
                "Successfully imported car Saturn - S-Series\n" +
                "Successfully imported car Audi - A3\n" +
                "Successfully imported car Oldsmobile - 98\n" +
                "Successfully imported car Ford - F250\n" +
                "Successfully imported car Dodge - Viper\n" +
                "Successfully imported car Suzuki - Swift\n" +
                "Successfully imported car Ford - Contour\n" +
                "Successfully imported car Subaru - Legacy\n" +
                "Successfully imported car Ford - Taurus\n" +
                "Successfully imported car Saturn - S-Series\n" +
                "Successfully imported car Land Rover - Defender\n" +
                "Successfully imported car Lexus - ES\n" +
                "Successfully imported car Mercedes-Benz - S-Class\n" +
                "Successfully imported car Buick - Riviera\n" +
                "Successfully imported car BMW - 330\n" +
                "Successfully imported car Ford - Ccarn Victoria\n" +
                "Successfully imported car Mazda - Miata MX-5\n" +
                "Successfully imported car Chevrolet - Aveo\n" +
                "Successfully imported car Volvo - V40\n" +
                "Successfully imported car Lamborghini - Murciélago\n" +
                "Successfully imported car Chevrolet - Metro\n" +
                "Successfully imported car Chevrolet - Monza\n" +
                "Successfully imported car Toyota - Avalon\n" +
                "Successfully imported car Chevrolet - Express\n" +
                "Successfully imported car Buick - Regal\n" +
                "Successfully imported car Pontiac - Grand Prix\n" +
                "Successfully imported car Lexus - GS\n" +
                "Successfully imported car Chevrolet - 3500\n" +
                "Successfully imported car Volkswagen - rio\n" +
                "Successfully imported car Oldsmobile - 88\n" +
                "Successfully imported car Mercury - Marquis\n" +
                "Successfully imported car Chrysler - PT Cruiser\n" +
                "Successfully imported car Ford - Escort\n" +
                "Successfully imported car Pontiac - 1000\n" +
                "Successfully imported car Maserati - Spyder\n" +
                "Successfully imported car Audi - riolet\n" +
                "Successfully imported car Volkswagen - Golf\n" +
                "Successfully imported car Cadillac - Escalade\n" +
                "Successfully imported car Acura - MDX\n" +
                "Successfully imported car Porsche - Cayman\n" +
                "Successfully imported car Chevrolet - HHR\n" +
                "Successfully imported car Mazda - MX-3\n" +
                "Successfully imported car BMW - M3\n" +
                "Successfully imported car Audi - S6\n" +
                "Successfully imported car Chrysler - Sebring\n" +
                "Successfully imported car Jaguar - XJ\n" +
                "Successfully imported car Honda - Prelude\n" +
                "Successfully imported car Toyota - Tacoma\n" +
                "Successfully imported car Toyota - Camry\n" +
                "Successfully imported car Mercedes-Benz - SL-Class\n" +
                "Successfully imported car Pontiac - Grand Prix\n" +
                "Successfully imported car Dodge - Challenger\n" +
                "Successfully imported car Mazda - Miata MX-5";
        String[] expectedSplit = expected.split("\\r\\n?|\\n");

        String actual = carsService.importCars();
        String[] actualSplit = actual.split("\\r\\n?|\\n");



        Assertions.assertArrayEquals(expectedSplit, actualSplit);
    }
}

