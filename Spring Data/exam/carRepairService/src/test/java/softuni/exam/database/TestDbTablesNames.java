package softuni.exam.database;
//TestDbTablesNames
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
public class TestDbTablesNames {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Test
    void tablesNames() throws SQLException {
        DatabaseMetaData metaData = getDatabaseMetaData();

        StringBuilder stringBuilder = new StringBuilder();

        ResultSet tables = metaData.getTables(null, "PUBLIC", null, null);

        while (tables.next()) {
            stringBuilder.append(String.format("%s", tables.getString("TABLE_NAME"))).append("\n");
        }

        String expected = "CARS\n" +
                "MECHANICS\n" +
                "PARTS\n" +
                "TASKS";

        System.out.println(stringBuilder.toString().trim());
        Assertions.assertEquals(expected, stringBuilder.toString().trim());
    }

    private DatabaseMetaData getDatabaseMetaData() throws SQLException {
        DataSource dataSource = getJdbcTemplate().getDataSource();
        Connection connection = DataSourceUtils.getConnection(dataSource);
        return connection.getMetaData();
    }
}