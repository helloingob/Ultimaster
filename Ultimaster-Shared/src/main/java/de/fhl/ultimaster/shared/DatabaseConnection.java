package de.fhl.ultimaster.shared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.pmw.tinylog.Logger;

public class DatabaseConnection {

    private static DatabaseConnection instance = null;

    private DatabaseConnection() {}

    static {
        try {
            instance = new DatabaseConnection();
        } catch (Exception e) {
            Logger.error(e);
        }
    }

    public static DatabaseConnection getInstance() {
        return instance;
    }

    public Connection getConnection() {
        String url = "jdbc:sqlite:C:/Users/ingo/ultimaster.sqlite";
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(url);
        } catch (Exception e) {
            Logger.error(e);
        }
        return conn;
    }

    public void close(Connection connection, ResultSet resultSet, Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }

            if (resultSet != null) {
                resultSet.close();
            }

            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            Logger.error(e);
        }
    }

}
