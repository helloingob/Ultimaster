package de.fhl.ultimaster.shared.printer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.pmw.tinylog.Logger;
import de.fhl.ultimaster.shared.DatabaseConnection;

public class PrinterDAO {

    public static Printer get() {
        PreparedStatement statement = null;
        Connection connection = null;
        ResultSet resultSet = null;

        try {
            connection = DatabaseConnection.getInstance().getConnection();
            statement = connection.prepareStatement("SELECT * FROM printer LIMIT 1");
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return getDataFromRow(resultSet);
            }
        } catch (Exception e) {
            Logger.error(e);
        } finally {
            DatabaseConnection.getInstance().close(connection, resultSet, statement);
        }
        return null;
    }

    private static Printer getDataFromRow(ResultSet resultSet) {
        Printer printer = new Printer();
        try {
            printer.setId(resultSet.getInt("id"));
            printer.setHost(resultSet.getString("host"));
            printer.setPrinterId(resultSet.getString("printer_id"));
            printer.setPrinterKey(resultSet.getString("printer_key"));
            printer.setQueueActive(resultSet.getBoolean("queue_active"));
            return printer;
        } catch (SQLException e) {
            Logger.error(e);
        }
        return null;
    }

    public static boolean save(Printer printer) {
        PreparedStatement statement = null;
        Connection connection = null;
        ResultSet resultSet = null;

        try {
            connection = DatabaseConnection.getInstance().getConnection();
            statement = connection.prepareStatement("INSERT INTO printer (host, printer_id, printer_key, queue_active) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, printer.getHost());
            statement.setString(2, printer.getPrinterId());
            statement.setString(3, printer.getPrinterKey());
            statement.setBoolean(4, printer.isQueueActive());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                printer.setId(rs.getInt(1));
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
            Logger.error(e);
        } finally {
            DatabaseConnection.getInstance().close(connection, resultSet, statement);
        }
        return false;
    }

    public static boolean update(Printer printer) {
        PreparedStatement statement = null;
        Connection connection = null;
        ResultSet resultSet = null;

        try {
            connection = DatabaseConnection.getInstance().getConnection();
            statement = connection.prepareStatement("UPDATE printer SET host=?,printer_id=?,printer_key=?,queue_active=?  WHERE id = ?", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, printer.getHost());
            statement.setString(2, printer.getPrinterId());
            statement.setString(3, printer.getPrinterKey());
            statement.setBoolean(4, printer.isQueueActive());
            statement.setInt(5, printer.getId());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                printer.setId(rs.getInt(1));
                return true;
            }
        } catch (Exception e) {
            Logger.error(e);
        } finally {
            DatabaseConnection.getInstance().close(connection, resultSet, statement);
        }
        return false;
    }

}
