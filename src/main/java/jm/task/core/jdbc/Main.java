package jm.task.core.jdbc;

import java.util.logging.Level;
import java.util.logging.Logger;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    private static final Logger log = Logger.getLogger(Main.class.getName());


    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        log.log(Level.INFO, "createUsersTable success");
        userService.saveUser("Олег","Масюта",(byte)24);
        log.log(Level.INFO, "saveUser success");
        userService.saveUser("Миша","Архиерейский",(byte)24);
        log.log(Level.INFO, "saveUser success");
        userService.saveUser("Миша","Шехурин",(byte)25);
        log.log(Level.INFO, "saveUser success");
        userService.saveUser("Ильяр","Газизов",(byte)24);
        log.log(Level.INFO, "saveUser success");
        userService.getAllUsers();
        log.log(Level.INFO, "getAllUsers success");
        userService.cleanUsersTable();
        log.log(Level.INFO, "cleanUsersTable success");
        userService.dropUsersTable();
        log.info("dropUsersTable success");
    }
}

