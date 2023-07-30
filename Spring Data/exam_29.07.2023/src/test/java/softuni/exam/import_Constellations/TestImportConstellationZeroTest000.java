package softuni.exam.import_Constellations;
//TestImportConstellationZeroTest000

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import softuni.exam.service.impl.ConstellationServiceImpl;

import java.io.IOException;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
public class TestImportConstellationZeroTest000 {
    @Autowired
    private ConstellationServiceImpl constellationService;



    @Test
    void importConstellationsZeroTest() throws IOException {
        String actual = constellationService.importConstellations();

        String expected = "Successfully imported constellation Andromeda - A princess chained to a rock, saved by Perseus.\n" +
                "Invalid constellation\n" +
                "Successfully imported constellation Centaurus - A half-human, half-horse creature wielding a spear.\n" +
                "Successfully imported constellation Cassiopeia - Queen punished for her vanity by being forced to sit on a throne.\n" +
                "Invalid constellation\n" +
                "Invalid constellation\n" +
                "Successfully imported constellation Cepheus - King and husband of Cassiopeia.\n" +
                "Invalid constellation\n" +
                "Successfully imported constellation Aquila - The eagle carrying Zeus's thunderbolts.\n" +
                "Successfully imported constellation Draco - A dragon guarding the North Pole.\n" +
                "Successfully imported constellation Hydra - A multi-headed serpent-like creature.\n" +
                "Successfully imported constellation Lyra - The lyre of the mythical musician Orpheus.\n" +
                "Successfully imported constellation Orion - A mighty hunter wielding a club and a bow.\n" +
                "Successfully imported constellation Pegasus - A winged horse.\n" +
                "Successfully imported constellation Perseus - A hero who slayed Medusa and saved Andromeda.\n" +
                "Successfully imported constellation Sagitta - The arrow used by Hercules.\n" +
                "Successfully imported constellation Sagittarius - An archer aiming his bow at the heart of Scorpius.\n" +
                "Successfully imported constellation Scorpius - A scorpion with a prominent stinger.\n" +
                "Successfully imported constellation Taurus - The bull from Greek mythology.\n" +
                "Successfully imported constellation Ursa Major - The Great Bear, containing the Big Dipper asterism.\n" +
                "Successfully imported constellation Ursa Minor - The Little Bear, containing the North Star.\n" +
                "Successfully imported constellation Virgo - A maiden holding wheat or a sheaf of wheat.\n" +
                "Successfully imported constellation Vulpecula - A fox carrying a goose in its jaws.";

        String[] actualSplit = actual.split("\\r\\n?|\\n");
        String[] expectedSplit = expected.split("\\r\\n?|\\n");

        Assertions.assertArrayEquals(expectedSplit,actualSplit);
    }



}
