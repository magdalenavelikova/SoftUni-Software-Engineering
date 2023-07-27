package softuni.exam.database;
//TestDbCarsTable
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
public class TestDbTasksTable {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Test
    void testDbTasksTable() throws SQLException {
        DatabaseMetaData metaData = getDatabaseMetaData();

        StringBuilder actualSB = new StringBuilder();

        ResultSet columns = metaData.getColumns(null, "PUBLIC", "TASKS", null);

        while (columns.next()) {
            actualSB.append(String.format("%s,%s,%s,%s,%s",
                    columns.getString("COLUMN_NAME"),
                    columns.getString("TYPE_NAME"),
                    columns.getString("NULLABLE"),
                    columns.getString("BUFFER_LENGTH"),
                    columns.getString("COLUMN_SIZE")
            )).append("\n");
        }

        String expected = "ID,BIGINT,0,19,19\n" +
                "DATE,TIMESTAMP,0,26,26\n" +
                "PRICE,DECIMAL,0,19,19\n" +
                "CARS_ID,BIGINT,1,19,19\n" +
                "MECHANIC_ID,BIGINT,1,19,19\n" +
                "PARTS_ID,BIGINT,1,19,19";

        Assertions.assertEquals(expected, actualSB.toString().trim());

    }

    private DatabaseMetaData getDatabaseMetaData() throws SQLException {
        DataSource dataSource = getJdbcTemplate().getDataSource();
        Connection connection = DataSourceUtils.getConnection(dataSource);
        return connection.getMetaData();
    }
}