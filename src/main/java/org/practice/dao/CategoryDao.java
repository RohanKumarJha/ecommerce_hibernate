package org.practice.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.practice.model.Category;
import org.practice.util.HibernateUtil;

import java.util.List;

public class CategoryDao {

    public void save(Category category) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                session.persist(category);
                transaction.commit();
            } catch (Exception e) {
                System.out.println("Error while saving category");
                if (transaction != null && transaction.isActive()) {
                    transaction.rollback();
                }
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Category findById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                Category category = session.find(Category.class, id);
                transaction.commit();
                return category;
            } catch (Exception e) {
                System.out.println("Error while getting category");
                if (transaction != null && transaction.isActive()) {
                    transaction.rollback();
                }
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Category findByName(String name) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                Category category = session.createQuery("FROM Category WHERE name = :name", Category.class)
                        .setParameter("name", name)
                        .uniqueResult();
                transaction.commit();
                return category;
            } catch (Exception e) {
                System.out.println("Error while getting category");
                if (transaction != null && transaction.isActive()) {
                    transaction.rollback();
                }
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Category> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                List<Category> categories = session.createQuery("FROM Category",Category.class).list();
                transaction.commit();
                return categories;
            } catch (Exception e) {
                System.out.println("Error while getting categories");
                if (transaction != null && transaction.isActive()) {
                    transaction.rollback();
                }
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                Category category = session.find(Category.class, id);
                if(category == null) {
                    System.out.println("Category not found");
                    return;
                }
                session.remove(category);
                System.out.println("Category deleted");
                transaction.commit();
            } catch (Exception e) {
                System.out.println("Error while getting category");
                if (transaction != null && transaction.isActive()) {
                    transaction.rollback();
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
