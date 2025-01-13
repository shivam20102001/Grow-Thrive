package database;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Statement;

public class DatabaseInitializer {
    public static void initializeDatabase() {

        String  dataFilePath = "data/data.sql";

        String createUsersTable = """
            CREATE TABLE IF NOT EXISTS users (
                id BIGINT AUTO_INCREMENT PRIMARY KEY,
                username VARCHAR(255) NOT NULL UNIQUE,
                email VARCHAR(255) NOT NULL UNIQUE,
                password VARCHAR(255) NOT NULL,
                profile_image VARCHAR(255),
                first_name VARCHAR(255),
                middle_name VARCHAR(255),
                last_name VARCHAR(255),
                is_active BOOLEAN DEFAULT TRUE
            );
        """;

        String createGoalsTable = """
            CREATE TABLE IF NOT EXISTS goals (
                id BIGINT AUTO_INCREMENT PRIMARY KEY,
                name VARCHAR(255) NOT NULL,
                description TEXT,
                start_date DATETIME,
                end_date DATETIME,
                is_completed BOOLEAN DEFAULT FALSE,
                points INT,
                user_id BIGINT NOT NULL,
                FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
            );
        """;

        String createRoutinesTable = """
            CREATE TABLE IF NOT EXISTS routines (
                id BIGINT AUTO_INCREMENT PRIMARY KEY,
                name VARCHAR(255) NOT NULL,
                description TEXT,
                recurring_pattern String NOT NULL,
                user_id BIGINT NOT NULL,
                date DATE,
                time_of_day DATETIME,
                occurrence INT,
                FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
            );
        """;

        String createRoutinesHistoryTable = """
            CREATE TABLE IF NOT EXISTS routines_history (
                id BIGINT AUTO_INCREMENT PRIMARY KEY,
                on_time BOOLEAN DEFAULT FALSE,
                points INT,
                routine_id BIGINT NOT NULL,
                FOREIGN KEY (routine_id) REFERENCES routines(id) ON DELETE CASCADE
            );
        """;

        String createCustomPatternsTable = """
            CREATE TABLE IF NOT EXISTS custom_patterns (
                id BIGINT AUTO_INCREMENT PRIMARY KEY,
                interval_days INT,
                days_of_week JSON,
                specific_dates DATETIME,
                routine_id BIGINT NOT NULL,
                FOREIGN KEY (routine_id) REFERENCES routines(id) ON DELETE CASCADE
            );
        """;

        try (Connection conn = DatabaseManager.getConnection();
             Statement stmt = conn.createStatement()) {

            // Execute table creation statements
            stmt.execute(createUsersTable);
            stmt.execute(createGoalsTable);
            stmt.execute(createRoutinesTable);
            stmt.execute(createRoutinesHistoryTable);
            stmt.execute(createCustomPatternsTable);

            // Read the SQL file and execute it
            String sql = new String(Files.readAllBytes(Paths.get(dataFilePath)));
            stmt.executeUpdate(sql);
            System.out.println("Database initialized successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
