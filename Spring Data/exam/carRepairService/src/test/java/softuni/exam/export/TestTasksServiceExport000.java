package softuni.exam.export;
//TestTasksServiceExport000

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import softuni.exam.service.impl.TasksServiceImpl;

import java.io.IOException;

@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class TestTasksServiceExport000 {

    @Autowired
        private TasksServiceImpl tasksService;

    @Sql("/export-test-000.sql")
    @Test
    void testTasksServiceExport000() throws IOException {
        String actual = tasksService.getCoupeCarTasksOrderByPrice();

        String expected = "Car Mercedes-Benz S-Class with 153376km\n" +
                "-Mechanic: Lorna Rann - task №206:\n" +
                " --Engine: 1.4\n" +
                "---Price: 1694.59$\n" +
                "Car Toyota Camry with 319292km\n" +
                "-Mechanic: Lothaire Myring - task №235:\n" +
                " --Engine: 2.4\n" +
                "---Price: 1662.59$\n" +
                "Car Mercedes-Benz SL-Class with 86912km\n" +
                "-Mechanic: Rubi Rostron - task №177:\n" +
                " --Engine: 2.5\n" +
                "---Price: 1640.75$\n" +
                "Car Mercedes-Benz SL-Class with 86912km\n" +
                "-Mechanic: Ashlie Penelli - task №29:\n" +
                " --Engine: 2.5\n" +
                "---Price: 1599.90$\n" +
                "Car Toyota Camry with 123980km\n" +
                "-Mechanic: Idalina Townrow - task №138:\n" +
                " --Engine: 2.4\n" +
                "---Price: 1594.36$\n" +
                "Car Cadillac Escalade with 332063km\n" +
                "-Mechanic: Flynn Whooley - task №297:\n" +
                " --Engine: 2.7\n" +
                "---Price: 1572.82$\n" +
                "Car Oldsmobile 88 with 235480km\n" +
                "-Mechanic: Gerladina Ledeker - task №27:\n" +
                " --Engine: 2.7\n" +
                "---Price: 1521.94$\n" +
                "Car Honda Civic with 314484km\n" +
                "-Mechanic: Cortney Graalman - task №202:\n" +
                " --Engine: 1.5\n" +
                "---Price: 1503.09$\n" +
                "Car Ford F250 with 245471km\n" +
                "-Mechanic: Fiorenze Caslake - task №300:\n" +
                " --Engine: 1.7\n" +
                "---Price: 1501.23$\n" +
                "Car Honda Civic with 314484km\n" +
                "-Mechanic: Allyn Crossdale - task №258:\n" +
                " --Engine: 1.5\n" +
                "---Price: 1475.98$\n" +
                "Car Dodge Intrepid with 339010km\n" +
                "-Mechanic: Ashlie Penelli - task №83:\n" +
                " --Engine: 1.1\n" +
                "---Price: 1446.70$\n" +
                "Car Mazda MPV with 139040km\n" +
                "-Mechanic: Kristoforo Nanson - task №164:\n" +
                " --Engine: 2.0\n" +
                "---Price: 1436.39$\n" +
                "Car Honda Civic with 314484km\n" +
                "-Mechanic: Cleve MacSorley - task №288:\n" +
                " --Engine: 1.5\n" +
                "---Price: 1434.54$\n" +
                "Car Mercedes-Benz S-Class with 153376km\n" +
                "-Mechanic: Flemming Spoerl - task №245:\n" +
                " --Engine: 1.4\n" +
                "---Price: 1426.07$\n" +
                "Car Chevrolet Metro with 61679km\n" +
                "-Mechanic: Sallyanne Coult - task №19:\n" +
                " --Engine: 2.6\n" +
                "---Price: 1424.28$\n" +
                "Car Pontiac Grand Prix with 260628km\n" +
                "-Mechanic: Sharron Pine - task №74:\n" +
                " --Engine: 2.4\n" +
                "---Price: 1414.99$\n" +
                "Car Honda Civic with 314484km\n" +
                "-Mechanic: Orsa Pavlovsky - task №222:\n" +
                " --Engine: 1.5\n" +
                "---Price: 1391.31$\n" +
                "Car BMW 545 with 197926km\n" +
                "-Mechanic: Fiorenze Caslake - task №105:\n" +
                " --Engine: 1.6\n" +
                "---Price: 1345.62$\n" +
                "Car Pontiac Torrent with 197012km\n" +
                "-Mechanic: Tanhya Mattimoe - task №186:\n" +
                " --Engine: 1.1\n" +
                "---Price: 1342.29$\n" +
                "Car Toyota Camry with 123980km\n" +
                "-Mechanic: Ozzie Earengey - task №2:\n" +
                " --Engine: 2.4\n" +
                "---Price: 1325.82$\n" +
                "Car BMW M3 with 249311km\n" +
                "-Mechanic: Justis Crystal - task №286:\n" +
                " --Engine: 2.7\n" +
                "---Price: 1302.01$\n" +
                "Car BMW M3 with 249311km\n" +
                "-Mechanic: Viva Clipston - task №98:\n" +
                " --Engine: 2.7\n" +
                "---Price: 1288.95$\n" +
                "Car Chevrolet HHR with 341940km\n" +
                "-Mechanic: Pia Smallwood - task №169:\n" +
                " --Engine: 2.4\n" +
                "---Price: 1267.66$\n" +
                "Car Mercury Monterey with 229310km\n" +
                "-Mechanic: Kristoforo Nanson - task №25:\n" +
                " --Engine: 1.8\n" +
                "---Price: 1266.29$\n" +
                "Car Pontiac Grand Prix with 260628km\n" +
                "-Mechanic: Flynn Whooley - task №41:\n" +
                " --Engine: 2.4\n" +
                "---Price: 1231.49$\n" +
                "Car Chevrolet Express with 248361km\n" +
                "-Mechanic: Don McNelly - task №39:\n" +
                " --Engine: 2.2\n" +
                "---Price: 1219.29$\n" +
                "Car Mercury Monterey with 229310km\n" +
                "-Mechanic: Marysa Pedri - task №234:\n" +
                " --Engine: 1.8\n" +
                "---Price: 1211.74$\n" +
                "Car Mazda Miata MX-5 with 267695km\n" +
                "-Mechanic: Flemming Spoerl - task №22:\n" +
                " --Engine: 2.1\n" +
                "---Price: 1211.58$\n" +
                "Car Mercedes-Benz S-Class with 153376km\n" +
                "-Mechanic: Miguela Ceccoli - task №244:\n" +
                " --Engine: 1.4\n" +
                "---Price: 1210.84$\n" +
                "Car Oldsmobile 88 with 235480km\n" +
                "-Mechanic: Krystal Sterland - task №150:\n" +
                " --Engine: 2.7\n" +
                "---Price: 1183.43$\n" +
                "Car Saab 900 with 265506km\n" +
                "-Mechanic: Raphaela Furminger - task №190:\n" +
                " --Engine: 1.4\n" +
                "---Price: 1176.79$\n" +
                "Car Chevrolet Metro with 61679km\n" +
                "-Mechanic: Tanhya Mattimoe - task №207:\n" +
                " --Engine: 2.6\n" +
                "---Price: 1174.43$\n" +
                "Car Cadillac Escalade with 332063km\n" +
                "-Mechanic: Bria Wickey - task №205:\n" +
                " --Engine: 2.7\n" +
                "---Price: 1156.38$\n" +
                "Car Dodge Intrepid with 339010km\n" +
                "-Mechanic: Lizbeth Glendenning - task №12:\n" +
                " --Engine: 1.1\n" +
                "---Price: 1144.42$\n" +
                "Car Dodge Intrepid with 339010km\n" +
                "-Mechanic: Mandel Burner - task №133:\n" +
                " --Engine: 1.1\n" +
                "---Price: 1116.77$\n" +
                "Car Ferrari 599 GTB Fiorano with 78182km\n" +
                "-Mechanic: Ursula Pinchin - task №40:\n" +
                " --Engine: 2.0\n" +
                "---Price: 1103.83$\n" +
                "Car Acura RL with 122702km\n" +
                "-Mechanic: Delcina Letchford - task №270:\n" +
                " --Engine: 3.0\n" +
                "---Price: 1061.01$\n" +
                "Car Oldsmobile 88 with 235480km\n" +
                "-Mechanic: Hatty Garr - task №213:\n" +
                " --Engine: 2.7\n" +
                "---Price: 1056.60$\n" +
                "Car Porsche Boxster with 186911km\n" +
                "-Mechanic: Nickie Murrhaupt - task №195:\n" +
                " --Engine: 2.1\n" +
                "---Price: 1055.51$\n" +
                "Car Mercury Monterey with 229310km\n" +
                "-Mechanic: Tanhya Mattimoe - task №48:\n" +
                " --Engine: 1.8\n" +
                "---Price: 1053.58$\n" +
                "Car Chevrolet Metro with 61679km\n" +
                "-Mechanic: Mandel Burner - task №224:\n" +
                " --Engine: 2.6\n" +
                "---Price: 1041.44$\n" +
                "Car Porsche Boxster with 186911km\n" +
                "-Mechanic: Gerladina Ledeker - task №161:\n" +
                " --Engine: 2.1\n" +
                "---Price: 1037.95$\n" +
                "Car Toyota Camry with 319292km\n" +
                "-Mechanic: Sandor Bewsy - task №81:\n" +
                " --Engine: 2.4\n" +
                "---Price: 1003.14$\n" +
                "Car Ford F250 with 245471km\n" +
                "-Mechanic: Dulcy Hebard - task №136:\n" +
                " --Engine: 1.7\n" +
                "---Price: 990.18$\n" +
                "Car Mercedes-Benz SL-Class with 86912km\n" +
                "-Mechanic: Cary Manicomb - task №141:\n" +
                " --Engine: 2.5\n" +
                "---Price: 987.28$\n" +
                "Car Toyota Camry with 319292km\n" +
                "-Mechanic: Averill Filkin - task №13:\n" +
                " --Engine: 2.4\n" +
                "---Price: 931.67$\n" +
                "Car Ford F250 with 245471km\n" +
                "-Mechanic: Thain Dupre - task №17:\n" +
                " --Engine: 1.7\n" +
                "---Price: 885.94$\n" +
                "Car Pontiac Grand Prix with 260628km\n" +
                "-Mechanic: Ursula Pinchin - task №228:\n" +
                " --Engine: 2.4\n" +
                "---Price: 882.38$\n" +
                "Car Cadillac Escalade with 332063km\n" +
                "-Mechanic: Ozzie Earengey - task №251:\n" +
                " --Engine: 2.7\n" +
                "---Price: 881.16$\n" +
                "Car Audi A8 with 345548km\n" +
                "-Mechanic: Fiorenze Caslake - task №92:\n" +
                " --Engine: 2.8\n" +
                "---Price: 878.29$\n" +
                "Car Jaguar XJ with 182327km\n" +
                "-Mechanic: Pia Smallwood - task №193:\n" +
                " --Engine: 1.6\n" +
                "---Price: 877.75$\n" +
                "Car Chevrolet HHR with 341940km\n" +
                "-Mechanic: Philly Lovstrom - task №154:\n" +
                " --Engine: 2.4\n" +
                "---Price: 843.76$\n" +
                "Car Volkswagen rio with 336105km\n" +
                "-Mechanic: Rozanna Garlette - task №16:\n" +
                " --Engine: 2.2\n" +
                "---Price: 820.21$\n" +
                "Car Mercury Monterey with 229310km\n" +
                "-Mechanic: Hew Tuther - task №216:\n" +
                " --Engine: 1.8\n" +
                "---Price: 751.97$\n" +
                "Car Pontiac Torrent with 197012km\n" +
                "-Mechanic: Delcina Letchford - task №215:\n" +
                " --Engine: 1.1\n" +
                "---Price: 726.94$\n" +
                "Car Mazda Miata MX-5 with 267695km\n" +
                "-Mechanic: Mandel Burner - task №5:\n" +
                " --Engine: 2.1\n" +
                "---Price: 705.94$\n" +
                "Car BMW M3 with 249311km\n" +
                "-Mechanic: Sharron Pine - task №183:\n" +
                " --Engine: 2.7\n" +
                "---Price: 643.45$\n" +
                "Car Pontiac 1000 with 292464km\n" +
                "-Mechanic: Lonnie Magenny - task №153:\n" +
                " --Engine: 1.6\n" +
                "---Price: 633.77$\n" +
                "Car Ford F250 with 245471km\n" +
                "-Mechanic: Bria Wickey - task №116:\n" +
                " --Engine: 1.7\n" +
                "---Price: 633.10$\n" +
                "Car BMW M3 with 249311km\n" +
                "-Mechanic: Alexei Ashwin - task №203:\n" +
                " --Engine: 2.7\n" +
                "---Price: 625.35$\n" +
                "Car Toyota Camry with 319292km\n" +
                "-Mechanic: Kristoforo Nanson - task №107:\n" +
                " --Engine: 2.4\n" +
                "---Price: 619.37$\n" +
                "Car Mercedes-Benz S-Class with 153376km\n" +
                "-Mechanic: Alexina Wickes - task №264:\n" +
                " --Engine: 1.4\n" +
                "---Price: 610.00$\n" +
                "Car Ford Contour with 275850km\n" +
                "-Mechanic: Sharron Pine - task №253:\n" +
                " --Engine: 2.0\n" +
                "---Price: 604.88$\n" +
                "Car Volkswagen rio with 336105km\n" +
                "-Mechanic: Allyn Crossdale - task №106:\n" +
                " --Engine: 2.2\n" +
                "---Price: 603.71$\n" +
                "Car Chevrolet Express with 248361km\n" +
                "-Mechanic: Ximenez Kunrad - task №152:\n" +
                " --Engine: 2.2\n" +
                "---Price: 566.83$\n" +
                "Car Toyota Tacoma with 103752km\n" +
                "-Mechanic: Fiorenze Caslake - task №149:\n" +
                " --Engine: 2.8\n" +
                "---Price: 544.05$\n" +
                "Car Nissan Quest with 283813km\n" +
                "-Mechanic: Maritsa Krug - task №209:\n" +
                " --Engine: 2.7\n" +
                "---Price: 512.93$\n" +
                "Car Oldsmobile 88 with 235480km\n" +
                "-Mechanic: Roseline Limon - task №90:\n" +
                " --Engine: 2.7\n" +
                "---Price: 503.83$\n" +
                "Car Nissan Quest with 283813km\n" +
                "-Mechanic: Maritsa Krug - task №237:\n" +
                " --Engine: 2.7\n" +
                "---Price: 488.78$\n" +
                "Car BMW 545 with 197926km\n" +
                "-Mechanic: Modesta Beamont - task №68:\n" +
                " --Engine: 1.6\n" +
                "---Price: 451.35$\n" +
                "Car Mazda MPV with 139040km\n" +
                "-Mechanic: Christie MacPike - task №221:\n" +
                " --Engine: 2.0\n" +
                "---Price: 450.78$\n" +
                "Car Ferrari 599 GTB Fiorano with 78182km\n" +
                "-Mechanic: Idalina Townrow - task №36:\n" +
                " --Engine: 2.0\n" +
                "---Price: 425.25$\n" +
                "Car Jaguar XJ with 182327km\n" +
                "-Mechanic: Lothaire Myring - task №252:\n" +
                " --Engine: 1.6\n" +
                "---Price: 424.30$\n" +
                "Car Mercedes-Benz S-Class with 153376km\n" +
                "-Mechanic: Fiorenze Caslake - task №292:\n" +
                " --Engine: 1.4\n" +
                "---Price: 419.12$\n" +
                "Car Chevrolet HHR with 341940km\n" +
                "-Mechanic: Raphaela Furminger - task №91:\n" +
                " --Engine: 2.4\n" +
                "---Price: 415.89$\n" +
                "Car Mercedes-Benz SL-Class with 86912km\n" +
                "-Mechanic: Ebonee Selwin - task №100:\n" +
                " --Engine: 2.5\n" +
                "---Price: 404.12$\n" +
                "Car Mercedes-Benz S-Class with 153376km\n" +
                "-Mechanic: Devin Hause - task №218:\n" +
                " --Engine: 1.4\n" +
                "---Price: 390.85$\n" +
                "Car Ford F250 with 245471km\n" +
                "-Mechanic: Averill Filkin - task №194:\n" +
                " --Engine: 1.7\n" +
                "---Price: 375.36$\n" +
                "Car Toyota Camry with 123980km\n" +
                "-Mechanic: Laurens Armatidge - task №199:\n" +
                " --Engine: 2.4\n" +
                "---Price: 340.73$\n" +
                "Car Ford F250 with 245471km\n" +
                "-Mechanic: Rozanna Garlette - task №108:\n" +
                " --Engine: 1.7\n" +
                "---Price: 335.14$\n" +
                "Car BMW M3 with 249311km\n" +
                "-Mechanic: Flynn Whooley - task №79:\n" +
                " --Engine: 2.7\n" +
                "---Price: 332.94$\n" +
                "Car Cadillac Escalade with 332063km\n" +
                "-Mechanic: Lonnie Magenny - task №163:\n" +
                " --Engine: 2.7\n" +
                "---Price: 316.94$\n" +
                "Car Acura RL with 122702km\n" +
                "-Mechanic: Justis Crystal - task №283:\n" +
                " --Engine: 3.0\n" +
                "---Price: 314.61$\n" +
                "Car Mercedes-Benz S-Class with 153376km\n" +
                "-Mechanic: Sallyanne Coult - task №89:\n" +
                " --Engine: 1.4\n" +
                "---Price: 283.38$\n" +
                "Car Nissan Quest with 283813km\n" +
                "-Mechanic: Delcina Letchford - task №119:\n" +
                " --Engine: 2.7\n" +
                "---Price: 265.47$\n" +
                "Car Volkswagen rio with 336105km\n" +
                "-Mechanic: Sandor Bewsy - task №290:\n" +
                " --Engine: 2.2\n" +
                "---Price: 256.26$\n" +
                "Car Pontiac Torrent with 197012km\n" +
                "-Mechanic: Madelaine Leger - task №49:\n" +
                " --Engine: 1.1\n" +
                "---Price: 249.25$\n" +
                "Car Toyota Camry with 123980km\n" +
                "-Mechanic: Don McNelly - task №123:\n" +
                " --Engine: 2.4\n" +
                "---Price: 243.40$\n" +
                "Car Honda Civic with 314484km\n" +
                "-Mechanic: Raphaela Furminger - task №42:\n" +
                " --Engine: 1.5\n" +
                "---Price: 219.43$\n" +
                "Car Acura RL with 122702km\n" +
                "-Mechanic: Abbye Budibent - task №159:\n" +
                " --Engine: 3.0\n" +
                "---Price: 179.50$\n" +
                "Car Oldsmobile 88 with 235480km\n" +
                "-Mechanic: Sallyanne Coult - task №76:\n" +
                " --Engine: 2.7\n" +
                "---Price: 157.82$\n" +
                "Car Porsche Boxster with 186911km\n" +
                "-Mechanic: Hew Tuther - task №124:\n" +
                " --Engine: 2.1\n" +
                "---Price: 149.04$\n" +
                "Car BMW 545 with 197926km\n" +
                "-Mechanic: Koenraad Pauler - task №178:\n" +
                " --Engine: 1.6\n" +
                "---Price: 136.07$\n" +
                "Car Oldsmobile 88 with 235480km\n" +
                "-Mechanic: Jephthah Belchem - task №26:\n" +
                " --Engine: 2.7\n" +
                "---Price: 108.48$\n" +
                "Car Volkswagen rio with 336105km\n" +
                "-Mechanic: Paddie Stute - task №126:\n" +
                " --Engine: 2.2\n" +
                "---Price: 107.47$\n" +
                "Car Mazda MPV with 139040km\n" +
                "-Mechanic: Osbourne Stonman - task №176:\n" +
                " --Engine: 2.0\n" +
                "---Price: 105.47$\n" +
                "Car BMW 545 with 197926km\n" +
                "-Mechanic: Giacobo Willment - task №219:\n" +
                " --Engine: 1.6\n" +
                "---Price: 103.17$\n" +
                "Car Toyota Camry with 319292km\n" +
                "-Mechanic: Marsha Redman - task №276:\n" +
                " --Engine: 2.4\n" +
                "---Price: 88.89$\n" +
                "Car Acura RL with 122702km\n" +
                "-Mechanic: Cleve MacSorley - task №86:\n" +
                " --Engine: 3.0\n" +
                "---Price: 82.77$\n" +
                "Car Chevrolet HHR with 341940km\n" +
                "-Mechanic: Esdras Yaxley - task №261:\n" +
                " --Engine: 2.4\n" +
                "---Price: 43.44$\n";

        String[] actualSplit = actual.split("\\r\\n?|\\n");
        String[] expectedSplit = expected.split("\\r\\n?|\\n");

        Assertions.assertArrayEquals(expectedSplit,actualSplit);
    }

}
