package za.co._4tab.banking.config;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class DatabaseInitializer {

    private static final String DB_NAME = "banking_db";

    @PostConstruct
    public void init() {
        createDatabaseIfNotExists();
    }

    private void createDatabaseIfNotExists() {

        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "postgres123"; // MUST be real password

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {

            ResultSet rs = stmt.executeQuery(
                    "SELECT 1 FROM pg_database WHERE datname = '" + DB_NAME + "'"
            );

            if (!rs.next()) {
                stmt.executeUpdate("CREATE DATABASE " + DB_NAME);
                System.out.println("DB created");
            } else {
                System.out.println("DB exists");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}