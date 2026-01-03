package org.practice.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.practice.model.User;
import org.practice.util.HibernateUtil;

import java.util.List;

public class UserDao {

    public void save(User user) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                session.persist(user);
                transaction.commit();
            } catch (Exception e) {
                System.out.println("User save failed");
                if (transaction != null && transaction.isActive()) {
                    transaction.rollback();
                }
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public User findById(int id) {
        User user = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                user = session.find(User.class, id);
                transaction.commit();
            } catch (Exception e) {
                System.out.println("User found failed");
                if (transaction != null && transaction.isActive()) {
                    transaction.rollback();
                }
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    public User findByEmail(String email) {
        User user = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                user = session.createQuery("from User where email = :email",User.class)
                        .setParameter("email", email).uniqueResult();
                transaction.commit();
            } catch (Exception e) {
                System.out.println("User found failed");
                if (transaction != null && transaction.isActive()) {
                    transaction.rollback();
                }
            }
        }  catch (Exception e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    public List<User> findAll() {
        List<User> users = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                users = session.createQuery("from User",User.class).list();
                transaction.commit();
            } catch (Exception e) {
                System.out.println("User found failed");
                if (transaction != null && transaction.isActive()) {
                    transaction.rollback();
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    public boolean update(User user) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                if(findById(user.getId()) == null) {
                    System.out.println("User not found");
                    return false;
                }
                session.createQuery("update User set name = :name, password = :password where id = :id")
                        .setParameter("name", user.getName())
                        .setParameter("password", user.getPassword())
                        .setParameter("id", user.getId())
                        .executeUpdate();
                transaction.commit();
            } catch (Exception e) {
                System.out.println("User found failed");
                if (transaction != null && transaction.isActive()) {
                    transaction.rollback();
                }
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("User updated");
        return true;
    }

    public boolean deleteById(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            User user = session.find(User.class, id);
            if (user == null) {
                System.out.println("User not found");
                return false;
            }
            session.remove(user);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException(e);
        }
    }

}
