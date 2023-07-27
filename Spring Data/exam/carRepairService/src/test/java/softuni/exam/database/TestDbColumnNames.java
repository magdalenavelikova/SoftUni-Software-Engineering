package softuni.exam.database;
//TestDbColumnNames
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

@DataJpaTest
public class TestDbColumnNames {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Test
    void columnsNames() throws SQLException {
        DatabaseMetaData metaData = getDatabaseMetaData();

        StringBuilder actualSB = new StringBuilder();

        ResultSet columns1 = metaData.getColumns(null, "PUBLIC", null, null);

        while (columns1.next()) {
            actualSB.append(String.format("%s", columns1.getString("COLUMN_NAME"))).append("\n");
        }

        String expected = "ID\n" +
                "CAR_MAKE\n" +
                "CAR_MODEL\n" +
                "CAR_TYPE\n" +
                "ENGINE\n" +
                "KILOMETERS\n" +
                "PLATE_NUMBER\n" +
                "YEAR\n" +
                "ID\n" +
                "EMAIL\n" +
                "FIRST_NAME\n" +
                "LAST_NAME\n" +
                "PHONE\n" +
                "ID\n" +
                "PART_NAME\n" +
                "PRICE\n" +
                "QUANTITY\n" +
                "ID\n" +
                "DATE\n" +
                "PRICE\n" +
                "CARS_ID\n" +
                "MECHANIC_ID\n" +
                "PARTS_ID";

        Assertions.assertEquals(expected, actualSB.toString().trim());
    }

    private DatabaseMetaData getDatabaseMetaData() throws SQLException {
        DataSource dataSource = getJdbcTemplate().getDataSource();
        Connection connection = DataSourceUtils.getConnection(dataSource);
        return connection.getMetaData();
    }
}