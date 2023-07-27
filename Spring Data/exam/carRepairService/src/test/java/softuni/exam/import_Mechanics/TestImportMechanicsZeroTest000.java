package softuni.exam.import_Mechanics;
//TestImportMechanicsZeroTest000

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import softuni.exam.service.impl.MechanicsServiceImpl;

import java.io.IOException;

@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class TestImportMechanicsZeroTest000 {

    @Autowired
    private MechanicsServiceImpl mechanicsService;

    @Test
    void testImportMechanicsZeroTest000() throws IOException {
        String actual = mechanicsService.importMechanics();

        String expected = "Successfully imported mechanic Lorna Rann\n" +
                "Successfully imported mechanic Krystal Sterland\n" +
                "Invalid mechanic\n" +
                "Invalid mechanic\n" +
                "Successfully imported mechanic Gerladina Ledeker\n" +
                "Invalid mechanic\n" +
                "Successfully imported mechanic Dulcy Hebard\n" +
                "Successfully imported mechanic Jedd Bisley\n" +
                "Successfully imported mechanic Lizbeth Glendenning\n" +
                "Successfully imported mechanic Megan Monteith\n" +
                "Successfully imported mechanic Mandel Burner\n" +
                "Successfully imported mechanic Don McNelly\n" +
                "Successfully imported mechanic Averill Filkin\n" +
                "Successfully imported mechanic Johannes Reeder\n" +
                "Successfully imported mechanic Madelaine Leger\n" +
                "Successfully imported mechanic Ashlie Penelli\n" +
                "Successfully imported mechanic Erda Alred\n" +
                "Successfully imported mechanic Delcina Letchford\n" +
                "Successfully imported mechanic Caldwell Styles\n" +
                "Successfully imported mechanic Cleve MacSorley\n" +
                "Successfully imported mechanic Christie MacPike\n" +
                "Successfully imported mechanic Brynn Kaiser\n" +
                "Successfully imported mechanic Teddy D'Agostino\n" +
                "Successfully imported mechanic Marsha Redman\n" +
                "Successfully imported mechanic Alexei Ashwin\n" +
                "Successfully imported mechanic Hanan McCane\n" +
                "Successfully imported mechanic Margalo Marzelle\n" +
                "Successfully imported mechanic Evvie Gerrets\n" +
                "Successfully imported mechanic Flynn Whooley\n" +
                "Successfully imported mechanic Pinchas Conew\n" +
                "Successfully imported mechanic Kristoforo Nanson\n" +
                "Successfully imported mechanic Giacobo Willment\n" +
                "Successfully imported mechanic Dene Hewertson\n" +
                "Successfully imported mechanic Alexina Wickes\n" +
                "Successfully imported mechanic Paddie Stute\n" +
                "Successfully imported mechanic Batholomew Cruz\n" +
                "Successfully imported mechanic Tanhya Mattimoe\n" +
                "Successfully imported mechanic Any Antoinet\n" +
                "Successfully imported mechanic Thain Dupre\n" +
                "Successfully imported mechanic Philly Lovstrom\n" +
                "Successfully imported mechanic Koenraad Pauler\n" +
                "Successfully imported mechanic Althea Pimerick\n" +
                "Successfully imported mechanic Devin Hause\n" +
                "Successfully imported mechanic Bria Wickey\n" +
                "Successfully imported mechanic Idalina Townrow\n" +
                "Successfully imported mechanic Brigit Lowdes\n" +
                "Successfully imported mechanic Jephthah Belchem\n" +
                "Successfully imported mechanic Roshelle Beig\n" +
                "Successfully imported mechanic Lothaire Myring\n" +
                "Successfully imported mechanic Ozzie Earengey\n" +
                "Successfully imported mechanic Fiorenze Caslake\n" +
                "Successfully imported mechanic Hatty Garr\n" +
                "Successfully imported mechanic Hew Tuther\n" +
                "Successfully imported mechanic Sandor Bewsy\n" +
                "Successfully imported mechanic Abbye Budibent\n" +
                "Successfully imported mechanic Roseline Limon\n" +
                "Successfully imported mechanic Modesta Beamont\n" +
                "Successfully imported mechanic Gerianne McCrostie\n" +
                "Successfully imported mechanic Zuzana Guidini\n" +
                "Successfully imported mechanic Allyn Crossdale\n" +
                "Successfully imported mechanic Coleen Japp\n" +
                "Successfully imported mechanic Leopold Petren\n" +
                "Successfully imported mechanic Rozanna Garlette\n" +
                "Successfully imported mechanic Deanne Bennion\n" +
                "Successfully imported mechanic Marysa Pedri\n" +
                "Successfully imported mechanic Sharron Pine\n" +
                "Successfully imported mechanic Leopoldl Blunsom\n" +
                "Successfully imported mechanic Cary Manicomb\n" +
                "Successfully imported mechanic Laurens Armatidge\n" +
                "Successfully imported mechanic Ebonee Selwin\n" +
                "Successfully imported mechanic Engracia McSporon\n" +
                "Successfully imported mechanic Margot Plaschke\n" +
                "Successfully imported mechanic Cassandre Durgan\n" +
                "Successfully imported mechanic Ursula Pinchin\n" +
                "Successfully imported mechanic Sallyanne Coult\n" +
                "Successfully imported mechanic Miguela Ceccoli\n" +
                "Successfully imported mechanic Flemming Spoerl\n" +
                "Successfully imported mechanic Marchall Lowdham\n" +
                "Successfully imported mechanic Cortney Graalman\n" +
                "Successfully imported mechanic Moira Jessup\n" +
                "Successfully imported mechanic Lonnie Magenny\n" +
                "Successfully imported mechanic Claretta Storry\n" +
                "Successfully imported mechanic Ximenez Kunrad\n" +
                "Successfully imported mechanic Ollie Denson\n" +
                "Successfully imported mechanic Papagena Grouer\n" +
                "Successfully imported mechanic Caren Minnette\n" +
                "Successfully imported mechanic Onfroi McNelly\n" +
                "Successfully imported mechanic Mariel Chesterfield\n" +
                "Successfully imported mechanic Orsa Pavlovsky\n" +
                "Successfully imported mechanic Mab Heintz\n" +
                "Successfully imported mechanic Justis Crystal\n" +
                "Successfully imported mechanic Maritsa Krug\n" +
                "Successfully imported mechanic Osbourne Stonman\n" +
                "Successfully imported mechanic Caritta Wharby\n" +
                "Successfully imported mechanic Sunny Grindall\n" +
                "Successfully imported mechanic Alanson Aiken\n" +
                "Successfully imported mechanic Rubi Rostron\n" +
                "Successfully imported mechanic Esdras Yaxley\n" +
                "Successfully imported mechanic Viva Clipston\n" +
                "Successfully imported mechanic Nickie Murrhaupt\n" +
                "Successfully imported mechanic Raphaela Furminger\n" +
                "Successfully imported mechanic Pia Smallwood";

        String[] actualSplit = actual.split("\\r\\n?|\\n");
        String[] expectedSplit = expected.split("\\r\\n?|\\n");

        Assertions.assertArrayEquals(expectedSplit,actualSplit);
    }
}
