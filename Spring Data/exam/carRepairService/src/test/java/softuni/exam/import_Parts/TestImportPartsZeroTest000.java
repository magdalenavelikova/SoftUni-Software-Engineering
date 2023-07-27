package softuni.exam.import_Parts;
//TestImportMechanicsZeroTest000

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import softuni.exam.service.impl.PartsServiceImpl;

import java.io.IOException;

@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class TestImportPartsZeroTest000 {

    @Autowired
    private PartsServiceImpl partsService;


    @Test
    void testImportPartsZeroTest000() throws IOException {
        String actual = partsService.importParts();

        String expected = "Successfully imported part Alternator - 320.13\n" +
                "Successfully imported part Battery - 419.14\n" +
                "Successfully imported part Performance Battery - 455.38\n" +
                "Invalid part\n" +
                "Successfully imported part Battery Box - 590.43\n" +
                "Invalid part\n" +
                "Invalid part\n" +
                "Invalid part\n" +
                "Successfully imported part Battery Cable - 269.73\n" +
                "Successfully imported part Battery Plate - 416.1\n" +
                "Successfully imported part Battery tray - 241.45\n" +
                "Successfully imported part Battery Cap - 33.28\n" +
                "Successfully imported part Distilled Water - 547.68\n" +
                "Successfully imported part Ammeter - 148.61\n" +
                "Successfully imported part Clinometer - 397.05\n" +
                "Successfully imported part Dynamometer - 343.52\n" +
                "Successfully imported part Fuel gauge - 452.04\n" +
                "Successfully imported part Manometer - 368.82\n" +
                "Successfully imported part Hydrometer - 162.69\n" +
                "Successfully imported part Temperature gauge - 574.25\n" +
                "Successfully imported part Tire pressure gauge - 511.9\n" +
                "Successfully imported part Vacuum gauge - 385.88\n" +
                "Successfully imported part Voltmeter - 594.86\n" +
                "Successfully imported part Oil pressure gauge - 50.56\n" +
                "Successfully imported part Sparking cable - 17.41\n" +
                "Successfully imported part Distributor - 560.97\n" +
                "Successfully imported part Distributor Cap - 289.08\n" +
                "Successfully imported part Ignition box - 385.95\n" +
                "Successfully imported part Ignition coil - 449.34\n" +
                "Successfully imported part Ignition coil parts - 269.12\n" +
                "Successfully imported part Ignition magneto - 29.82\n" +
                "Successfully imported part Spark plug - 440.36\n" +
                "Successfully imported part Glow Plug - 410.57\n" +
                "Successfully imported part Starter drive - 93.68\n" +
                "Successfully imported part starter pinion gear - 471.74\n" +
                "Successfully imported part Starter motor - 45.13\n" +
                "Successfully imported part Starter solenoid - 78.3\n" +
                "Successfully imported part Door switch - 358.64\n" +
                "Successfully imported part Ignition switch - 140.88\n" +
                "Successfully imported part Power window switch - 578.73\n" +
                "Successfully imported part Switch cover - 544.33\n" +
                "Successfully imported part Switch panel - 221.84\n" +
                "Successfully imported part Thermostat - 537.15\n" +
                "Successfully imported part Frame switch - 281.97\n" +
                "Successfully imported part Fan ditch - 207.16\n" +
                "Successfully imported part Oil filter - 466.98\n" +
                "Successfully imported part Oil gasket - 296.31\n" +
                "Successfully imported part Oil pan - 426.31\n" +
                "Successfully imported part Oil pipe - 14.84\n" +
                "Successfully imported part Oil pump - 293.61\n" +
                "Successfully imported part Oil strainer - 129.59\n" +
                "Successfully imported part Oil suction filte - 484.65";

        String[] actualSplit = actual.split("\\r\\n?|\\n");
        String[] expectedSplit = expected.split("\\r\\n?|\\n");

        Assertions.assertArrayEquals(expectedSplit,actualSplit);
    }
}
