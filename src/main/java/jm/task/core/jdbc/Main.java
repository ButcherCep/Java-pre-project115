package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Олег","Масюта",(byte)24);
        userService.saveUser("Миша","Архиерейский",(byte)24);
        userService.saveUser("Миша","Шехурин",(byte)25);
        userService.saveUser("Ильяр","Газизов",(byte)24);
        userService.getAllUsers();
        System.out.println(userService.getAllUsers().size());
        userService.cleanUsersTable();
        userService.dropUsersTable();
        Util.sessionFactoryClose();
    }
}

