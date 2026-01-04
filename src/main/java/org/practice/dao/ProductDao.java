package org.practice.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.practice.model.Product;
import org.practice.util.HibernateUtil;

import java.math.BigDecimal;
import java.util.List;

public class ProductDao {

    public void save(Product product) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                session.persist(product);
                transaction.commit();
            } catch (Exception e) {
                System.out.println("Exception in save product: " + e.getMessage());
                if (transaction != null && transaction.isActive()) {
                    transaction.rollback();
                }
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Product findById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                Product product = session.find(Product.class, id);
                transaction.commit();
                return product;
            } catch (Exception e) {
                System.out.println("Exception in save product: " + e.getMessage());
                if (transaction != null && transaction.isActive()) {
                    transaction.rollback();
                }
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Product findByName(String name) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                Product product = session.createQuery("from Product where name=:name",Product.class)
                        .setParameter("name", name)
                        .uniqueResult();
                transaction.commit();
                return product;
            } catch (Exception e) {
                System.out.println("Exception in findByName product: " + e.getMessage());
                if (transaction != null && transaction.isActive()) {
                    transaction.rollback();
                }
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Product> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                List<Product> products = session.createQuery("from Product",Product.class).list();
                transaction.commit();
                return products;
            } catch (Exception e) {
                System.out.println("Exception in findAll product: " + e.getMessage());
                if (transaction != null && transaction.isActive()) {
                    transaction.rollback();
                }
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Product> findByCategoryId(int categoryId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                List<Product> products = session.createQuery("FROM Product p WHERE p.category.id = :categoryId", Product.class)
                        .setParameter("categoryId", categoryId)
                        .list();
                transaction.commit();
                return products;
            } catch (Exception e) {
                System.out.println("Exception in findByCategoryId product: " + e.getMessage());
                if (transaction != null && transaction.isActive()) {
                    transaction.rollback();
                }
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Product> findByPriceRange(BigDecimal minPrice, BigDecimal maxPrice) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                List<Product> products = session.createQuery("FROM Product p WHERE p.price BETWEEN :minPrice AND :maxPrice",Product.class)
                        .setParameter("minPrice", minPrice)
                        .setParameter("maxPrice", maxPrice)
                        .list();
                transaction.commit();
                return products;
            } catch (Exception e) {
                System.out.println("Exception in findByPriceRange product: " + e.getMessage());
                if (transaction != null && transaction.isActive()) {
                    transaction.rollback();
                }
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean update(Product product) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                session.merge(product);
                transaction.commit();
                return true;
            } catch (Exception e) {
                System.out.println("Exception in update product: " + e.getMessage());
                if (transaction != null && transaction.isActive()) {
                    transaction.rollback();
                }
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
