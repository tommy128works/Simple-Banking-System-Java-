package org.example;

import java.sql.DriverManager;
import java.sql.SQLException;

public class TestDb {

    public static void connect() {
        // connection string
        var url = "jdbc:sqlite:src/main/resources/db/chinook.db";

        try (var conn = DriverManager.getConnection(url)) {
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
