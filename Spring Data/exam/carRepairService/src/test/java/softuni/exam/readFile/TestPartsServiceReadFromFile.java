package softuni.exam.readFile;
//TestPartsServiceReadFromFile

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import softuni.exam.service.impl.PartsServiceImpl;

import java.io.IOException;

@ExtendWith(MockitoExtension.class)
public class TestPartsServiceReadFromFile {

    @InjectMocks
    private PartsServiceImpl partsService;

    @Test
    void readPartsFromFile() throws IOException {

        String expected = "[\n" +
                "  {\n" +
                "    \"partName\": \"Alternator\",\n" +
                "    \"price\": 320.13,\n" +
                "    \"quantity\": 40\n" +
                "  },\n" +
                "  {\n" +
                "    \"partName\": \"Battery\",\n" +
                "    \"price\": 419.14,\n" +
                "    \"quantity\": 33\n" +
                "  },\n" +
                "  {\n" +
                "    \"partName\": \"Performance Battery\",\n" +
                "    \"price\": 455.38,\n" +
                "    \"quantity\": 15\n" +
                "  },\n" +
                "  {\n" +
                "    \"partName\": \"Alternator\",\n" +
                "    \"price\": 240.13,\n" +
                "    \"quantity\": 18\n" +
                "  },\n" +
                "  {\n" +
                "    \"partName\": \"Battery Box\",\n" +
                "    \"price\": 590.43,\n" +
                "    \"quantity\": 21\n" +
                "  },\n" +
                "  {\n" +
                "    \"partName\": \"L\",\n" +
                "    \"price\": 154.12,\n" +
                "    \"quantity\": 35\n" +
                "  },\n" +
                "  {\n" +
                "    \"partName\": \"Coupe filter\",\n" +
                "    \"price\": 5.12,\n" +
                "    \"quantity\": 12\n" +
                "  },\n" +
                "  {\n" +
                "    \"partName\": \"Long cable\",\n" +
                "    \"price\": 329.73,\n" +
                "    \"quantity\": -2\n" +
                "  },\n" +
                "  {\n" +
                "    \"partName\": \"Battery Cable\",\n" +
                "    \"price\": 269.73,\n" +
                "    \"quantity\": 5\n" +
                "  },\n" +
                "  {\n" +
                "    \"partName\": \"Battery Plate\",\n" +
                "    \"price\": 416.1,\n" +
                "    \"quantity\": 36\n" +
                "  },\n" +
                "  {\n" +
                "    \"partName\": \"Battery tray\",\n" +
                "    \"price\": 241.45,\n" +
                "    \"quantity\": 13\n" +
                "  },\n" +
                "  {\n" +
                "    \"partName\": \"Battery Cap\",\n" +
                "    \"price\": 33.28,\n" +
                "    \"quantity\": 24\n" +
                "  },\n" +
                "  {\n" +
                "    \"partName\": \"Distilled Water\",\n" +
                "    \"price\": 547.68,\n" +
                "    \"quantity\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"partName\": \"Ammeter\",\n" +
                "    \"price\": 148.61,\n" +
                "    \"quantity\": 7\n" +
                "  },\n" +
                "  {\n" +
                "    \"partName\": \"Clinometer\",\n" +
                "    \"price\": 397.05,\n" +
                "    \"quantity\": 12\n" +
                "  },\n" +
                "  {\n" +
                "    \"partName\": \"Dynamometer\",\n" +
                "    \"price\": 343.52,\n" +
                "    \"quantity\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"partName\": \"Fuel gauge\",\n" +
                "    \"price\": 452.04,\n" +
                "    \"quantity\": 31\n" +
                "  },\n" +
                "  {\n" +
                "    \"partName\": \"Manometer\",\n" +
                "    \"price\": 368.82,\n" +
                "    \"quantity\": 27\n" +
                "  },\n" +
                "  {\n" +
                "    \"partName\": \"Hydrometer\",\n" +
                "    \"price\": 162.69,\n" +
                "    \"quantity\": 8\n" +
                "  },\n" +
                "  {\n" +
                "    \"partName\": \"Temperature gauge\",\n" +
                "    \"price\": 574.25,\n" +
                "    \"quantity\": 40\n" +
                "  },\n" +
                "  {\n" +
                "    \"partName\": \"Tire pressure gauge\",\n" +
                "    \"price\": 511.9,\n" +
                "    \"quantity\": 26\n" +
                "  },\n" +
                "  {\n" +
                "    \"partName\": \"Vacuum gauge\",\n" +
                "    \"price\": 385.88,\n" +
                "    \"quantity\": 29\n" +
                "  },\n" +
                "  {\n" +
                "    \"partName\": \"Voltmeter\",\n" +
                "    \"price\": 594.86,\n" +
                "    \"quantity\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"partName\": \"Oil pressure gauge\",\n" +
                "    \"price\": 50.56,\n" +
                "    \"quantity\": 40\n" +
                "  },\n" +
                "  {\n" +
                "    \"partName\": \"Sparking cable\",\n" +
                "    \"price\": 17.41,\n" +
                "    \"quantity\": 28\n" +
                "  },\n" +
                "  {\n" +
                "    \"partName\": \"Distributor\",\n" +
                "    \"price\": 560.97,\n" +
                "    \"quantity\": 37\n" +
                "  },\n" +
                "  {\n" +
                "    \"partName\": \"Distributor Cap\",\n" +
                "    \"price\": 289.08,\n" +
                "    \"quantity\": 39\n" +
                "  },\n" +
                "  {\n" +
                "    \"partName\": \"Ignition box\",\n" +
                "    \"price\": 385.95,\n" +
                "    \"quantity\": 10\n" +
                "  },\n" +
                "  {\n" +
                "    \"partName\": \"Ignition coil\",\n" +
                "    \"price\": 449.34,\n" +
                "    \"quantity\": 12\n" +
                "  },\n" +
                "  {\n" +
                "    \"partName\": \"Ignition coil parts\",\n" +
                "    \"price\": 269.12,\n" +
                "    \"quantity\": 3\n" +
                "  },\n" +
                "  {\n" +
                "    \"partName\": \"Ignition magneto\",\n" +
                "    \"price\": 29.82,\n" +
                "    \"quantity\": 20\n" +
                "  },\n" +
                "  {\n" +
                "    \"partName\": \"Spark plug\",\n" +
                "    \"price\": 440.36,\n" +
                "    \"quantity\": 27\n" +
                "  },\n" +
                "  {\n" +
                "    \"partName\": \"Glow Plug\",\n" +
                "    \"price\": 410.57,\n" +
                "    \"quantity\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"partName\": \"Starter drive\",\n" +
                "    \"price\": 93.68,\n" +
                "    \"quantity\": 13\n" +
                "  },\n" +
                "  {\n" +
                "    \"partName\": \"starter pinion gear\",\n" +
                "    \"price\": 471.74,\n" +
                "    \"quantity\": 38\n" +
                "  },\n" +
                "  {\n" +
                "    \"partName\": \"Starter motor\",\n" +
                "    \"price\": 45.13,\n" +
                "    \"quantity\": 21\n" +
                "  },\n" +
                "  {\n" +
                "    \"partName\": \"Starter solenoid\",\n" +
                "    \"price\": 78.3,\n" +
                "    \"quantity\": 26\n" +
                "  },\n" +
                "  {\n" +
                "    \"partName\": \"Door switch\",\n" +
                "    \"price\": 358.64,\n" +
                "    \"quantity\": 2\n" +
                "  },\n" +
                "  {\n" +
                "    \"partName\": \"Ignition switch\",\n" +
                "    \"price\": 140.88,\n" +
                "    \"quantity\": 17\n" +
                "  },\n" +
                "  {\n" +
                "    \"partName\": \"Power window switch\",\n" +
                "    \"price\": 578.73,\n" +
                "    \"quantity\": 22\n" +
                "  },\n" +
                "  {\n" +
                "    \"partName\": \"Switch cover\",\n" +
                "    \"price\": 544.33,\n" +
                "    \"quantity\": 37\n" +
                "  },\n" +
                "  {\n" +
                "    \"partName\": \"Switch panel\",\n" +
                "    \"price\": 221.84,\n" +
                "    \"quantity\": 15\n" +
                "  },\n" +
                "  {\n" +
                "    \"partName\": \"Thermostat\",\n" +
                "    \"price\": 537.15,\n" +
                "    \"quantity\": 2\n" +
                "  },\n" +
                "  {\n" +
                "    \"partName\": \"Frame switch\",\n" +
                "    \"price\": 281.97,\n" +
                "    \"quantity\": 23\n" +
                "  },\n" +
                "  {\n" +
                "    \"partName\": \"Fan ditch\",\n" +
                "    \"price\": 207.16,\n" +
                "    \"quantity\": 15\n" +
                "  },\n" +
                "  {\n" +
                "    \"partName\": \"Oil filter\",\n" +
                "    \"price\": 466.98,\n" +
                "    \"quantity\": 33\n" +
                "  },\n" +
                "  {\n" +
                "    \"partName\": \"Oil gasket\",\n" +
                "    \"price\": 296.31,\n" +
                "    \"quantity\": 28\n" +
                "  },\n" +
                "  {\n" +
                "    \"partName\": \"Oil pan\",\n" +
                "    \"price\": 426.31,\n" +
                "    \"quantity\": 37\n" +
                "  },\n" +
                "  {\n" +
                "    \"partName\": \"Oil pipe\",\n" +
                "    \"price\": 14.84,\n" +
                "    \"quantity\": 31\n" +
                "  },\n" +
                "  {\n" +
                "    \"partName\": \"Oil pump\",\n" +
                "    \"price\": 293.61,\n" +
                "    \"quantity\": 2\n" +
                "  },\n" +
                "  {\n" +
                "    \"partName\": \"Oil strainer\",\n" +
                "    \"price\": 129.59,\n" +
                "    \"quantity\": 21\n" +
                "  },\n" +
                "  {\n" +
                "    \"partName\": \"Oil suction filte\",\n" +
                "    \"price\": 484.65,\n" +
                "    \"quantity\": 22\n" +
                "  }\n" +
                "]";

        String actual = partsService.readPartsFileContent();

        Assertions.assertEquals(expected, actual);
    }
}