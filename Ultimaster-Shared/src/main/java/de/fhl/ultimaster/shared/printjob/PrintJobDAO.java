package de.fhl.ultimaster.shared.printjob;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.IOUtils;
import org.pmw.tinylog.Logger;
import de.fhl.ultimaster.shared.DatabaseConnection;
import de.fhl.ultimaster.shared.user.UserTO;

public class PrintJobDAO {

    public static PrintJobTO getNext() {
        PreparedStatement statement = null;
        Connection connection = null;
        ResultSet resultSet = null;

        try {
            connection = DatabaseConnection.getInstance().getConnection();
            statement = connection.prepareStatement("SELECT printjob.*, user.name AS user_name, user.mail AS user_mail, user.admin AS user_admin FROM printjob JOIN user ON user.id = printjob.user_id WHERE printjob.active ORDER BY \"order\" LIMIT 1");
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

    public static PrintJobTO get(int id) {
        PreparedStatement statement = null;
        Connection connection = null;
        ResultSet resultSet = null;

        try {
            connection = DatabaseConnection.getInstance().getConnection();
            statement = connection.prepareStatement("SELECT printjob.*, user.name AS user_name, user.mail AS user_mail, user.admin AS user_admin FROM printjob JOIN user ON user.id = printjob.user_id WHERE id=?");
            statement.setInt(1, id);
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

    public static boolean delete(PrintJobTO user) {
        PreparedStatement statement = null;
        Connection connection = null;
        ResultSet resultSet = null;

        try {
            connection = DatabaseConnection.getInstance().getConnection();
            statement = connection.prepareStatement("DELETE FROM printjob WHERE id=?");
            statement.setInt(1, user.getId());
            return statement.executeUpdate() > 0;
        } catch (Exception e) {
            Logger.error(e);
        } finally {
            DatabaseConnection.getInstance().close(connection, resultSet, statement);
        }
        return false;
    }

    public static boolean insert(PrintJobTO printJob) {
        PreparedStatement statement = null;
        Connection connection = null;
        ResultSet resultSet = null;

        try {
            connection = DatabaseConnection.getInstance().getConnection();
            statement = connection.prepareStatement("INSERT INTO printjob (\"order\", active, name, file, filename, user_id) VALUES (?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, printJob.getOrder());
            statement.setBoolean(2, printJob.isActive());
            statement.setString(3, printJob.getName());
            statement.setBytes(4, printJob.getBytes());
            statement.setString(5, printJob.getFilename());
            statement.setInt(6, printJob.getUser().getId());
            int manipulatedRows = statement.executeUpdate();
            if (manipulatedRows > 0) {
                resultSet = statement.getGeneratedKeys();
                resultSet.next();
                printJob.setId(resultSet.getInt(1));
                return true;
            }
        } catch (Exception e) {
            Logger.error(e);
            Logger.error(e);
        } finally {
            DatabaseConnection.getInstance().close(connection, resultSet, statement);
        }
        return false;
    }

    public static boolean update(PrintJobTO printjob) {
        PreparedStatement statement = null;
        Connection connection = null;
        ResultSet resultSet = null;

        try {
            connection = DatabaseConnection.getInstance().getConnection();
            statement = connection.prepareStatement("UPDATE printjob SET \"order\"=?, active=?, name=?, file=?, filename=?, user_id=? WHERE id=?");
            statement.setInt(1, printjob.getOrder());
            statement.setBoolean(2, printjob.isActive());
            statement.setString(3, printjob.getName());
            statement.setBytes(4, printjob.getBytes());
            statement.setString(5, printjob.getFilename());
            statement.setInt(6, printjob.getUser().getId());
            statement.setInt(7, printjob.getId());
            return statement.executeUpdate() > 0;
        } catch (Exception e) {
            Logger.error(e);
        } finally {
            DatabaseConnection.getInstance().close(connection, resultSet, statement);
        }
        return false;
    }

    public static List<PrintJobTO> get() {
        PreparedStatement statement = null;
        Connection connection = null;
        ResultSet resultSet = null;

        List<PrintJobTO> users = new ArrayList<>();
        try {
            connection = DatabaseConnection.getInstance().getConnection();
            statement = connection.prepareStatement("SELECT printjob.*, user.name AS user_name, user.mail AS user_mail, user.admin AS user_admin FROM printjob LEFT JOIN user ON user.id = printjob.user_id ORDER BY \"order\"");
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                users.add(getDataFromRow(resultSet));
            }
            return users;
        } catch (Exception e) {
            Logger.error(e);
        } finally {
            DatabaseConnection.getInstance().close(connection, resultSet, statement);
        }
        return users;
    }

    public static List<PrintJobTO> getActive() {
        PreparedStatement statement = null;
        Connection connection = null;
        ResultSet resultSet = null;

        List<PrintJobTO> users = new ArrayList<>();
        try {
            connection = DatabaseConnection.getInstance().getConnection();
            statement = connection.prepareStatement("SELECT printjob.*, user.name AS user_name, user.mail AS user_mail, user.admin AS user_admin FROM printjob LEFT JOIN user ON user.id = printjob.user_id WHERE printjob.active ORDER BY \"order\"");
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                users.add(getDataFromRow(resultSet));
            }
            return users;
        } catch (Exception e) {
            Logger.error(e);
        } finally {
            DatabaseConnection.getInstance().close(connection, resultSet, statement);
        }
        return users;
    }

    public static int getNextOrder() {
        PreparedStatement statement = null;
        Connection connection = null;
        ResultSet resultSet = null;

        try {
            connection = DatabaseConnection.getInstance().getConnection();
            statement = connection.prepareStatement("SELECT MAX(\"order\") FROM printjob");
            resultSet = statement.executeQuery();
            if (resultSet.next() != false) {
                return resultSet.getInt(1) + 1;
            } else {
                return 0;
            }
        } catch (Exception e) {
            Logger.error(e);
        } finally {
            DatabaseConnection.getInstance().close(connection, resultSet, statement);
        }
        return 0;
    }

    private static PrintJobTO getDataFromRow(ResultSet resultSet) {
        PrintJobTO printjob = new PrintJobTO();
        try {
            printjob.setId(resultSet.getInt("id"));
            printjob.setOrder(resultSet.getInt("order"));
            printjob.setActive(resultSet.getBoolean("active"));
            printjob.setName(resultSet.getString("name"));
            printjob.setBytes(IOUtils.toByteArray(resultSet.getBinaryStream("file")));
            printjob.setFilename(resultSet.getString("filename"));

            UserTO user = new UserTO();
            user.setId(resultSet.getInt("user_id"));
            user.setName(resultSet.getString("user_name"));
            user.setMail(resultSet.getString("user_mail"));
            user.setAdmin(resultSet.getBoolean("user_admin"));

            printjob.setUser(user);
            return printjob;
        } catch (SQLException | IOException e) {
            Logger.error(e);
        }
        return null;
    }

}
