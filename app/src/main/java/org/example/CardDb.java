package org.example;

import java.sql.DriverManager;
import java.sql.SQLException;

public class CardDb {
    private final String url;

    public CardDb() {
        this.url = "jdbc:sqlite:src/main/resources/db/card.db";

        var sql = "CREATE TABLE IF NOT EXISTS card ("
                + "	id INTEGER PRIMARY KEY,"
                + "	number TEXT NOT NULL,"
                + "	pin TEXT,"
                + " balance INTEGER DEFAULT 0"
                + ");";

        try (var conn = DriverManager.getConnection(this.url);
             var stmt = conn.createStatement()) {
            if (conn != null) {
                stmt.execute(sql);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void insertCard(String card, String pin) {
        String sql = "INSERT INTO card(number,pin) VALUES(?,?)";
        try (var conn = DriverManager.getConnection(url);
             var pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, card);
            pstmt.setString(2, pin);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }



}
