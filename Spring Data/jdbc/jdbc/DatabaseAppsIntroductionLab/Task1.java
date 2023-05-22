package jdbc.DatabaseAppsIntroductionLab;

import java.sql.*;
import java.util.HashSet;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

public class Task1 {

    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter username default (root): ");
        String user = sc.nextLine();
        user = user.equals("") ? "root" : user;
        System.out.println();
        System.out.print("Enter password default (empty):");
        String password = sc.nextLine().trim();
        System.out.println();

        Properties props = new Properties();
        props.setProperty("user", user);
        props.setProperty("password", password);

        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/soft_uni", props);

        Statement infoSchema = connection.createStatement();
        ResultSet resultSet = infoSchema.executeQuery("SELECT * FROM information_schema.COLUMNS where TABLE_NAME='employees' and TABLE_SCHEMA= 'soft_uni';");
        PreparedStatement stmt =
                connection.prepareStatement("SELECT * FROM employees WHERE salary > ?");
        System.out.print("Enter salary: ");
        String salary = sc.nextLine();
        stmt.setDouble(1, Double.parseDouble(salary));
        ResultSet rs = stmt.executeQuery();
        Set<String> columnName = new HashSet<>();
        while (resultSet.next()) {
            columnName.add(resultSet.getString("COLUMN_NAME"));
        }

        while (rs.next()) {
            columnName.forEach(c -> {
                try {
                    System.out.printf("%s - %s %n", c, rs.getString(c));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            });


        }
        connection.close();
    }


}