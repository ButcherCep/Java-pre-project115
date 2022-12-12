package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Олег","Масюта",(byte)24);
        userService.saveUser("Миша","Архиерейский",(byte)24);
        userService.saveUser("Миша","Шехурин",(byte)25);
        userService.saveUser("Ильяр","Газизов",(byte)24);
        userService.getAllUsers();
        userService.cleanUsersTable();
        userService.dropUsersTable();
        Util.connectionClose();
    }
}
