package softuni.exam.exportBoot;
//TestStarServiceExport001DEL

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import softuni.exam.service.impl.StarServiceImpl;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
public class TestStarServiceExport001 {

    @Autowired
    private StarServiceImpl starService;

    @Sql("/export-test-001.sql")
    @Test
    void exportStars001() {
        String actual = starService.exportStars();

        String expected = "Star: Yara\n" +
                "   *Distance: 139.92 light years\n" +
                "   **Description: Glowing celestial object\n" +
                "   ***Constellation: Cassiopeia\n" +
                "Star: Celaeno\n" +
                "   *Distance: 413.34 light years\n" +
                "   **Description: Glowing celestial object\n" +
                "   ***Constellation: Centaurus\n" +
                "Star: Deneb\n" +
                "   *Distance: 431.01 light years\n" +
                "   **Description: Lustrous point of light\n" +
                "   ***Constellation: Andromeda\n" +
                "Star: Antares\n" +
                "   *Distance: 523.88 light years\n" +
                "   **Description: Massive celestial object\n" +
                "   ***Constellation: Lyra\n" +
                "Star: Etamin\n" +
                "   *Distance: 736.76 light years\n" +
                "   **Description: Luminous celestial body\n" +
                "   ***Constellation: Cassiopeia\n" +
                "Star: Saiph\n" +
                "   *Distance: 775.45 light years\n" +
                "   **Description: Radiant celestial entity\n" +
                "   ***Constellation: Draco\n" +
                "Star: Pi Hydrae\n" +
                "   *Distance: 802.88 light years\n" +
                "   **Description: Glowing celestial entity\n" +
                "   ***Constellation: Cassiopeia\n" +
                "Star: Spica\n" +
                "   *Distance: 1378.32 light years\n" +
                "   **Description: Luminous beacon in the vast expanse\n" +
                "   ***Constellation: Orion\n" +
                "Star: Alcyone\n" +
                "   *Distance: 1745.88 light years\n" +
                "   **Description: Dazzling star\n" +
                "   ***Constellation: Orion\n" +
                "Star: Lesath\n" +
                "   *Distance: 1843.56 light years\n" +
                "   **Description: Heavenly body illuminating the darkness\n" +
                "   ***Constellation: Cassiopeia\n" +
                "Star: Alpherg\n" +
                "   *Distance: 1943.56 light years\n" +
                "   **Description: Lustrous celestial body\n" +
                "   ***Constellation: Andromeda";

        String[] actualSplit = actual.split("\\r\\n?|\\n");
        String[] expectedSplit = expected.split("\\r\\n?|\\n");

        Assertions.assertArrayEquals(expectedSplit,actualSplit);
    }
}
