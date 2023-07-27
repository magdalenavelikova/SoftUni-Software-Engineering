package softuni.exam.readFile;
//TestMechanicsServiceReadFromFile

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import softuni.exam.service.impl.MechanicsServiceImpl;

import java.io.IOException;

@ExtendWith(MockitoExtension.class)
public class TestMechanicsServiceReadFromFile {

    @InjectMocks
    private MechanicsServiceImpl mechanicsService;

    @Test
    void readMechanicsFromFile() throws IOException {

        String expected = "[\n" +
                "  {\n" +
                "    \"email\": \"lrann0@t-online.de\",\n" +
                "    \"firstName\": \"Lorna\",\n" +
                "    \"lastName\": \"Rann\",\n" +
                "    \"phone\": \"462-463-0432\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"ksterland1@hubpages.com\",\n" +
                "    \"firstName\": \"Krystal\",\n" +
                "    \"lastName\": \"Sterland\",\n" +
                "    \"phone\": \"201-115-5358\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"qle@es.com\",\n" +
                "    \"firstName\": \"Q\",\n" +
                "    \"lastName\": \"Beck\",\n" +
                "    \"phone\": \"101-135-6558\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"wrongNumber@no.com\",\n" +
                "    \"firstName\": \"Qentin\",\n" +
                "    \"lastName\": \"Jock\",\n" +
                "    \"phone\": \"1\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"gledeker2@amazon.com\",\n" +
                "    \"firstName\": \"Gerladina\",\n" +
                "    \"lastName\": \"Ledeker\",\n" +
                "    \"phone\": \"534-162-5734\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"ksterland1@hubpages.com\",\n" +
                "    \"firstName\": \"Deidre\",\n" +
                "    \"lastName\": \"Goodinge\",\n" +
                "    \"phone\": \"148-743-0753\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"dhebard4@histats.com\",\n" +
                "    \"firstName\": \"Dulcy\",\n" +
                "    \"lastName\": \"Hebard\",\n" +
                "    \"phone\": \"654-577-5713\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"jbisley5@yandex.ru\",\n" +
                "    \"firstName\": \"Jedd\",\n" +
                "    \"lastName\": \"Bisley\",\n" +
                "    \"phone\": \"294-274-0482\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"lglendenning6@tripadvisor.com\",\n" +
                "    \"firstName\": \"Lizbeth\",\n" +
                "    \"lastName\": \"Glendenning\",\n" +
                "    \"phone\": \"654-208-9686\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"mmonteith7@upenn.edu\",\n" +
                "    \"firstName\": \"Megan\",\n" +
                "    \"lastName\": \"Monteith\",\n" +
                "    \"phone\": \"553-464-5011\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"mburner8@artisteer.com\",\n" +
                "    \"firstName\": \"Mandel\",\n" +
                "    \"lastName\": \"Burner\",\n" +
                "    \"phone\": \"802-835-8210\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"dmcnelly9@statcounter.com\",\n" +
                "    \"firstName\": \"Don\",\n" +
                "    \"lastName\": \"McNelly\",\n" +
                "    \"phone\": \"381-295-6186\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"afilkina@amazon.com\",\n" +
                "    \"firstName\": \"Averill\",\n" +
                "    \"lastName\": \"Filkin\",\n" +
                "    \"phone\": \"440-470-2126\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"jreederb@apple.com\",\n" +
                "    \"firstName\": \"Johannes\",\n" +
                "    \"lastName\": \"Reeder\",\n" +
                "    \"phone\": \"855-102-5136\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"mlegerc@google.ca\",\n" +
                "    \"firstName\": \"Madelaine\",\n" +
                "    \"lastName\": \"Leger\",\n" +
                "    \"phone\": \"283-672-3702\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"apenellid@so-net.ne.jp\",\n" +
                "    \"firstName\": \"Ashlie\",\n" +
                "    \"lastName\": \"Penelli\",\n" +
                "    \"phone\": \"881-142-4258\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"ealrede@google.it\",\n" +
                "    \"firstName\": \"Erda\",\n" +
                "    \"lastName\": \"Alred\",\n" +
                "    \"phone\": \"328-462-7059\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"dletchfordf@blogspot.com\",\n" +
                "    \"firstName\": \"Delcina\",\n" +
                "    \"lastName\": \"Letchford\",\n" +
                "    \"phone\": \"405-699-6016\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"cstylesg@stanford.edu\",\n" +
                "    \"firstName\": \"Caldwell\",\n" +
                "    \"lastName\": \"Styles\",\n" +
                "    \"phone\": \"767-550-6136\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"cmacsorleyh@lycos.com\",\n" +
                "    \"firstName\": \"Cleve\",\n" +
                "    \"lastName\": \"MacSorley\",\n" +
                "    \"phone\": \"674-370-2684\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"cmacpikei@bigcartel.com\",\n" +
                "    \"firstName\": \"Christie\",\n" +
                "    \"lastName\": \"MacPike\",\n" +
                "    \"phone\": \"636-208-4855\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"bkaiserj@salon.com\",\n" +
                "    \"firstName\": \"Brynn\",\n" +
                "    \"lastName\": \"Kaiser\",\n" +
                "    \"phone\": \"168-581-0231\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"tdagostinok@dagondesign.com\",\n" +
                "    \"firstName\": \"Teddy\",\n" +
                "    \"lastName\": \"D'Agostino\",\n" +
                "    \"phone\": \"269-545-3066\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"mredmanl@aol.com\",\n" +
                "    \"firstName\": \"Marsha\",\n" +
                "    \"lastName\": \"Redman\",\n" +
                "    \"phone\": \"435-882-4065\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"aashwinm@noaa.gov\",\n" +
                "    \"firstName\": \"Alexei\",\n" +
                "    \"lastName\": \"Ashwin\",\n" +
                "    \"phone\": \"950-433-9171\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"hmccanen@infoseek.co.jp\",\n" +
                "    \"firstName\": \"Hanan\",\n" +
                "    \"lastName\": \"McCane\",\n" +
                "    \"phone\": \"241-738-8061\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"mmarzelleo@squarespace.com\",\n" +
                "    \"firstName\": \"Margalo\",\n" +
                "    \"lastName\": \"Marzelle\",\n" +
                "    \"phone\": \"202-980-7909\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"egerretsp@1und1.de\",\n" +
                "    \"firstName\": \"Evvie\",\n" +
                "    \"lastName\": \"Gerrets\",\n" +
                "    \"phone\": \"994-770-7496\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"fwhooleyq@macromedia.com\",\n" +
                "    \"firstName\": \"Flynn\",\n" +
                "    \"lastName\": \"Whooley\",\n" +
                "    \"phone\": \"443-108-4458\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"pconewr@ft.com\",\n" +
                "    \"firstName\": \"Pinchas\",\n" +
                "    \"lastName\": \"Conew\",\n" +
                "    \"phone\": \"239-865-1955\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"knansons@oakley.com\",\n" +
                "    \"firstName\": \"Kristoforo\",\n" +
                "    \"lastName\": \"Nanson\",\n" +
                "    \"phone\": \"277-730-2159\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"gwillmentt@1und1.de\",\n" +
                "    \"firstName\": \"Giacobo\",\n" +
                "    \"lastName\": \"Willment\",\n" +
                "    \"phone\": \"905-109-2744\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"dhewertsonu@google.com.br\",\n" +
                "    \"firstName\": \"Dene\",\n" +
                "    \"lastName\": \"Hewertson\",\n" +
                "    \"phone\": \"341-540-1468\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"awickesv@histats.com\",\n" +
                "    \"firstName\": \"Alexina\",\n" +
                "    \"lastName\": \"Wickes\",\n" +
                "    \"phone\": \"699-303-0200\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"pstutew@indiatimes.com\",\n" +
                "    \"firstName\": \"Paddie\",\n" +
                "    \"lastName\": \"Stute\",\n" +
                "    \"phone\": \"227-211-6126\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"bcruzx@nps.gov\",\n" +
                "    \"firstName\": \"Batholomew\",\n" +
                "    \"lastName\": \"Cruz\",\n" +
                "    \"phone\": \"710-168-0555\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"tmattimoey@cnbc.com\",\n" +
                "    \"firstName\": \"Tanhya\",\n" +
                "    \"lastName\": \"Mattimoe\",\n" +
                "    \"phone\": \"289-272-3471\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"aantoinetz@php.net\",\n" +
                "    \"firstName\": \"Any\",\n" +
                "    \"lastName\": \"Antoinet\",\n" +
                "    \"phone\": \"291-616-6835\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"tdupre10@dmoz.org\",\n" +
                "    \"firstName\": \"Thain\",\n" +
                "    \"lastName\": \"Dupre\",\n" +
                "    \"phone\": \"317-928-4866\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"plovstrom11@youku.com\",\n" +
                "    \"firstName\": \"Philly\",\n" +
                "    \"lastName\": \"Lovstrom\",\n" +
                "    \"phone\": \"418-908-0179\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"kpauler12@netvibes.com\",\n" +
                "    \"firstName\": \"Koenraad\",\n" +
                "    \"lastName\": \"Pauler\",\n" +
                "    \"phone\": \"640-579-0492\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"apimerick13@google.co.uk\",\n" +
                "    \"firstName\": \"Althea\",\n" +
                "    \"lastName\": \"Pimerick\",\n" +
                "    \"phone\": \"154-230-7121\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"dhause14@digg.com\",\n" +
                "    \"firstName\": \"Devin\",\n" +
                "    \"lastName\": \"Hause\",\n" +
                "    \"phone\": \"714-644-3264\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"bwickey15@google.ru\",\n" +
                "    \"firstName\": \"Bria\",\n" +
                "    \"lastName\": \"Wickey\",\n" +
                "    \"phone\": \"468-563-0303\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"itownrow16@mozilla.org\",\n" +
                "    \"firstName\": \"Idalina\",\n" +
                "    \"lastName\": \"Townrow\",\n" +
                "    \"phone\": \"984-634-7874\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"blowdes17@list-manage.com\",\n" +
                "    \"firstName\": \"Brigit\",\n" +
                "    \"lastName\": \"Lowdes\",\n" +
                "    \"phone\": \"179-612-6019\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"jbelchem18@blogger.com\",\n" +
                "    \"firstName\": \"Jephthah\",\n" +
                "    \"lastName\": \"Belchem\",\n" +
                "    \"phone\": \"538-391-0342\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"rbeig19@whitehouse.gov\",\n" +
                "    \"firstName\": \"Roshelle\",\n" +
                "    \"lastName\": \"Beig\",\n" +
                "    \"phone\": \"616-212-9900\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"lmyring1a@sourceforge.net\",\n" +
                "    \"firstName\": \"Lothaire\",\n" +
                "    \"lastName\": \"Myring\",\n" +
                "    \"phone\": \"586-703-0180\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"oearengey1b@nature.com\",\n" +
                "    \"firstName\": \"Ozzie\",\n" +
                "    \"lastName\": \"Earengey\",\n" +
                "    \"phone\": \"188-646-3011\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"fcaslake1c@elpais.com\",\n" +
                "    \"firstName\": \"Fiorenze\",\n" +
                "    \"lastName\": \"Caslake\",\n" +
                "    \"phone\": \"328-812-5012\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"hgarr1d@ocn.ne.jp\",\n" +
                "    \"firstName\": \"Hatty\",\n" +
                "    \"lastName\": \"Garr\",\n" +
                "    \"phone\": \"189-425-6386\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"htuther1e@toplist.cz\",\n" +
                "    \"firstName\": \"Hew\",\n" +
                "    \"lastName\": \"Tuther\",\n" +
                "    \"phone\": \"276-775-2292\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"sbewsy1f@typepad.com\",\n" +
                "    \"firstName\": \"Sandor\",\n" +
                "    \"lastName\": \"Bewsy\",\n" +
                "    \"phone\": \"901-654-6584\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"abudibent1g@kickstarter.com\",\n" +
                "    \"firstName\": \"Abbye\",\n" +
                "    \"lastName\": \"Budibent\",\n" +
                "    \"phone\": \"234-643-4640\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"rlimon1h@sphinn.com\",\n" +
                "    \"firstName\": \"Roseline\",\n" +
                "    \"lastName\": \"Limon\",\n" +
                "    \"phone\": \"528-227-1972\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"mbeamont1i@phpbb.com\",\n" +
                "    \"firstName\": \"Modesta\",\n" +
                "    \"lastName\": \"Beamont\",\n" +
                "    \"phone\": \"332-460-1580\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"gmccrostie1j@auda.org.au\",\n" +
                "    \"firstName\": \"Gerianne\",\n" +
                "    \"lastName\": \"McCrostie\",\n" +
                "    \"phone\": \"321-866-5406\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"zguidini1k@guardian.co.uk\",\n" +
                "    \"firstName\": \"Zuzana\",\n" +
                "    \"lastName\": \"Guidini\",\n" +
                "    \"phone\": \"981-847-6044\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"acrossdale1l@wix.com\",\n" +
                "    \"firstName\": \"Allyn\",\n" +
                "    \"lastName\": \"Crossdale\",\n" +
                "    \"phone\": \"222-180-9369\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"cjapp1m@springer.com\",\n" +
                "    \"firstName\": \"Coleen\",\n" +
                "    \"lastName\": \"Japp\",\n" +
                "    \"phone\": \"981-286-9681\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"lpetren1n@opera.com\",\n" +
                "    \"firstName\": \"Leopold\",\n" +
                "    \"lastName\": \"Petren\",\n" +
                "    \"phone\": \"232-517-3969\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"rgarlette1o@ezinearticles.com\",\n" +
                "    \"firstName\": \"Rozanna\",\n" +
                "    \"lastName\": \"Garlette\",\n" +
                "    \"phone\": \"266-799-6662\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"dbennion1p@livejournal.com\",\n" +
                "    \"firstName\": \"Deanne\",\n" +
                "    \"lastName\": \"Bennion\",\n" +
                "    \"phone\": \"194-344-7071\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"mpedri1q@dropbox.com\",\n" +
                "    \"firstName\": \"Marysa\",\n" +
                "    \"lastName\": \"Pedri\",\n" +
                "    \"phone\": \"146-868-1978\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"spine1r@google.com.hk\",\n" +
                "    \"firstName\": \"Sharron\",\n" +
                "    \"lastName\": \"Pine\",\n" +
                "    \"phone\": \"749-729-3438\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"lblunsom1s@seesaa.net\",\n" +
                "    \"firstName\": \"Leopoldl\",\n" +
                "    \"lastName\": \"Blunsom\",\n" +
                "    \"phone\": \"566-116-5035\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"cmanicomb1t@flavors.me\",\n" +
                "    \"firstName\": \"Cary\",\n" +
                "    \"lastName\": \"Manicomb\",\n" +
                "    \"phone\": \"868-423-6927\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"larmatidge1u@alexa.com\",\n" +
                "    \"firstName\": \"Laurens\",\n" +
                "    \"lastName\": \"Armatidge\",\n" +
                "    \"phone\": \"939-827-1500\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"eselwin1v@webnode.com\",\n" +
                "    \"firstName\": \"Ebonee\",\n" +
                "    \"lastName\": \"Selwin\",\n" +
                "    \"phone\": \"481-949-4515\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"emcsporon1w@skype.com\",\n" +
                "    \"firstName\": \"Engracia\",\n" +
                "    \"lastName\": \"McSporon\",\n" +
                "    \"phone\": \"875-563-4466\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"mplaschke1x@slate.com\",\n" +
                "    \"firstName\": \"Margot\",\n" +
                "    \"lastName\": \"Plaschke\",\n" +
                "    \"phone\": \"692-803-5242\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"cdurgan1y@patch.com\",\n" +
                "    \"firstName\": \"Cassandre\",\n" +
                "    \"lastName\": \"Durgan\",\n" +
                "    \"phone\": \"959-676-9475\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"upinchin1z@china.com.cn\",\n" +
                "    \"firstName\": \"Ursula\",\n" +
                "    \"lastName\": \"Pinchin\",\n" +
                "    \"phone\": \"480-287-0022\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"scoult20@thetimes.co.uk\",\n" +
                "    \"firstName\": \"Sallyanne\",\n" +
                "    \"lastName\": \"Coult\",\n" +
                "    \"phone\": \"728-129-7772\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"mceccoli21@surveymonkey.com\",\n" +
                "    \"firstName\": \"Miguela\",\n" +
                "    \"lastName\": \"Ceccoli\",\n" +
                "    \"phone\": \"804-584-1454\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"fspoerl22@w3.org\",\n" +
                "    \"firstName\": \"Flemming\",\n" +
                "    \"lastName\": \"Spoerl\",\n" +
                "    \"phone\": \"344-246-3902\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"mlowdham23@chronoengine.com\",\n" +
                "    \"firstName\": \"Marchall\",\n" +
                "    \"lastName\": \"Lowdham\",\n" +
                "    \"phone\": \"456-295-1108\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"cgraalman24@redcross.org\",\n" +
                "    \"firstName\": \"Cortney\",\n" +
                "    \"lastName\": \"Graalman\",\n" +
                "    \"phone\": \"287-791-8367\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"mjessup25@cnbc.com\",\n" +
                "    \"firstName\": \"Moira\",\n" +
                "    \"lastName\": \"Jessup\",\n" +
                "    \"phone\": \"818-354-5009\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"lmagenny26@diigo.com\",\n" +
                "    \"firstName\": \"Lonnie\",\n" +
                "    \"lastName\": \"Magenny\",\n" +
                "    \"phone\": \"315-508-0206\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"cstorry27@hexun.com\",\n" +
                "    \"firstName\": \"Claretta\",\n" +
                "    \"lastName\": \"Storry\",\n" +
                "    \"phone\": \"313-585-9040\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"xkunrad28@blogger.com\",\n" +
                "    \"firstName\": \"Ximenez\",\n" +
                "    \"lastName\": \"Kunrad\",\n" +
                "    \"phone\": \"993-896-0533\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"odenson29@miitbeian.gov.cn\",\n" +
                "    \"firstName\": \"Ollie\",\n" +
                "    \"lastName\": \"Denson\",\n" +
                "    \"phone\": \"586-603-5316\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"pgrouer2a@wordpress.com\",\n" +
                "    \"firstName\": \"Papagena\",\n" +
                "    \"lastName\": \"Grouer\",\n" +
                "    \"phone\": \"727-327-7170\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"cminnette2b@over-blog.com\",\n" +
                "    \"firstName\": \"Caren\",\n" +
                "    \"lastName\": \"Minnette\",\n" +
                "    \"phone\": \"350-586-2250\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"omcnelly2c@issuu.com\",\n" +
                "    \"firstName\": \"Onfroi\",\n" +
                "    \"lastName\": \"McNelly\",\n" +
                "    \"phone\": \"748-858-8647\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"mchesterfield2d@businessweek.com\",\n" +
                "    \"firstName\": \"Mariel\",\n" +
                "    \"lastName\": \"Chesterfield\",\n" +
                "    \"phone\": \"315-773-8628\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"opavlovsky2e@state.tx.us\",\n" +
                "    \"firstName\": \"Orsa\",\n" +
                "    \"lastName\": \"Pavlovsky\",\n" +
                "    \"phone\": \"522-315-2132\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"mheintz2f@redcross.org\",\n" +
                "    \"firstName\": \"Mab\",\n" +
                "    \"lastName\": \"Heintz\",\n" +
                "    \"phone\": \"401-596-5307\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"jcrystal2g@seesaa.net\",\n" +
                "    \"firstName\": \"Justis\",\n" +
                "    \"lastName\": \"Crystal\",\n" +
                "    \"phone\": \"530-312-5315\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"mkrug2h@tumblr.com\",\n" +
                "    \"firstName\": \"Maritsa\",\n" +
                "    \"lastName\": \"Krug\",\n" +
                "    \"phone\": \"589-778-3142\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"ostonman2i@umn.edu\",\n" +
                "    \"firstName\": \"Osbourne\",\n" +
                "    \"lastName\": \"Stonman\",\n" +
                "    \"phone\": \"970-762-5563\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"cwharby2j@vk.com\",\n" +
                "    \"firstName\": \"Caritta\",\n" +
                "    \"lastName\": \"Wharby\",\n" +
                "    \"phone\": \"108-596-3715\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"sgrindall2k@japanpost.jp\",\n" +
                "    \"firstName\": \"Sunny\",\n" +
                "    \"lastName\": \"Grindall\",\n" +
                "    \"phone\": \"770-242-8405\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"aaiken2l@cnn.com\",\n" +
                "    \"firstName\": \"Alanson\",\n" +
                "    \"lastName\": \"Aiken\",\n" +
                "    \"phone\": \"499-641-5762\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"rrostron2m@wufoo.com\",\n" +
                "    \"firstName\": \"Rubi\",\n" +
                "    \"lastName\": \"Rostron\",\n" +
                "    \"phone\": \"594-426-1997\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"eyaxley2n@blogtalkradio.com\",\n" +
                "    \"firstName\": \"Esdras\",\n" +
                "    \"lastName\": \"Yaxley\",\n" +
                "    \"phone\": \"629-790-5234\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"vclipston2o@lulu.com\",\n" +
                "    \"firstName\": \"Viva\",\n" +
                "    \"lastName\": \"Clipston\",\n" +
                "    \"phone\": \"639-744-9339\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"nmurrhaupt2p@examiner.com\",\n" +
                "    \"firstName\": \"Nickie\",\n" +
                "    \"lastName\": \"Murrhaupt\",\n" +
                "    \"phone\": \"274-645-2678\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"rfurminger2q@house.gov\",\n" +
                "    \"firstName\": \"Raphaela\",\n" +
                "    \"lastName\": \"Furminger\",\n" +
                "    \"phone\": \"638-171-8744\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"psmallwood2r@prweb.com\",\n" +
                "    \"firstName\": \"Pia\",\n" +
                "    \"lastName\": \"Smallwood\",\n" +
                "    \"phone\": \"222-452-8521\"\n" +
                "  }\n" +
                "]";

        String actual = mechanicsService.readMechanicsFromFile();

        Assertions.assertEquals(expected, actual);
    }
}