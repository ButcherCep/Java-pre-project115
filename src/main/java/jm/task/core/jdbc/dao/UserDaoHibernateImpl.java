package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;


import java.util.List;

import static jm.task.core.jdbc.util.Util.getSessionFactory;

public class UserDaoHibernateImpl implements UserDao {

    @Override
    public void createUsersTable() {
        try (Session session = getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.createSQLQuery("create table IF NOT EXISTS user " +
                            "(id INT PRIMARY KEY AUTO_INCREMENT," +
                            " name VARCHAR(45), lastName VARCHAR(45)," +
                            " age INT)")
                    .executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void dropUsersTable() {
        try (Session session = getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.createSQLQuery("DROP TABLE IF EXISTS user")
                    .executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
            Transaction transaction = null;
        try (Session session = getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            User user = new User(name, lastName, age);
            session.save(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void removeUserById(long id) {
        try (Session session = getSessionFactory().openSession()) {
            session.beginTransaction();
            session.createSQLQuery("DELETE FROM user WHERE id:=id")
                    .setParameter("id",id)
                    .executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {
        try (Session session = getSessionFactory().openSession()) {
            return session.createQuery("FROM User", User.class).getResultList();
        }
    }

    @Override
    public void cleanUsersTable() {
        try (Session session = getSessionFactory().openSession()) {
            session.beginTransaction();
            session.createQuery("DELETE FROM User")
                    .executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
