package designPattern.singelton;

public class DatabaseConnection {
    private static DatabaseConnection instance;

    private DatabaseConnection() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }
}
