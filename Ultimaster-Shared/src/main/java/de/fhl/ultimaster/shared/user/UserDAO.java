package de.fhl.ultimaster.shared.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.pmw.tinylog.Logger;
import de.fhl.ultimaster.shared.DatabaseConnection;

public class UserDAO {

    public static UserTO get(String mail, String password) {
        PreparedStatement statement = null;
        Connection connection = null;
        ResultSet resultSet = null;

        try {
            connection = DatabaseConnection.getInstance().getConnection();
            statement = connection.prepareStatement("SELECT * FROM user WHERE mail=? AND password=? LIMIT 1");
            statement.setString(1, mail);
            statement.setString(2, password);
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

    public static UserTO get(int id) {
        PreparedStatement statement = null;
        Connection connection = null;
        ResultSet resultSet = null;

        try {
            connection = DatabaseConnection.getInstance().getConnection();
            statement = connection.prepareStatement("SELECT * FROM user WHERE id=?");
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

    public static boolean delete(UserTO user) {
        PreparedStatement statement = null;
        Connection connection = null;
        ResultSet resultSet = null;

        try {
            connection = DatabaseConnection.getInstance().getConnection();
            statement = connection.prepareStatement("DELETE FROM user WHERE id=?");
            statement.setInt(1, user.getId());
            return statement.executeUpdate() > 0;
        } catch (Exception e) {
            Logger.error(e);
        } finally {
            DatabaseConnection.getInstance().close(connection, resultSet, statement);
        }
        return false;
    }

    public static boolean insert(UserTO user) {
        PreparedStatement statement = null;
        Connection connection = null;
        ResultSet resultSet = null;

        try {
            connection = DatabaseConnection.getInstance().getConnection();
            statement = connection.prepareStatement("INSERT INTO user (name, mail, password, admin) VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getName());
            statement.setString(2, user.getMail());
            statement.setString(3, user.getPassword());
            statement.setBoolean(4, user.isAdmin());
            int manipulatedRows = statement.executeUpdate();
            if (manipulatedRows > 0) {
                resultSet = statement.getGeneratedKeys();
                resultSet.next();
                user.setId(resultSet.getInt(1));
                return true;
            }
        } catch (Exception e) {
            Logger.error(e);
        } finally {
            DatabaseConnection.getInstance().close(connection, resultSet, statement);
        }
        return false;
    }

    public static boolean update(UserTO user) {
        PreparedStatement statement = null;
        Connection connection = null;
        ResultSet resultSet = null;

        try {
            connection = DatabaseConnection.getInstance().getConnection();
            statement = connection.prepareStatement("UPDATE user SET name=?, mail=?, password=?, admin=? WHERE id=?");
            statement.setString(1, user.getName());
            statement.setString(2, user.getMail());
            statement.setString(3, user.getPassword());
            statement.setBoolean(4, user.isAdmin());
            statement.setInt(5, user.getId());
            return statement.executeUpdate() > 0;
        } catch (Exception e) {
            Logger.error(e);
        } finally {
            DatabaseConnection.getInstance().close(connection, resultSet, statement);
        }
        return false;
    }

    public static List<UserTO> get() {
        PreparedStatement statement = null;
        Connection connection = null;
        ResultSet resultSet = null;

        List<UserTO> users = new ArrayList<>();
        try {
            connection = DatabaseConnection.getInstance().getConnection();
            statement = connection.prepareStatement("SELECT * FROM user");
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

    private static UserTO getDataFromRow(ResultSet resultSet) {
        UserTO user = new UserTO();
        try {
            user.setId(resultSet.getInt("id"));
            user.setName(resultSet.getString("name"));
            user.setMail(resultSet.getString("mail"));
            user.setPassword(resultSet.getString("password"));
            user.setAdmin(resultSet.getBoolean("admin"));
            return user;
        } catch (SQLException e) {
            Logger.error(e);
        }
        return null;
    }

}
