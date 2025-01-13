package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    public static Connection getConnection() throws SQLException {
        String dbPath = "data/app_data.db"; // Or use user-specific path
        String url = "jdbc:sqlite:" + dbPath;
        return DriverManager.getConnection(url);
    }
}
