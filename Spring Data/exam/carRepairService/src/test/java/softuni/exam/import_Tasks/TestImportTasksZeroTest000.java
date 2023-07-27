package softuni.exam.import_Tasks;
//TestImportTasksZeroTest000

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import softuni.exam.service.TasksService;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class TestImportTasksZeroTest000 {

    @Autowired
    private TasksService tasksService;

    @Sql("/import-tasks-000.sql")
    @Test
    void testImportTasksZeroTest000() throws IOException, JAXBException {
        String expected = "Invalid task\n" +
                "Successfully imported task 240.04\n" +
                "Successfully imported task 1325.82\n" +
                "Successfully imported task 1033.98\n" +
                "Successfully imported task 1230.28\n" +
                "Invalid task\n" +
                "Successfully imported task 705.94\n" +
                "Successfully imported task 969.34\n" +
                "Successfully imported task 280.38\n" +
                "Successfully imported task 537.83\n" +
                "Successfully imported task 755.42\n" +
                "Successfully imported task 1046.05\n" +
                "Successfully imported task 876.56\n" +
                "Successfully imported task 1144.42\n" +
                "Successfully imported task 931.67\n" +
                "Successfully imported task 221.43\n" +
                "Successfully imported task 515.78\n" +
                "Successfully imported task 820.21\n" +
                "Successfully imported task 885.94\n" +
                "Successfully imported task 368.12\n" +
                "Successfully imported task 1424.28\n" +
                "Successfully imported task 1317.13\n" +
                "Successfully imported task 330.49\n" +
                "Successfully imported task 1211.58\n" +
                "Successfully imported task 431.82\n" +
                "Successfully imported task 1688.43\n" +
                "Successfully imported task 1266.29\n" +
                "Successfully imported task 108.48\n" +
                "Successfully imported task 1521.94\n" +
                "Successfully imported task 1111.56\n" +
                "Successfully imported task 1599.90\n" +
                "Successfully imported task 1516.61\n" +
                "Successfully imported task 846.40\n" +
                "Successfully imported task 256.68\n" +
                "Successfully imported task 254.97\n" +
                "Successfully imported task 427.87\n" +
                "Successfully imported task 1217.80\n" +
                "Successfully imported task 425.25\n" +
                "Successfully imported task 405.74\n" +
                "Successfully imported task 1397.66\n" +
                "Successfully imported task 1219.29\n" +
                "Successfully imported task 1103.83\n" +
                "Successfully imported task 1231.49\n" +
                "Successfully imported task 219.43\n" +
                "Successfully imported task 383.66\n" +
                "Successfully imported task 532.12\n" +
                "Successfully imported task 1262.46\n" +
                "Successfully imported task 859.04\n" +
                "Successfully imported task 718.33\n" +
                "Successfully imported task 1053.58\n" +
                "Successfully imported task 249.25\n" +
                "Successfully imported task 877.57\n" +
                "Successfully imported task 1491.68\n" +
                "Successfully imported task 1509.85\n" +
                "Successfully imported task 764.74\n" +
                "Successfully imported task 1563.12\n" +
                "Successfully imported task 1470.81\n" +
                "Successfully imported task 881.44\n" +
                "Successfully imported task 1435.30\n" +
                "Successfully imported task 1031.75\n" +
                "Successfully imported task 410.09\n" +
                "Successfully imported task 731.81\n" +
                "Successfully imported task 569.02\n" +
                "Successfully imported task 1358.85\n" +
                "Successfully imported task 811.93\n" +
                "Successfully imported task 1588.60\n" +
                "Successfully imported task 1272.91\n" +
                "Successfully imported task 683.08\n" +
                "Successfully imported task 1543.49\n" +
                "Successfully imported task 451.35\n" +
                "Successfully imported task 1486.11\n" +
                "Successfully imported task 1688.24\n" +
                "Successfully imported task 843.44\n" +
                "Successfully imported task 1651.11\n" +
                "Successfully imported task 931.60\n" +
                "Successfully imported task 1414.99\n" +
                "Successfully imported task 163.95\n" +
                "Successfully imported task 157.82\n" +
                "Successfully imported task 73.31\n" +
                "Successfully imported task 1455.98\n" +
                "Successfully imported task 332.94\n" +
                "Successfully imported task 1257.39\n" +
                "Successfully imported task 1003.14\n" +
                "Successfully imported task 1329.86\n" +
                "Successfully imported task 1446.70\n" +
                "Successfully imported task 347.19\n" +
                "Successfully imported task 203.45\n" +
                "Successfully imported task 82.77\n" +
                "Successfully imported task 669.48\n" +
                "Successfully imported task 113.09\n" +
                "Successfully imported task 283.38\n" +
                "Successfully imported task 503.83\n" +
                "Successfully imported task 415.89\n" +
                "Successfully imported task 878.29\n" +
                "Successfully imported task 1166.22\n" +
                "Successfully imported task 878.78\n" +
                "Successfully imported task 235.42\n" +
                "Successfully imported task 646.92\n" +
                "Successfully imported task 1377.06\n" +
                "Successfully imported task 1288.95\n" +
                "Successfully imported task 386.74\n" +
                "Successfully imported task 404.12\n" +
                "Successfully imported task 1611.69\n" +
                "Successfully imported task 1568.23\n" +
                "Successfully imported task 1353.01\n" +
                "Successfully imported task 236.61\n" +
                "Successfully imported task 1345.62\n" +
                "Successfully imported task 603.71\n" +
                "Successfully imported task 619.37\n" +
                "Successfully imported task 335.14\n" +
                "Successfully imported task 1247.45\n" +
                "Successfully imported task 1359.88\n" +
                "Successfully imported task 752.14\n" +
                "Successfully imported task 336.62\n" +
                "Successfully imported task 993.11\n" +
                "Successfully imported task 1408.22\n" +
                "Successfully imported task 510.02\n" +
                "Successfully imported task 633.10\n" +
                "Successfully imported task 565.32\n" +
                "Successfully imported task 1491.80\n" +
                "Successfully imported task 265.47\n" +
                "Successfully imported task 1214.36\n" +
                "Successfully imported task 703.23\n" +
                "Successfully imported task 675.19\n" +
                "Successfully imported task 243.40\n" +
                "Successfully imported task 149.04\n" +
                "Successfully imported task 449.85\n" +
                "Successfully imported task 107.47\n" +
                "Successfully imported task 770.46\n" +
                "Successfully imported task 883.65\n" +
                "Successfully imported task 1661.91\n" +
                "Successfully imported task 1512.62\n" +
                "Successfully imported task 853.91\n" +
                "Successfully imported task 923.29\n" +
                "Successfully imported task 1116.77\n" +
                "Successfully imported task 275.95\n" +
                "Successfully imported task 1572.55\n" +
                "Successfully imported task 990.18\n" +
                "Successfully imported task 43.68\n" +
                "Successfully imported task 1594.36\n" +
                "Successfully imported task 926.93\n" +
                "Successfully imported task 881.94\n" +
                "Successfully imported task 987.28\n" +
                "Successfully imported task 863.06\n" +
                "Successfully imported task 1396.82\n" +
                "Successfully imported task 343.96\n" +
                "Successfully imported task 1213.46\n" +
                "Successfully imported task 1617.75\n" +
                "Successfully imported task 1181.90\n" +
                "Successfully imported task 1346.20\n" +
                "Successfully imported task 544.05\n" +
                "Successfully imported task 1183.43\n" +
                "Successfully imported task 649.39\n" +
                "Successfully imported task 566.83\n" +
                "Successfully imported task 633.77\n" +
                "Successfully imported task 843.76\n" +
                "Successfully imported task 1052.83\n" +
                "Successfully imported task 1538.82\n" +
                "Successfully imported task 239.43\n" +
                "Successfully imported task 1204.71\n" +
                "Successfully imported task 179.50\n" +
                "Successfully imported task 932.43\n" +
                "Successfully imported task 1037.95\n" +
                "Successfully imported task 840.89\n" +
                "Successfully imported task 316.94\n" +
                "Successfully imported task 1436.39\n" +
                "Successfully imported task 1279.19\n" +
                "Successfully imported task 906.01\n" +
                "Successfully imported task 1588.73\n" +
                "Successfully imported task 195.55\n" +
                "Successfully imported task 1267.66\n" +
                "Successfully imported task 388.01\n" +
                "Successfully imported task 365.34\n" +
                "Successfully imported task 357.35\n" +
                "Successfully imported task 163.30\n" +
                "Successfully imported task 188.55\n" +
                "Successfully imported task 981.49\n" +
                "Successfully imported task 105.47\n" +
                "Successfully imported task 1640.75\n" +
                "Successfully imported task 136.07\n" +
                "Successfully imported task 1123.98\n" +
                "Successfully imported task 1002.09\n" +
                "Successfully imported task 1509.50\n" +
                "Successfully imported task 134.79\n" +
                "Successfully imported task 643.45\n" +
                "Successfully imported task 1641.28\n" +
                "Successfully imported task 813.33\n" +
                "Successfully imported task 1342.29\n" +
                "Successfully imported task 1579.04\n" +
                "Successfully imported task 60.03\n" +
                "Successfully imported task 632.54\n" +
                "Successfully imported task 1176.79\n" +
                "Successfully imported task 331.53\n" +
                "Successfully imported task 1561.50\n" +
                "Successfully imported task 877.75\n" +
                "Successfully imported task 375.36\n" +
                "Successfully imported task 1055.51\n" +
                "Successfully imported task 1424.48\n" +
                "Successfully imported task 250.28\n" +
                "Successfully imported task 933.83\n" +
                "Successfully imported task 340.73\n" +
                "Successfully imported task 228.50\n" +
                "Successfully imported task 819.41\n" +
                "Successfully imported task 1503.09\n" +
                "Successfully imported task 625.35\n" +
                "Successfully imported task 233.26\n" +
                "Successfully imported task 1156.38\n" +
                "Successfully imported task 1694.59\n" +
                "Successfully imported task 1174.43\n" +
                "Successfully imported task 999.65\n" +
                "Successfully imported task 512.93\n" +
                "Successfully imported task 674.09\n" +
                "Successfully imported task 1155.33\n" +
                "Successfully imported task 1089.51\n" +
                "Successfully imported task 1056.60\n" +
                "Successfully imported task 611.21\n" +
                "Successfully imported task 726.94\n" +
                "Successfully imported task 751.97\n" +
                "Successfully imported task 1691.29\n" +
                "Successfully imported task 390.85\n" +
                "Successfully imported task 103.17\n" +
                "Successfully imported task 462.97\n" +
                "Successfully imported task 450.78\n" +
                "Successfully imported task 1391.31\n" +
                "Successfully imported task 1271.75\n" +
                "Successfully imported task 1041.44\n" +
                "Successfully imported task 266.82\n" +
                "Successfully imported task 1438.96\n" +
                "Successfully imported task 644.19\n" +
                "Successfully imported task 882.38\n" +
                "Successfully imported task 512.88\n" +
                "Successfully imported task 837.46\n" +
                "Successfully imported task 1533.08\n" +
                "Successfully imported task 1283.38\n" +
                "Successfully imported task 1045.96\n" +
                "Successfully imported task 1211.74\n" +
                "Successfully imported task 1662.59\n" +
                "Successfully imported task 763.46\n" +
                "Successfully imported task 488.78\n" +
                "Successfully imported task 495.03\n" +
                "Successfully imported task 647.31\n" +
                "Successfully imported task 1660.97\n" +
                "Successfully imported task 1334.91\n" +
                "Successfully imported task 1257.97\n" +
                "Successfully imported task 1611.90\n" +
                "Successfully imported task 1210.84\n" +
                "Successfully imported task 1426.07\n" +
                "Successfully imported task 1353.91\n" +
                "Successfully imported task 1642.68\n" +
                "Successfully imported task 715.60\n" +
                "Successfully imported task 970.82\n" +
                "Successfully imported task 1226.37\n" +
                "Successfully imported task 881.16\n" +
                "Successfully imported task 424.30\n" +
                "Successfully imported task 604.88\n" +
                "Successfully imported task 711.45\n" +
                "Successfully imported task 1059.97\n" +
                "Successfully imported task 730.63\n" +
                "Successfully imported task 1426.43\n" +
                "Successfully imported task 1475.98\n" +
                "Successfully imported task 804.42\n" +
                "Successfully imported task 898.27\n" +
                "Successfully imported task 43.44\n" +
                "Successfully imported task 1586.71\n" +
                "Successfully imported task 1619.29\n" +
                "Successfully imported task 610.00\n" +
                "Successfully imported task 1455.56\n" +
                "Successfully imported task 1590.18\n" +
                "Successfully imported task 956.55\n" +
                "Successfully imported task 1416.88\n" +
                "Successfully imported task 1617.66\n" +
                "Successfully imported task 1061.01\n" +
                "Successfully imported task 639.69\n" +
                "Successfully imported task 498.85\n" +
                "Successfully imported task 1077.69\n" +
                "Successfully imported task 318.89\n" +
                "Successfully imported task 349.72\n" +
                "Successfully imported task 88.89\n" +
                "Successfully imported task 1264.04\n" +
                "Successfully imported task 1627.84\n" +
                "Successfully imported task 262.68\n" +
                "Successfully imported task 265.33\n" +
                "Successfully imported task 371.21\n" +
                "Successfully imported task 742.76\n" +
                "Successfully imported task 314.61\n" +
                "Successfully imported task 1105.61\n" +
                "Successfully imported task 1396.82\n" +
                "Successfully imported task 1302.01\n" +
                "Successfully imported task 138.47\n" +
                "Successfully imported task 1434.54\n" +
                "Successfully imported task 1184.29\n" +
                "Successfully imported task 256.26\n" +
                "Successfully imported task 1202.59\n" +
                "Successfully imported task 419.12\n" +
                "Successfully imported task 1161.67\n" +
                "Successfully imported task 1562.87\n" +
                "Successfully imported task 375.69\n" +
                "Successfully imported task 691.29\n" +
                "Successfully imported task 1572.82\n" +
                "Successfully imported task 44.35\n" +
                "Successfully imported task 1464.86\n" +
                "Successfully imported task 1501.23";
        String[] expectedSplit = expected.split("\\r\\n?|\\n");

        String actual = tasksService.importTasks();
        String[] actualSplit = actual.split("\\r\\n?|\\n");

        Assertions.assertArrayEquals(expectedSplit, actualSplit);
    }
}

