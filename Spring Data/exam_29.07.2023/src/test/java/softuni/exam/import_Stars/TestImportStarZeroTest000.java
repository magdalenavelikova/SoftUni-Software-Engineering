package softuni.exam.import_Stars;
//TestImportStarZeroTest000

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import softuni.exam.service.impl.StarServiceImpl;

import java.io.IOException;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
public class TestImportStarZeroTest000 {

    @Autowired
    private StarServiceImpl starService;

    @Test
    @Sql("/constellation-test-imports.sql")
    void importStarsZeroTest() throws IOException {

        String expected = "Invalid star\n" +
                "Successfully imported star Sirius - 25.34 light years\n" +
                "Invalid star\n" +
                "Successfully imported star Spica - 1378.32 light years\n" +
                "Invalid star\n" +
                "Invalid star\n" +
                "Successfully imported star Vega - 463.54 light years\n" +
                "Successfully imported star Alpha Centauri - 2956.12 light years\n" +
                "Successfully imported star Polaris - 809.76 light years\n" +
                "Successfully imported star Antares - 523.88 light years\n" +
                "Successfully imported star Arcturus - 1789.23 light years\n" +
                "Successfully imported star Caph - 7021.67 light years\n" +
                "Successfully imported star Rigel - 4023.55 light years\n" +
                "Successfully imported star Altair - 98.76 light years\n" +
                "Successfully imported star Aldebaran - 654.99 light years\n" +
                "Successfully imported star Deneb - 431.01 light years\n" +
                "Successfully imported star Regulus - 656.88 light years\n" +
                "Successfully imported star Betelgeuse - 243.47 light years\n" +
                "Successfully imported star Castor - 586.12 light years\n" +
                "Successfully imported star Pollux - 7614.09 light years\n" +
                "Successfully imported star Fomalhaut - 1025.11 light years\n" +
                "Successfully imported star Bellatrix - 3197.45 light years\n" +
                "Successfully imported star Alnitak - 2815.21 light years\n" +
                "Successfully imported star Alnilam - 562.89 light years\n" +
                "Successfully imported star Mintaka - 381.59 light years\n" +
                "Successfully imported star Mirach - 1204.78 light years\n" +
                "Successfully imported star Algol - 692.45 light years\n" +
                "Successfully imported star Baten - 437.22 light years\n" +
                "Successfully imported star Yara - 139.92 light years\n" +
                "Successfully imported star Alhena - 196.43 light years\n" +
                "Successfully imported star Schedar - 39.75 light years\n" +
                "Successfully imported star Gacrux - 9000.00 light years\n" +
                "Successfully imported star Achernar - 1652.34 light years\n" +
                "Successfully imported star Hamal - 818.79 light years\n" +
                "Successfully imported star Achird - 1623.55 light years\n" +
                "Successfully imported star Menkar - 599.23 light years\n" +
                "Successfully imported star Diphda - 2624.47 light years\n" +
                "Successfully imported star Alcyone - 1745.88 light years\n" +
                "Successfully imported star Aludra - 3452.76 light years\n" +
                "Successfully imported star Alnair - 1689.67 light years\n" +
                "Successfully imported star Adhara - 155.21 light years\n" +
                "Successfully imported star Algieba - 744.89 light years\n" +
                "Successfully imported star Alphard - 557.59 light years\n" +
                "Successfully imported star Alcor - 1382.12 light years\n" +
                "Successfully imported star Mira - 765.45 light years\n" +
                "Successfully imported star Alkes - 645.56 light years\n" +
                "Successfully imported star Alhakim - 298.43 light years\n" +
                "Successfully imported star Almach - 195.75 light years\n" +
                "Successfully imported star Albireo - 4802.65 light years\n" +
                "Successfully imported star Alpherg - 1943.56 light years\n" +
                "Successfully imported star Alphatrianguli - 721.34 light years\n" +
                "Successfully imported star Alwaid - 245.45 light years\n" +
                "Successfully imported star Alwarid - 882.99 light years\n" +
                "Successfully imported star Alzirr - 569.01 light years\n" +
                "Successfully imported star Proxima Centauri - 282.88 light years\n" +
                "Successfully imported star Celaeno - 413.34 light years\n" +
                "Successfully imported star Electra - 651.21 light years\n" +
                "Successfully imported star Eltanin - 4715.78 light years\n" +
                "Successfully imported star Errai - 2576.12 light years\n" +
                "Successfully imported star Etamin - 736.76 light years\n" +
                "Successfully imported star Elnath - 507.88 light years\n" +
                "Successfully imported star Epsilon Eridani - 270.23 light years\n" +
                "Successfully imported star Eta Cassiopeiae - 600.12 light years\n" +
                "Successfully imported star Gamma Draconis - 1681.47 light years\n" +
                "Successfully imported star Gienah - 934.12 light years\n" +
                "Successfully imported star Graffias - 2755.89 light years\n" +
                "Successfully imported star Hadar - 567.59 light years\n" +
                "Successfully imported star Homam - 1362.12 light years\n" +
                "Successfully imported star Iota Draconis - 775.45 light years\n" +
                "Successfully imported star Izar - 635.56 light years\n" +
                "Successfully imported star Kaus Australis - 398.43 light years\n" +
                "Successfully imported star Kaus Borealis - 105.75 light years\n" +
                "Successfully imported star Kochab - 752.65 light years\n" +
                "Successfully imported star Lesath - 1843.56 light years\n" +
                "Successfully imported star Marfik - 291.34 light years\n" +
                "Successfully imported star Markab - 422.45 light years\n" +
                "Successfully imported star Mimosa - 338.99 light years\n" +
                "Successfully imported star Mirphak - 539.01 light years\n" +
                "Successfully imported star Mizar - 192.88 light years\n" +
                "Successfully imported star Mu Cephei - 326.34 light years\n" +
                "Successfully imported star Nashira - 1051.21 light years\n" +
                "Successfully imported star Navi - 3715.78 light years\n" +
                "Successfully imported star Peacock - 976.12 light years\n" +
                "Successfully imported star Phact - 646.76 light years\n" +
                "Successfully imported star Pi Hydrae - 802.88 light years\n" +
                "Successfully imported star Polis - 523.23 light years\n" +
                "Successfully imported star Porrima - 270.12 light years\n" +
                "Successfully imported star Phecda - 156.56 light years\n" +
                "Successfully imported star Rasalgethi - 196.43 light years\n" +
                "Successfully imported star Rasalhague - 130.75 light years\n" +
                "Successfully imported star Rastaban - 4752.65 light years\n" +
                "Successfully imported star Rigil Kentaurus - 1681.47 light years\n" +
                "Successfully imported star Ruchbah - 934.12 light years\n" +
                "Successfully imported star Sadalbari - 2755.89 light years\n" +
                "Successfully imported star Sadalmelik - 567.59 light years\n" +
                "Successfully imported star Sadalsuud - 1362.12 light years\n" +
                "Successfully imported star Saiph - 775.45 light years\n" +
                "Successfully imported star Sargas - 635.56 light years\n" +
                "Successfully imported star Scheat - 398.43 light years\n" +
                "Successfully imported star Sheratan - 105.75 light years\n" +
                "Successfully imported star Shaula - 752.65 light years\n" +
                "Successfully imported star Situla - 1843.56 light years\n" +
                "Successfully imported star Talitha - 291.34 light years\n" +
                "Successfully imported star Thuban - 422.45 light years";

        String[] expectedSplit = expected.split("\\r\\n?|\\n");
        String actual = starService.importStars();
        String[] actualSplit = actual.split("\\r\\n?|\\n");

        Assertions.assertArrayEquals(expectedSplit, actualSplit);
    }


}
