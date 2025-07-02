package org.example;

import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
//    public String getGreeting() {
//        return "Hello World!";
//    }
    public static void connect() {
        // connection string
        var url = "jdbc:sqlite:src/main/resources/db/chinook.db";

        try (var conn = DriverManager.getConnection(url)) {
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args)
    {
//        System.out.println(new App().getGreeting());

        connect();

        AppService service = new AppService();
        TextUI ui = new TextUI(service);
        ui.start();

    }
}
