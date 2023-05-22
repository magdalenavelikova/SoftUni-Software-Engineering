package jdbc.DatabaseAppsIntroductionLab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Properties;

public class Task2 {
    private static final String connectionInfo = "jdbc:mysql://localhost:3306/diablo";
    private static final Properties properties = new Properties();

    public static void main(String[] args) throws SQLException, IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter username: ");
        String user = bufferedReader.readLine();
        System.out.println("Enter password: ");
        String password = bufferedReader.readLine();
        properties.setProperty("user", user);
        properties.setProperty("password", password);

        Connection connection = DriverManager.getConnection(connectionInfo, properties);

        PreparedStatement preparedStatement = connection.prepareStatement("SELECT u.user_name,u.first_name,u.last_name,count(distinct ug.game_id) as count FROM  users as u JOIN `users_games` as ug ON u.id=ug.user_id WHERE user_name=? group by ug.user_id;");

        System.out.println("Enter username: ");
        String gameUser = bufferedReader.readLine();

        preparedStatement.setString(1, gameUser);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            System.out.println("User: " + resultSet.getString("user_name"));
            System.out.printf("%s %s has played %d games%n", resultSet.getString("first_name"), resultSet.getString("last_name"), resultSet.getInt("count")

            );
        } else {
            System.out.println("No such user exists");
        }
        connection.close();

    }
}
