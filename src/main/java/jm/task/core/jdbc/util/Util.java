package jm.task.core.jdbc.util;
import java.sql.*;

public class Util {
    private static final String URL = "jdbc:mysql://localhost:3306/mysql1";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static Connection connection = null;
    public static Connection getConnection(){
        try {
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            System.out.println("connection ok");
        } catch (SQLException e) {
            System.out.println("Не удалось загрузить класс драйвер");
            System.out.println("error");
        }
        return connection;
    }
    public static void connectionClose() {
        try {
            if (connection != null && !connection.isClosed())
                connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
