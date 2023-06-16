package jdbc.DatabaseAppsIntroductionExsercse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class Tasks {
    private static final String connectionPath = "jdbc:mysql://localhost:3306/minions_db";
    private static final Properties properties = new Properties();
    private static BufferedReader reader = null;
    private static Connection connection;
    private static PreparedStatement preparedStatement;

    //TODO Don't forget to remove password;
    public static void main(String[] args) throws IOException, SQLException {

        connection = getConnection();

        System.out.println("!!! For exit the program write \"end\"!!!");
        String task = "";

        while (!task.equals("end")) {
            System.out.println("Choose task from 2 to 9: ");
            task = reader.readLine();
            int id ;

            switch (task) {
                case "2" -> getVillainsNames();
                case "3" -> {
                    System.out.println("Choose villain id:");
                    id = Integer.parseInt(reader.readLine());
                    getMinionNames(id);
                }
                case "4" -> {
                    System.out.println("Input:");
                    String minion = reader.readLine().split(": ")[1];
                    String villain = reader.readLine().split(": ")[1];
                    addMinion(minion, villain);
                }
                case "5" -> {
                    System.out.println("Enter country name: ");
                    String country = reader.readLine();
                    changeTownNamesCasing(country);
                }
                case "6" -> {
                    System.out.println("Enter villain ID: ");
                    id = Integer.parseInt(reader.readLine());
                    removeVillain(id);
                }
                case "7" -> printAllMinionNames();
                case "8" -> increaseMinionsAge();
                case "9" -> {
                    /*  USE `minions_db`;
                        DROP procedure IF EXISTS `usp_get_older`;

                        DELIMITER $$
                        USE `minions_db`$$
                        CREATE PROCEDURE `usp_get_older` (`minion_id` INT)
                        BEGIN
                        UPDATE minions SET age=age+1  WHERE id=minion_id;
                        END$$

                        DELIMITER ;*/
                    //TODO Don't forget to create stored procedure first
                    System.out.println("Enter minion ID: ");
                    id = Integer.parseInt(reader.readLine());
                    increaseAgeByStoredProcedure(id);
                }
                default -> {
                    if (!task.equals("end") && !task.equals("")) {
                        System.out.println("No such task");
                    }
                }
            }

        }
        connection.close();

    }

    private static void increaseAgeByStoredProcedure(int id) throws SQLException {
        CallableStatement callableStatement = connection.prepareCall("CALL usp_get_older(?) ");
        callableStatement.setInt(1, id);
        callableStatement.execute();
        preparedStatement = connection.prepareStatement("SELECT name,age FROM minions WHERE id=?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            System.out.println(resultSet.getString(1) + " " + resultSet.getInt(2));
        }


    }

    private static void increaseMinionsAge() throws IOException, SQLException {
        System.out.println("Input:");
        int[] minionsIds = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        preparedStatement = connection.prepareStatement("UPDATE minions SET age=age+1, name=LOWER(name)  WHERE id=?;");
        for (int minionsId : minionsIds) {
            preparedStatement.setInt(1, minionsId);
            preparedStatement.execute();
        }
        preparedStatement = connection.prepareStatement("SELECT * FROM minions");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString(2) + " " + resultSet.getInt(3));
        }

    }

    private static void printAllMinionNames() throws SQLException {
        preparedStatement = connection.prepareStatement("SELECT name FROM minions");
        ResultSet rs = preparedStatement.executeQuery();
        List<String> minions = new ArrayList<>();

        while (rs.next()) {
            minions.add(rs.getString(1));
        }

        int start = 0;
        int end = minions.size() - 1;

        for (int i = 0; i < minions.size(); i++) {
            System.out.println(i % 2 == 0
                    ? minions.get(start++)
                    : minions.get(end--)
            );

        }

    }

    private static void removeVillain(int villainId) throws SQLException {
        String villainName = getEntityNameById("villains", villainId);
        if (villainName.equals("")) {
            System.out.println("No such villain was found");
            return;

        }

        System.out.printf("%s was deleted%n", villainName);
        preparedStatement = connection.prepareStatement("DELETE FROM minions_villains WHERE villain_id=?");
        preparedStatement.setInt(1, villainId);
        int affectedRows = preparedStatement.executeUpdate();
        preparedStatement = connection.prepareStatement("DELETE FROM villains WHERE id=?");
        preparedStatement.setInt(1, villainId);
        preparedStatement.execute();
        System.out.printf("%d minions released%n", affectedRows);

    }

    private static void changeTownNamesCasing(String country) throws SQLException {
        preparedStatement = connection.prepareStatement("Update towns SET  name=UPPER(name) WHERE country=?");
        preparedStatement.setString(1, country);
        int affectedRows = preparedStatement.executeUpdate();

        if (affectedRows == 0) {
            System.out.println("No town names were affected.");
            return;
        }
        System.out.printf("%d town names were affected.%n", affectedRows);
        preparedStatement = connection.prepareStatement("SELECT name FROM towns WHERE country=?");
        preparedStatement.setString(1, country);
        ResultSet rs = preparedStatement.executeQuery();
        String[] result = new String[affectedRows];
        int i = 0;

        while (rs.next()) {
            result[i++] = rs.getString(1);
        }
        System.out.println(Arrays.toString(result));
    }

    private static void addMinion(String minion, String villain) throws SQLException {
        String townName = minion.split(" ")[2];
        String minionName = minion.split(" ")[0];
        Integer minionAge = Integer.parseInt(minion.split(" ")[1]);
        Integer minionId = getEntityIdByName("towns", minionName);
        Integer townId = getEntityIdByName("towns", townName);
        Integer villainId = getEntityIdByName("villains", villain);
        if (townId < 0) {
            String query = String.format("INSERT INTO towns (`name`)  VALUES (\"%s\");", townName);
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
            System.out.printf("Town %s was added to the database.%n", townName);
            townId = getEntityIdByName("towns", townName);
        }
        if (villainId < 0) {
            String query = String.format("INSERT INTO villains (`name`,`evilness_factor`)  VALUES (\"%s\",\"evil\");", villain);
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
            System.out.printf("Villain %s was added to the database.%n", villain);
            villainId = getEntityIdByName("villains", villain);
        }
        if (minionId < 0) {
            String query = String.format("INSERT INTO minions (`name`,`age`,`town_id`)  VALUES (\"%s\",\"%d\",\"%s\");", minionName, minionAge, townId);
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
            minionId = getEntityIdByName("minions", minionName);
        }
        String query = String.format("INSERT INTO minions_villains   VALUES (\"%d\",\"%d\");", minionId, villainId);
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.execute();

        System.out.printf("Successfully added %s to be minion of %s.%n", minionName, villain);

    }

    private static Connection getConnection() throws IOException, SQLException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Username: ");
        String username = reader.readLine();
        username = username.equals("") ? "root" : username;
        properties.setProperty("user", username);
        System.out.print("Password: ");
        String password = reader.readLine();
        password = password.equals("") ? "password" : password;
        properties.setProperty("password", password);

        connection = DriverManager.getConnection(connectionPath, properties);
        return connection;
    }

    private static String getEntityNameById(String tableName, Integer id) throws SQLException {
        String query = String.format("SELECT name FROM %s where id=?;", tableName);
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
            return rs.getString(1);
        } else {
            return "";
        }
    }

    private static Integer getEntityIdByName(String tableName, String name) throws SQLException {
        String query = String.format("SELECT id FROM %s where name=?;", tableName);
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, name);
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
            return rs.getInt(1);
        } else {
            return -1;
        }
    }

    private static void getMinionNames(int villainId) throws SQLException {
        preparedStatement = connection.prepareStatement("SELECT v.name, m.name,m.age FROM minions_villains JOIN minions m on m.id = minions_villains.minion_id JOIN villains v on v.id = minions_villains.villain_id WHERE villain_id=?;");
        preparedStatement.setInt(1, villainId);
        ResultSet rs = preparedStatement.executeQuery();
        System.out.printf("Villain: %s%n", getEntityNameById("villains", villainId));

        if (rs.isBeforeFirst()) {
            while (rs.next()) {
                System.out.printf("%d. %s %d%n", rs.getRow(), rs.getString(2), rs.getInt(3));
            }
        } else {
            System.out.printf("No villain with ID %d exists in the database.%n", villainId);
        }

    }

    private static void getVillainsNames() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT v.name, count(DISTINCT mv.minion_id) as countOfMinons FROM villains as v JOIN minions_villains mv on v.id = mv.villain_id GROUP BY name HAVING countOfMinons>15 ORDER BY countOfMinons DESC ;");

        while (resultSet.next()) {
            System.out.println(resultSet.getString(1) + " " + resultSet.getInt(2));
        }
    }
}
