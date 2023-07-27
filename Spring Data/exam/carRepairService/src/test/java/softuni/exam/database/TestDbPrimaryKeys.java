package softuni.exam.database;
//TestDbPrimaryKeys

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
public class TestDbPrimaryKeys {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }


    @Test
    void testPrimaryKeys() throws SQLException {
        DatabaseMetaData metaData = getDatabaseMetaData();

        ResultSet primaryKeyParts = metaData.getPrimaryKeys(null, null, "PARTS");
        ResultSet primaryKeyMechanics = metaData.getPrimaryKeys(null, null, "MECHANICS");
        ResultSet primaryKeyCars = metaData.getPrimaryKeys(null, null, "CARS");
        ResultSet primaryKeyTasks = metaData.getPrimaryKeys(null, null, "TASKS");

        List<String> actual = new ArrayList<>();

        primaryKeyParts.next();
        actual.add(primaryKeyParts.getString("TABLE_NAME"));
        actual.add(primaryKeyParts.getString("COLUMN_NAME"));

        primaryKeyMechanics.next();
        actual.add(primaryKeyMechanics.getString("TABLE_NAME"));
        actual.add(primaryKeyMechanics.getString("COLUMN_NAME"));

        primaryKeyCars.next();
        actual.add(primaryKeyCars.getString("TABLE_NAME"));
        actual.add(primaryKeyCars.getString("COLUMN_NAME"));


        primaryKeyTasks.next();
        actual.add(primaryKeyTasks.getString("TABLE_NAME"));
        actual.add(primaryKeyTasks.getString("COLUMN_NAME"));

        List<String> expected = new ArrayList<>();

        expected.add("PARTS");
        expected.add("ID");
        expected.add("MECHANICS");
        expected.add("ID");
        expected.add("CARS");
        expected.add("ID");
        expected.add("TASKS");
        expected.add("ID");

        Assertions.assertEquals(expected, actual);
    }

    private DatabaseMetaData getDatabaseMetaData() throws SQLException {
        DataSource dataSource = getJdbcTemplate().getDataSource();
        Connection connection = DataSourceUtils.getConnection(dataSource);
        return connection.getMetaData();
    }
}