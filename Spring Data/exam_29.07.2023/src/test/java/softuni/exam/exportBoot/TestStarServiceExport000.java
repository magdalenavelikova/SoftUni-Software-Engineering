package softuni.exam.exportBoot;
//TestStarServiceExport000

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import softuni.exam.service.impl.StarServiceImpl;

import java.io.IOException;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
public class TestStarServiceExport000 {

    @Autowired
    private StarServiceImpl starService;

    @Sql({"/constellation-test-imports.sql","/stars-test-imports.sql","/astronomers-test-imports.sql"})
    @Test
    void exportStars() throws IOException {
        String actual = starService.exportStars();

        String expected = "Star: Yara\n" +
                "   *Distance: 139.92 light years\n" +
                "   **Description: Glowing celestial object\n" +
                "   ***Constellation: Cassiopeia\n" +
                "Star: Betelgeuse\n" +
                "   *Distance: 243.47 light years\n" +
                "   **Description: Glowing sphere of hot plasma\n" +
                "   ***Constellation: Virgo\n" +
                "Star: Proxima Centauri\n" +
                "   *Distance: 282.88 light years\n" +
                "   **Description: Shining beacon in the night sky\n" +
                "   ***Constellation: Vulpecula\n" +
                "Star: Talitha\n" +
                "   *Distance: 291.34 light years\n" +
                "   **Description: Glowing celestial body\n" +
                "   ***Constellation: Ursa Minor\n" +
                "Star: Mimosa\n" +
                "   *Distance: 338.99 light years\n" +
                "   **Description: Blazing star\n" +
                "   ***Constellation: Orion\n" +
                "Star: Kaus Australis\n" +
                "   *Distance: 398.43 light years\n" +
                "   **Description: Heavenly body\n" +
                "   ***Constellation: Perseus\n" +
                "Star: Scheat\n" +
                "   *Distance: 398.43 light years\n" +
                "   **Description: Dazzling cosmic body\n" +
                "   ***Constellation: Perseus\n" +
                "Star: Celaeno\n" +
                "   *Distance: 413.34 light years\n" +
                "   **Description: Glowing celestial object\n" +
                "   ***Constellation: Centaurus\n" +
                "Star: Deneb\n" +
                "   *Distance: 431.01 light years\n" +
                "   **Description: Lustrous point of light\n" +
                "   ***Constellation: Andromeda\n" +
                "Star: Polis\n" +
                "   *Distance: 523.23 light years\n" +
                "   **Description: Shimmering star\n" +
                "   ***Constellation: Draco\n" +
                "Star: Antares\n" +
                "   *Distance: 523.88 light years\n" +
                "   **Description: Massive celestial object\n" +
                "   ***Constellation: Lyra\n" +
                "Star: Alphard\n" +
                "   *Distance: 557.59 light years\n" +
                "   **Description: Shining celestial body\n" +
                "   ***Constellation: Ursa Major\n" +
                "Star: Alnilam\n" +
                "   *Distance: 562.89 light years\n" +
                "   **Description: Blazing cosmic entity\n" +
                "   ***Constellation: Draco\n" +
                "Star: Hadar\n" +
                "   *Distance: 567.59 light years\n" +
                "   **Description: Blazing beacon in the cosmos\n" +
                "   ***Constellation: Sagittarius\n" +
                "Star: Menkar\n" +
                "   *Distance: 599.23 light years\n" +
                "   **Description: Glowing cosmic body\n" +
                "   ***Constellation: Perseus\n" +
                "Star: Eta Cassiopeiae\n" +
                "   *Distance: 600.12 light years\n" +
                "   **Description: Glowing stellar entity\n" +
                "   ***Constellation: Pegasus\n" +
                "Star: Alphatrianguli\n" +
                "   *Distance: 721.34 light years\n" +
                "   **Description: Celestial source of light and energy\n" +
                "   ***Constellation: Cepheus\n" +
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
                "Star: Fomalhaut\n" +
                "   *Distance: 1025.11 light years\n" +
                "   **Description: Distant sun\n" +
                "   ***Constellation: Sagittarius\n" +
                "Star: Spica\n" +
                "   *Distance: 1378.32 light years\n" +
                "   **Description: Luminous beacon in the vast expanse\n" +
                "   ***Constellation: Orion\n" +
                "Star: Alcor\n" +
                "   *Distance: 1382.12 light years\n" +
                "   **Description: Fiery cosmic beacon\n" +
                "   ***Constellation: Ursa Minor\n" +
                "Star: Achernar\n" +
                "   *Distance: 1652.34 light years\n" +
                "   **Description: Radiant point of light\n" +
                "   ***Constellation: Vulpecula\n" +
                "Star: Gamma Draconis\n" +
                "   *Distance: 1681.47 light years\n" +
                "   **Description: Dazzling cosmic sphere\n" +
                "   ***Constellation: Sagitta\n" +
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
                "   ***Constellation: Andromeda\n" +
                "Star: Sadalbari\n" +
                "   *Distance: 2755.89 light years\n" +
                "   **Description: Heavenly body\n" +
                "   ***Constellation: Sagitta\n" +
                "Star: Caph\n" +
                "   *Distance: 7021.67 light years\n" +
                "   **Description: Radiant celestial entity\n" +
                "   ***Constellation: Orion";

        String[] actualSplit = actual.split("\\r\\n?|\\n");
        String[] expectedSplit = expected.split("\\r\\n?|\\n");

        Assertions.assertArrayEquals(expectedSplit,actualSplit);
    }

}
