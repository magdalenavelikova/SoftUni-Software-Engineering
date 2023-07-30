package softuni.exam.database;
//TestDbStarsTable

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
public class TestDbStarsTable {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Test
    void testStarsTable() throws SQLException {
        DatabaseMetaData metaData = getDatabaseMetaData();

        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("ID,BIGINT,0,19,19");
        expectedResult.add("DESCRIPTION,CLOB,0,2147483647,2147483647");
        expectedResult.add("LIGHT_YEARS,DOUBLE,0,17,17");
        expectedResult.add("NAME,VARCHAR,0,255,255");
        expectedResult.add("STAR_TYPE,VARCHAR,0,255,255");
        expectedResult.add("CONSTELLATION_ID,BIGINT,1,19,19");

        ResultSet columns = metaData.getColumns(null, "PUBLIC", "STARS", null);

        final List<String> actualResult = new ArrayList<>();

        while (columns.next()) {
            actualResult.add(String.format("%s,%s,%s,%s,%s",
                    columns.getString("COLUMN_NAME"),
                    columns.getString("TYPE_NAME"),
                    columns.getString("NULLABLE"),
                    columns.getString("BUFFER_LENGTH"),
                    columns.getString("COLUMN_SIZE")
            ));
        }


        Assertions.assertArrayEquals(expectedResult.stream().sorted().toArray(), actualResult.stream().sorted().toArray());
    }


    private DatabaseMetaData getDatabaseMetaData() throws SQLException {
        DataSource dataSource = getJdbcTemplate().getDataSource();
        Connection connection = DataSourceUtils.getConnection(dataSource);
        return connection.getMetaData();
    }
}