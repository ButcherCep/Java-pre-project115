package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.util.List;

public class Main2 {
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
        userService.dropUsersTable();
        userService.createUsersTable();
        userService.saveUser("Олег","Масюта",(byte)24);
        List<User> userList = userService.getAllUsers();
        if (userList.size() != 1) {
            System.out.println(userList.size()+"Проверьте корректность работы метода сохранения пользователя/удаления или создания таблицы");
        } else {
            System.out.println(userList.size()+"Все гуд");
        }
        Util.sessionFactoryClose();
    }
}
