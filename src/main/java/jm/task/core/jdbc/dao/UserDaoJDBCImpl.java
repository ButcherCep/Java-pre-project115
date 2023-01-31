package jm.task.core.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    Connection connection = Util.getConnection();

    public void createUsersTable() {
        try (Statement statement = connection.createStatement()){
            statement.executeUpdate("create table IF NOT EXISTS user (id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(45), lastName VARCHAR(45), age INT)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void dropUsersTable() {
        try (Statement statement = connection.createStatement()){
            statement.executeUpdate("drop table IF EXISTS user");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        final String INSERT_INTO = "INSERT INTO user(name, lastname, age) VALUES (?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO)) {
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        final String DELETE_FROM = "DELETE FROM user \n" + "WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_FROM)){
            preparedStatement.setLong(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        final String SELECT_FROM = "SELECT * FROM user";
        List<User> list = new ArrayList<>();
        try (Statement statement = connection.createStatement()){
            ResultSet rs = statement.executeQuery(SELECT_FROM);
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getLong(1));
                user.setName(rs.getString(2));
                user.setLastName(rs.getString(3));
                user.setAge(rs.getByte(4));
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void cleanUsersTable() {
        try (Statement statement = connection.createStatement()){
            statement.executeUpdate("DELETE FROM user");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
