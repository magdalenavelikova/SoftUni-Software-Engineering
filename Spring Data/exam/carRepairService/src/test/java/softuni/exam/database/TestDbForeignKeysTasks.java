package softuni.exam.database;
//TestDbForeignKeysTasks

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
import java.util.ArrayList;
import java.util.List;

@DataJpaTest
public class TestDbForeignKeysTasks {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Test
    void testForeignKeysTasks() throws SQLException {
        DatabaseMetaData metaData = getDatabaseMetaData();

        ResultSet tasksKeys = metaData.getImportedKeys(null, null, "TASKS");

        List<String> actual = new ArrayList<>();

        while (tasksKeys.next()) {
            actual.add(tasksKeys.getString("PKTABLE_NAME"));
            actual.add(tasksKeys.getString("FKTABLE_NAME"));
            actual.add(tasksKeys.getString("PKCOLUMN_NAME"));
            actual.add(tasksKeys.getString("FKCOLUMN_NAME"));
        }


        List<String> expected = new ArrayList<>();
        expected.add("CARS");
        expected.add("TASKS");
        expected.add("ID");
        expected.add("CARS_ID");
        expected.add("MECHANICS");
        expected.add("TASKS");
        expected.add("ID");
        expected.add("MECHANIC_ID");
        expected.add("PARTS");
        expected.add("TASKS");
        expected.add("ID");
        expected.add("PARTS_ID");

        Assertions.assertEquals(expected, actual);
    }

    private DatabaseMetaData getDatabaseMetaData() throws SQLException {
        DataSource dataSource = getJdbcTemplate().getDataSource();
        Connection connection = DataSourceUtils.getConnection(dataSource);
        return connection.getMetaData();
    }
}