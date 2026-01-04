package org.practice.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.practice.model.Order;
import org.practice.model.OrderStatus;
import org.practice.util.HibernateUtil;

import java.util.List;

public class OrderDao {

    public void save(Order order) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                session.persist(order);
                transaction.commit();
                System.out.println("Order has been saved successfully");
            } catch (Exception e) {
                System.out.println("Transaction Error: " + e.getMessage());
                if (transaction != null && transaction.isActive()) {
                    transaction.rollback();
                }
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            throw new  RuntimeException(e);
        }
    }

    public Order findById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                Order order = session.find(Order.class, id);
                transaction.commit();
                if(order != null) System.out.println("Order has been found successfully");
                else System.out.println("Order has been NOT found");
                return order;
            } catch (Exception e) {
                System.out.println("Transaction Error: " + e.getMessage());
                if (transaction != null && transaction.isActive()) {
                    transaction.rollback();
                }
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            throw new  RuntimeException(e);
        }
    }

    public List<Order> findByUserId(int userId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                List<Order> orders = session.createQuery("FROM Order o WHERE o.user.id = :userId", Order.class)
                        .setParameter("userId", userId)
                        .getResultList();
                if(orders != null) System.out.println("Order has been found successfully");
                else System.out.println("Order has been NOT found");
                return orders;
            } catch (Exception e) {
                System.out.println("Transaction Error: " + e.getMessage());
                if(transaction != null && transaction.isActive()) {
                    transaction.rollback();
                }
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            throw new  RuntimeException(e);
        }
    }

    public List<Order> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                List<Order> orders = session.createQuery("FROM Order o", Order.class).getResultList();
                transaction.commit();
                return orders;
            } catch (Exception e) {
                System.out.println("Transaction Error: " + e.getMessage());
                if (transaction != null && transaction.isActive()) {
                    transaction.rollback();
                }
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            throw new  RuntimeException(e);
        }
    }

    public boolean updateStatus(int orderId, OrderStatus status) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();

                int updated = session.createQuery(
                                "UPDATE Order o SET o.status = :status WHERE o.id = :orderId"
                        )
                        .setParameter("status", status)   // ✅ ENUM
                        .setParameter("orderId", orderId)
                        .executeUpdate();

                transaction.commit();

                if (updated > 0) {
                    System.out.println("Order has been updated successfully");
                    return true;
                } else {
                    System.out.println("Order has NOT been updated");
                    return false;
                }

            } catch (Exception e) {
                if (transaction != null && transaction.isActive()) {
                    transaction.rollback();
                }
                throw new RuntimeException(e);
            }
        }
    }

    public boolean deleteById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                Order order = session.find(Order.class, id);
                session.remove(session.find(Order.class, id));
                transaction.commit();
                if(order != null) {
                    System.out.println("Order has been deleted successfully");
                    return true;
                }
                else {
                    System.out.println("Order has NOT been deleted");
                    return false;
                }
            } catch (Exception e) {
                System.out.println("Transaction Error: " + e.getMessage());
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
