package softuni.exam.readFile;
//TestStarServiceReadFileContent

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import softuni.exam.service.impl.StarServiceImpl;

import java.io.IOException;

@ExtendWith(MockitoExtension.class)
public class TestStarServiceReadFileContent {

    @InjectMocks
    private StarServiceImpl starService;

     @Test
    void readStarsFileContent() throws IOException {
        String expected = "[\n" +
                "  {\n" +
                "    \"description\": \"Glowing sphere of celestial gas\",\n" +
                "    \"lightYears\": 25.34,\n" +
                "    \"name\": \"X\",\n" +
                "    \"starType\": \"WHITE_DWARF\",\n" +
                "    \"constellation\": 18\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Glowing sphere of celestial gas\",\n" +
                "    \"lightYears\": 25.34,\n" +
                "    \"name\": \"Sirius\",\n" +
                "    \"starType\": \"WHITE_DWARF\",\n" +
                "    \"constellation\": 18\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Giant star\",\n" +
                "    \"lightYears\": 3197.45,\n" +
                "    \"name\": \"Galacticus Caelum Octavus Magnificensis\",\n" +
                "    \"starType\": \"NEUTRON_STAR\",\n" +
                "    \"constellation\": 12\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Luminous beacon in the vast expanse\",\n" +
                "    \"lightYears\": 1378.32,\n" +
                "    \"name\": \"Spica\",\n" +
                "    \"starType\": \"RED_GIANT\",\n" +
                "    \"constellation\": 9\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Luminous beacon in the vast expanse\",\n" +
                "    \"lightYears\": 1378.32,\n" +
                "    \"name\": \"Spica\",\n" +
                "    \"starType\": \"RED_GIANT\",\n" +
                "    \"constellation\": 9\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Distant cosmic entity\",\n" +
                "    \"lightYears\": -63.24,\n" +
                "    \"name\": \"Its wrong\",\n" +
                "    \"starType\": \"NEUTRON_STAR\",\n" +
                "    \"constellation\": 14\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Distant cosmic entity\",\n" +
                "    \"lightYears\": 463.54,\n" +
                "    \"name\": \"Vega\",\n" +
                "    \"starType\": \"NEUTRON_STAR\",\n" +
                "    \"constellation\": 14\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Radiating celestial body\",\n" +
                "    \"lightYears\": 2956.12,\n" +
                "    \"name\": \"Alpha Centauri\",\n" +
                "    \"starType\": \"WHITE_DWARF\",\n" +
                "    \"constellation\": 19\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Shimmering point of light in the night sky\",\n" +
                "    \"lightYears\": 809.76,\n" +
                "    \"name\": \"Polaris\",\n" +
                "    \"starType\": \"NEUTRON_STAR\",\n" +
                "    \"constellation\": 2\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Massive celestial object\",\n" +
                "    \"lightYears\": 523.88,\n" +
                "    \"name\": \"Antares\",\n" +
                "    \"starType\": \"RED_GIANT\",\n" +
                "    \"constellation\": 8\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Cosmic furnace\",\n" +
                "    \"lightYears\": 1789.23,\n" +
                "    \"name\": \"Arcturus\",\n" +
                "    \"starType\": \"NEUTRON_STAR\",\n" +
                "    \"constellation\": 9\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Radiant celestial entity\",\n" +
                "    \"lightYears\": 7021.67,\n" +
                "    \"name\": \"Caph\",\n" +
                "    \"starType\": \"RED_GIANT\",\n" +
                "    \"constellation\": 9\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Shining star\",\n" +
                "    \"lightYears\": 4023.55,\n" +
                "    \"name\": \"Rigel\",\n" +
                "    \"starType\": \"WHITE_DWARF\",\n" +
                "    \"constellation\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Fiery orb of gas\",\n" +
                "    \"lightYears\": 98.76,\n" +
                "    \"name\": \"Altair\",\n" +
                "    \"starType\": \"WHITE_DWARF\",\n" +
                "    \"constellation\": 9\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Dazzling cosmic body\",\n" +
                "    \"lightYears\": 654.99,\n" +
                "    \"name\": \"Aldebaran\",\n" +
                "    \"starType\": \"NEUTRON_STAR\",\n" +
                "    \"constellation\": 5\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Lustrous point of light\",\n" +
                "    \"lightYears\": 431.01,\n" +
                "    \"name\": \"Deneb\",\n" +
                "    \"starType\": \"RED_GIANT\",\n" +
                "    \"constellation\": 1\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Celestial source of light\",\n" +
                "    \"lightYears\": 656.88,\n" +
                "    \"name\": \"Regulus\",\n" +
                "    \"starType\": \"NEUTRON_STAR\",\n" +
                "    \"constellation\": 13\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Glowing sphere of hot plasma\",\n" +
                "    \"lightYears\": 243.47,\n" +
                "    \"name\": \"Betelgeuse\",\n" +
                "    \"starType\": \"RED_GIANT\",\n" +
                "    \"constellation\": 18\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Shimmering stellar object\",\n" +
                "    \"lightYears\": 586.12,\n" +
                "    \"name\": \"Castor\",\n" +
                "    \"starType\": \"NEUTRON_STAR\",\n" +
                "    \"constellation\": 18\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Luminous cosmic beacon\",\n" +
                "    \"lightYears\": 7614.09,\n" +
                "    \"name\": \"Pollux\",\n" +
                "    \"starType\": \"WHITE_DWARF\",\n" +
                "    \"constellation\": 1\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Distant sun\",\n" +
                "    \"lightYears\": 1025.11,\n" +
                "    \"name\": \"Fomalhaut\",\n" +
                "    \"starType\": \"RED_GIANT\",\n" +
                "    \"constellation\": 13\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Giant star\",\n" +
                "    \"lightYears\": 3197.45,\n" +
                "    \"name\": \"Bellatrix\",\n" +
                "    \"starType\": \"NEUTRON_STAR\",\n" +
                "    \"constellation\": 12\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Gleaming point of light\",\n" +
                "    \"lightYears\": 2815.21,\n" +
                "    \"name\": \"Alnitak\",\n" +
                "    \"starType\": \"WHITE_DWARF\",\n" +
                "    \"constellation\": 3\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Blazing cosmic entity\",\n" +
                "    \"lightYears\": 562.89,\n" +
                "    \"name\": \"Alnilam\",\n" +
                "    \"starType\": \"RED_GIANT\",\n" +
                "    \"constellation\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Celestial furnace\",\n" +
                "    \"lightYears\": 381.59,\n" +
                "    \"name\": \"Mintaka\",\n" +
                "    \"starType\": \"WHITE_DWARF\",\n" +
                "    \"constellation\": 8\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Radiant stellar body\",\n" +
                "    \"lightYears\": 1204.78,\n" +
                "    \"name\": \"Mirach\",\n" +
                "    \"starType\": \"NEUTRON_STAR\",\n" +
                "    \"constellation\": 8\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Shining beacon of the cosmos\",\n" +
                "    \"lightYears\": 692.45,\n" +
                "    \"name\": \"Algol\",\n" +
                "    \"starType\": \"RED_GIANT\",\n" +
                "    \"constellation\": 15\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Dazzling cosmic entity\",\n" +
                "    \"lightYears\": 437.22,\n" +
                "    \"name\": \"Baten\",\n" +
                "    \"starType\": \"NEUTRON_STAR\",\n" +
                "    \"constellation\": 12\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Glowing celestial object\",\n" +
                "    \"lightYears\": 139.92,\n" +
                "    \"name\": \"Yara\",\n" +
                "    \"starType\": \"RED_GIANT\",\n" +
                "    \"constellation\": 3\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Celestial source of light and energy\",\n" +
                "    \"lightYears\": 196.43,\n" +
                "    \"name\": \"Alhena\",\n" +
                "    \"starType\": \"WHITE_DWARF\",\n" +
                "    \"constellation\": 5\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Cosmic spectacle of luminosity\",\n" +
                "    \"lightYears\": 39.75,\n" +
                "    \"name\": \"Schedar\",\n" +
                "    \"starType\": \"NEUTRON_STAR\",\n" +
                "    \"constellation\": 10\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Luminous star\",\n" +
                "    \"lightYears\": 9000,\n" +
                "    \"name\": \"Gacrux\",\n" +
                "    \"starType\": \"WHITE_DWARF\",\n" +
                "    \"constellation\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Radiant point of light\",\n" +
                "    \"lightYears\": 1652.34,\n" +
                "    \"name\": \"Achernar\",\n" +
                "    \"starType\": \"RED_GIANT\",\n" +
                "    \"constellation\": 19\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Blazing celestial sphere\",\n" +
                "    \"lightYears\": 818.79,\n" +
                "    \"name\": \"Hamal\",\n" +
                "    \"starType\": \"WHITE_DWARF\",\n" +
                "    \"constellation\": 16\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Celestial object\",\n" +
                "    \"lightYears\": 1623.55,\n" +
                "    \"name\": \"Achird\",\n" +
                "    \"starType\": \"NEUTRON_STAR\",\n" +
                "    \"constellation\": 7\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Glowing cosmic body\",\n" +
                "    \"lightYears\": 599.23,\n" +
                "    \"name\": \"Menkar\",\n" +
                "    \"starType\": \"RED_GIANT\",\n" +
                "    \"constellation\": 11\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Shimmering celestial beacon\",\n" +
                "    \"lightYears\": 2624.47,\n" +
                "    \"name\": \"Diphda\",\n" +
                "    \"starType\": \"NEUTRON_STAR\",\n" +
                "    \"constellation\": 19\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Dazzling star\",\n" +
                "    \"lightYears\": 1745.88,\n" +
                "    \"name\": \"Alcyone\",\n" +
                "    \"starType\": \"RED_GIANT\",\n" +
                "    \"constellation\": 9\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Lustrous celestial entity\",\n" +
                "    \"lightYears\": 3452.76,\n" +
                "    \"name\": \"Aludra\",\n" +
                "    \"starType\": \"WHITE_DWARF\",\n" +
                "    \"constellation\": 19\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Celestial source of radiance\",\n" +
                "    \"lightYears\": 1689.67,\n" +
                "    \"name\": \"Alnair\",\n" +
                "    \"starType\": \"NEUTRON_STAR\",\n" +
                "    \"constellation\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Giant orb of cosmic fire\",\n" +
                "    \"lightYears\": 155.21,\n" +
                "    \"name\": \"Adhara\",\n" +
                "    \"starType\": \"NEUTRON_STAR\",\n" +
                "    \"constellation\": 19\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Radiant cosmic object\",\n" +
                "    \"lightYears\": 744.89,\n" +
                "    \"name\": \"Algieba\",\n" +
                "    \"starType\": \"WHITE_DWARF\",\n" +
                "    \"constellation\": 12\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Shining celestial body\",\n" +
                "    \"lightYears\": 557.59,\n" +
                "    \"name\": \"Alphard\",\n" +
                "    \"starType\": \"RED_GIANT\",\n" +
                "    \"constellation\": 16\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Fiery cosmic beacon\",\n" +
                "    \"lightYears\": 1382.12,\n" +
                "    \"name\": \"Alcor\",\n" +
                "    \"starType\": \"RED_GIANT\",\n" +
                "    \"constellation\": 17\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Luminous point of light\",\n" +
                "    \"lightYears\": 765.45,\n" +
                "    \"name\": \"Mira\",\n" +
                "    \"starType\": \"NEUTRON_STAR\",\n" +
                "    \"constellation\": 4\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Cosmic furnace\",\n" +
                "    \"lightYears\": 645.56,\n" +
                "    \"name\": \"Alkes\",\n" +
                "    \"starType\": \"WHITE_DWARF\",\n" +
                "    \"constellation\": 10\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Glowing celestial sphere\",\n" +
                "    \"lightYears\": 298.43,\n" +
                "    \"name\": \"Alhakim\",\n" +
                "    \"starType\": \"NEUTRON_STAR\",\n" +
                "    \"constellation\": 8\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Shimmering cosmic entity\",\n" +
                "    \"lightYears\": 195.75,\n" +
                "    \"name\": \"Almach\",\n" +
                "    \"starType\": \"WHITE_DWARF\",\n" +
                "    \"constellation\": 15\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Dazzling stellar beacon\",\n" +
                "    \"lightYears\": 4802.65,\n" +
                "    \"name\": \"Albireo\",\n" +
                "    \"starType\": \"NEUTRON_STAR\",\n" +
                "    \"constellation\": 19\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Lustrous celestial body\",\n" +
                "    \"lightYears\": 1943.56,\n" +
                "    \"name\": \"Alpherg\",\n" +
                "    \"starType\": \"RED_GIANT\",\n" +
                "    \"constellation\": 1\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Celestial source of light and energy\",\n" +
                "    \"lightYears\": 721.34,\n" +
                "    \"name\": \"Alphatrianguli\",\n" +
                "    \"starType\": \"RED_GIANT\",\n" +
                "    \"constellation\": 4\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Blazing star\",\n" +
                "    \"lightYears\": 245.45,\n" +
                "    \"name\": \"Alwaid\",\n" +
                "    \"starType\": \"NEUTRON_STAR\",\n" +
                "    \"constellation\": 5\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Celestial furnace\",\n" +
                "    \"lightYears\": 882.99,\n" +
                "    \"name\": \"Alwarid\",\n" +
                "    \"starType\": \"WHITE_DWARF\",\n" +
                "    \"constellation\": 13\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Radiant cosmic body\",\n" +
                "    \"lightYears\": 569.01,\n" +
                "    \"name\": \"Alzirr\",\n" +
                "    \"starType\": \"NEUTRON_STAR\",\n" +
                "    \"constellation\": 18\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Shining beacon in the night sky\",\n" +
                "    \"lightYears\": 282.88,\n" +
                "    \"name\": \"Proxima Centauri\",\n" +
                "    \"starType\": \"RED_GIANT\",\n" +
                "    \"constellation\": 19\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Glowing celestial object\",\n" +
                "    \"lightYears\": 413.34,\n" +
                "    \"name\": \"Celaeno\",\n" +
                "    \"starType\": \"RED_GIANT\",\n" +
                "    \"constellation\": 2\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Celestial entity\",\n" +
                "    \"lightYears\": 651.21,\n" +
                "    \"name\": \"Electra\",\n" +
                "    \"starType\": \"WHITE_DWARF\",\n" +
                "    \"constellation\": 7\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Radiant point of light\",\n" +
                "    \"lightYears\": 4715.78,\n" +
                "    \"name\": \"Eltanin\",\n" +
                "    \"starType\": \"WHITE_DWARF\",\n" +
                "    \"constellation\": 13\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Fiery cosmic beacon\",\n" +
                "    \"lightYears\": 2576.12,\n" +
                "    \"name\": \"Errai\",\n" +
                "    \"starType\": \"NEUTRON_STAR\",\n" +
                "    \"constellation\": 16\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Luminous celestial body\",\n" +
                "    \"lightYears\": 736.76,\n" +
                "    \"name\": \"Etamin\",\n" +
                "    \"starType\": \"RED_GIANT\",\n" +
                "    \"constellation\": 3\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Shimmering star\",\n" +
                "    \"lightYears\": 507.88,\n" +
                "    \"name\": \"Elnath\",\n" +
                "    \"starType\": \"NEUTRON_STAR\",\n" +
                "    \"constellation\": 17\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Cosmic furnace\",\n" +
                "    \"lightYears\": 270.23,\n" +
                "    \"name\": \"Epsilon Eridani\",\n" +
                "    \"starType\": \"WHITE_DWARF\",\n" +
                "    \"constellation\": 12\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Glowing stellar entity\",\n" +
                "    \"lightYears\": 600.12,\n" +
                "    \"name\": \"Eta Cassiopeiae\",\n" +
                "    \"starType\": \"RED_GIANT\",\n" +
                "    \"constellation\": 10\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Dazzling cosmic sphere\",\n" +
                "    \"lightYears\": 1681.47,\n" +
                "    \"name\": \"Gamma Draconis\",\n" +
                "    \"starType\": \"RED_GIANT\",\n" +
                "    \"constellation\": 12\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Lustrous celestial object\",\n" +
                "    \"lightYears\": 934.12,\n" +
                "    \"name\": \"Gienah\",\n" +
                "    \"starType\": \"NEUTRON_STAR\",\n" +
                "    \"constellation\": 19\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Celestial source of light and energy\",\n" +
                "    \"lightYears\": 2755.89,\n" +
                "    \"name\": \"Graffias\",\n" +
                "    \"starType\": \"NEUTRON_STAR\",\n" +
                "    \"constellation\": 19\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Blazing beacon in the cosmos\",\n" +
                "    \"lightYears\": 567.59,\n" +
                "    \"name\": \"Hadar\",\n" +
                "    \"starType\": \"RED_GIANT\",\n" +
                "    \"constellation\": 13\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Radiant point of light\",\n" +
                "    \"lightYears\": 1362.12,\n" +
                "    \"name\": \"Homam\",\n" +
                "    \"starType\": \"WHITE_DWARF\",\n" +
                "    \"constellation\": 15\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Shining celestial beacon\",\n" +
                "    \"lightYears\": 775.45,\n" +
                "    \"name\": \"Iota Draconis\",\n" +
                "    \"starType\": \"NEUTRON_STAR\",\n" +
                "    \"constellation\": 16\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Glowing cosmic body\",\n" +
                "    \"lightYears\": 635.56,\n" +
                "    \"name\": \"Izar\",\n" +
                "    \"starType\": \"WHITE_DWARF\",\n" +
                "    \"constellation\": 2\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Heavenly body\",\n" +
                "    \"lightYears\": 398.43,\n" +
                "    \"name\": \"Kaus Australis\",\n" +
                "    \"starType\": \"RED_GIANT\",\n" +
                "    \"constellation\": 11\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Luminous star\",\n" +
                "    \"lightYears\": 105.75,\n" +
                "    \"name\": \"Kaus Borealis\",\n" +
                "    \"starType\": \"WHITE_DWARF\",\n" +
                "    \"constellation\": 5\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Shimmering celestial object\",\n" +
                "    \"lightYears\": 752.65,\n" +
                "    \"name\": \"Kochab\",\n" +
                "    \"starType\": \"NEUTRON_STAR\",\n" +
                "    \"constellation\": 17\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Heavenly body illuminating the darkness\",\n" +
                "    \"lightYears\": 1843.56,\n" +
                "    \"name\": \"Lesath\",\n" +
                "    \"starType\": \"RED_GIANT\",\n" +
                "    \"constellation\": 3\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Lustrous celestial beacon\",\n" +
                "    \"lightYears\": 291.34,\n" +
                "    \"name\": \"Marfik\",\n" +
                "    \"starType\": \"WHITE_DWARF\",\n" +
                "    \"constellation\": 14\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Celestial source of light and energy\",\n" +
                "    \"lightYears\": 422.45,\n" +
                "    \"name\": \"Markab\",\n" +
                "    \"starType\": \"NEUTRON_STAR\",\n" +
                "    \"constellation\": 12\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Blazing star\",\n" +
                "    \"lightYears\": 338.99,\n" +
                "    \"name\": \"Mimosa\",\n" +
                "    \"starType\": \"RED_GIANT\",\n" +
                "    \"constellation\": 9\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Celestial furnace\",\n" +
                "    \"lightYears\": 539.01,\n" +
                "    \"name\": \"Mirphak\",\n" +
                "    \"starType\": \"RED_GIANT\",\n" +
                "    \"constellation\": 19\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Radiant cosmic body\",\n" +
                "    \"lightYears\": 192.88,\n" +
                "    \"name\": \"Mizar\",\n" +
                "    \"starType\": \"NEUTRON_STAR\",\n" +
                "    \"constellation\": 16\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Shining beacon of the cosmos\",\n" +
                "    \"lightYears\": 326.34,\n" +
                "    \"name\": \"Mu Cephei\",\n" +
                "    \"starType\": \"WHITE_DWARF\",\n" +
                "    \"constellation\": 8\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Glowing celestial sphere\",\n" +
                "    \"lightYears\": 1051.21,\n" +
                "    \"name\": \"Nashira\",\n" +
                "    \"starType\": \"RED_GIANT\",\n" +
                "    \"constellation\": 4\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Heavenly body radiating luminosity\",\n" +
                "    \"lightYears\": 3715.78,\n" +
                "    \"name\": \"Navi\",\n" +
                "    \"starType\": \"NEUTRON_STAR\",\n" +
                "    \"constellation\": 7\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Luminous point of light\",\n" +
                "    \"lightYears\": 976.12,\n" +
                "    \"name\": \"Peacock\",\n" +
                "    \"starType\": \"WHITE_DWARF\",\n" +
                "    \"constellation\": 1\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Cosmic furnace\",\n" +
                "    \"lightYears\": 646.76,\n" +
                "    \"name\": \"Phact\",\n" +
                "    \"starType\": \"NEUTRON_STAR\",\n" +
                "    \"constellation\": 8\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Glowing celestial entity\",\n" +
                "    \"lightYears\": 802.88,\n" +
                "    \"name\": \"Pi Hydrae\",\n" +
                "    \"starType\": \"RED_GIANT\",\n" +
                "    \"constellation\": 3\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Shimmering star\",\n" +
                "    \"lightYears\": 523.23,\n" +
                "    \"name\": \"Polis\",\n" +
                "    \"starType\": \"RED_GIANT\",\n" +
                "    \"constellation\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Dazzling cosmic beacon\",\n" +
                "    \"lightYears\": 270.12,\n" +
                "    \"name\": \"Porrima\",\n" +
                "    \"starType\": \"WHITE_DWARF\",\n" +
                "    \"constellation\": 17\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Lustrous celestial body\",\n" +
                "    \"lightYears\": 156.56,\n" +
                "    \"name\": \"Phecda\",\n" +
                "    \"starType\": \"NEUTRON_STAR\",\n" +
                "    \"constellation\": 3\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Celestial source of light and energy\",\n" +
                "    \"lightYears\": 196.43,\n" +
                "    \"name\": \"Rasalgethi\",\n" +
                "    \"starType\": \"NEUTRON_STAR\",\n" +
                "    \"constellation\": 12\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Blazing cosmic sphere\",\n" +
                "    \"lightYears\": 130.75,\n" +
                "    \"name\": \"Rasalhague\",\n" +
                "    \"starType\": \"WHITE_DWARF\",\n" +
                "    \"constellation\": 15\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Radiant star\",\n" +
                "    \"lightYears\": 4752.65,\n" +
                "    \"name\": \"Rastaban\",\n" +
                "    \"starType\": \"RED_GIANT\",\n" +
                "    \"constellation\": 4\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Shining celestial object\",\n" +
                "    \"lightYears\": 1681.47,\n" +
                "    \"name\": \"Rigil Kentaurus\",\n" +
                "    \"starType\": \"NEUTRON_STAR\",\n" +
                "    \"constellation\": 16\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Glowing cosmic beacon\",\n" +
                "    \"lightYears\": 934.12,\n" +
                "    \"name\": \"Ruchbah\",\n" +
                "    \"starType\": \"WHITE_DWARF\",\n" +
                "    \"constellation\": 15\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Heavenly body\",\n" +
                "    \"lightYears\": 2755.89,\n" +
                "    \"name\": \"Sadalbari\",\n" +
                "    \"starType\": \"RED_GIANT\",\n" +
                "    \"constellation\": 12\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Luminous point of light\",\n" +
                "    \"lightYears\": 567.59,\n" +
                "    \"name\": \"Sadalmelik\",\n" +
                "    \"starType\": \"NEUTRON_STAR\",\n" +
                "    \"constellation\": 14\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Cosmic furnace\",\n" +
                "    \"lightYears\": 1362.12,\n" +
                "    \"name\": \"Sadalsuud\",\n" +
                "    \"starType\": \"NEUTRON_STAR\",\n" +
                "    \"constellation\": 15\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Radiant celestial entity\",\n" +
                "    \"lightYears\": 775.45,\n" +
                "    \"name\": \"Saiph\",\n" +
                "    \"starType\": \"RED_GIANT\",\n" +
                "    \"constellation\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Shimmering star\",\n" +
                "    \"lightYears\": 635.56,\n" +
                "    \"name\": \"Sargas\",\n" +
                "    \"starType\": \"WHITE_DWARF\",\n" +
                "    \"constellation\": 14\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Dazzling cosmic body\",\n" +
                "    \"lightYears\": 398.43,\n" +
                "    \"name\": \"Scheat\",\n" +
                "    \"starType\": \"RED_GIANT\",\n" +
                "    \"constellation\": 11\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Lustrous celestial beacon\",\n" +
                "    \"lightYears\": 105.75,\n" +
                "    \"name\": \"Sheratan\",\n" +
                "    \"starType\": \"NEUTRON_STAR\",\n" +
                "    \"constellation\": 19\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Celestial source of light and energy\",\n" +
                "    \"lightYears\": 752.65,\n" +
                "    \"name\": \"Shaula\",\n" +
                "    \"starType\": \"WHITE_DWARF\",\n" +
                "    \"constellation\": 1\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Blazing star\",\n" +
                "    \"lightYears\": 1843.56,\n" +
                "    \"name\": \"Situla\",\n" +
                "    \"starType\": \"NEUTRON_STAR\",\n" +
                "    \"constellation\": 10\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Glowing celestial body\",\n" +
                "    \"lightYears\": 291.34,\n" +
                "    \"name\": \"Talitha\",\n" +
                "    \"starType\": \"RED_GIANT\",\n" +
                "    \"constellation\": 17\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Radiant point of light\",\n" +
                "    \"lightYears\": 422.45,\n" +
                "    \"name\": \"Thuban\",\n" +
                "    \"starType\": \"NEUTRON_STAR\",\n" +
                "    \"constellation\": 13\n" +
                "  }\n" +
                "]";

        String actual = starService.readStarsFileContent();

        Assertions.assertEquals(expected, actual);
    }
}