package softuni.exam.database;
//TestDbForeignKeysAstronomers
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
public class TestDbForeignKeysAstronomers {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Test
    void testForeignKeysAstronomers() throws SQLException {
        DatabaseMetaData metaData = getDatabaseMetaData();

        ResultSet astronomersKeys = metaData.getImportedKeys(null, null, "ASTRONOMERS");
        ResultSet starsKeys = metaData.getImportedKeys(null, null, "STARS");

        List<String> actualResult = new ArrayList<>();

        astronomersKeys.next();
        actualResult.add(astronomersKeys.getString("PKTABLE_NAME"));
        actualResult.add(astronomersKeys.getString("FKTABLE_NAME"));
        actualResult.add(astronomersKeys.getString("PKCOLUMN_NAME"));
        actualResult.add(astronomersKeys.getString("FKCOLUMN_NAME"));

        starsKeys.next();
        actualResult.add(starsKeys.getString("PKTABLE_NAME"));
        actualResult.add(starsKeys.getString("FKTABLE_NAME"));
        actualResult.add(starsKeys.getString("PKCOLUMN_NAME"));
        actualResult.add(starsKeys.getString("FKCOLUMN_NAME"));

        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("STARS");
        expectedResult.add("ASTRONOMERS");
        expectedResult.add("ID");
        expectedResult.add("OBSERVING_STAR_ID");
        expectedResult.add("CONSTELLATIONS");
        expectedResult.add("STARS");
        expectedResult.add("ID");
        expectedResult.add("CONSTELLATION_ID");

        Assertions.assertArrayEquals(expectedResult.stream().sorted().toArray(), actualResult.stream().sorted().toArray());
    }

    private DatabaseMetaData getDatabaseMetaData() throws SQLException {
        DataSource dataSource = getJdbcTemplate().getDataSource();
        Connection connection = DataSourceUtils.getConnection(dataSource);
        return connection.getMetaData();
    }
}