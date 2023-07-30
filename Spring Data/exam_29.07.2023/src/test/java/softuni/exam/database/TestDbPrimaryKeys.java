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

        ResultSet primaryKeyAstronomers = metaData.getPrimaryKeys(null, null, "ASTRONOMERS");
        ResultSet primaryKeyConstellations = metaData.getPrimaryKeys(null, null, "CONSTELLATIONS");
        ResultSet primaryKeyStars = metaData.getPrimaryKeys(null, null, "STARS");

        List<String> actualResult = new ArrayList<>();

        primaryKeyAstronomers.next();
        actualResult.add(primaryKeyAstronomers.getString("TABLE_NAME"));
        actualResult.add(primaryKeyAstronomers.getString("COLUMN_NAME"));

        primaryKeyConstellations.next();
        actualResult.add(primaryKeyConstellations.getString("TABLE_NAME"));
        actualResult.add(primaryKeyConstellations.getString("COLUMN_NAME"));

        primaryKeyStars.next();
        actualResult.add(primaryKeyStars.getString("TABLE_NAME"));
        actualResult.add(primaryKeyStars.getString("COLUMN_NAME"));

        List<String> expectedResult = new ArrayList<>();

        expectedResult.add("ASTRONOMERS");
        expectedResult.add("ID");
        expectedResult.add("CONSTELLATIONS");
        expectedResult.add("ID");
        expectedResult.add("STARS");
        expectedResult.add("ID");

        Assertions.assertArrayEquals(expectedResult.stream().sorted().toArray(), actualResult.stream().sorted().toArray());
    }

    private DatabaseMetaData getDatabaseMetaData() throws SQLException {
        DataSource dataSource = getJdbcTemplate().getDataSource();
        Connection connection = DataSourceUtils.getConnection(dataSource);
        return connection.getMetaData();
    }
}