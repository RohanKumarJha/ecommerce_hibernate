package org.practice;

import org.practice.dao.CategoryDao;
import org.practice.dao.OrderDao;
import org.practice.dao.ProductDao;
import org.practice.dao.UserDao;
import org.practice.model.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();

//        User user = new User("Anjali","anjali****@gmail.com","**********", UserRole.ADMIN);
//        userDao.save(user);

//        System.out.println(userDao.findById(3));

//        System.out.println(userDao.findByEmail("rohan.jha****@gmail.com"));

//        List<User> users = userDao.findAll();
//        for (User user : users) {
//            System.out.println(user);
//        }

//        User user = new User(10,"Rohan Kumar jha","rohan.jha****@gmail.com","********",UserRole.USER);
//        userDao.update(user);

//        userDao.deleteById(3);




        CategoryDao categoryDao = new CategoryDao();

//        String description1 = "Here you find all sports related stuff";
//        Category category = new Category("Sports",description1);
//        categoryDao.save(category);

//        String description3 = "Here you find all education related stuff";
//        Category category3 = new Category("Education",description3);
//        categoryDao.save(category3);

//        String description2 = "Here you find all beauty related stuff";
//        Category category2 = new Category("Beauty",description2);
//        categoryDao.save(category2);

//        categoryDao.findById(20);

//        System.out.println(categoryDao.findByName("Beauty"));

//        List<Category> categories = categoryDao.findAll();
//        for (Category category : categories) {
//            System.out.println(category.getName());
//        }

//        categoryDao.deleteById(1);




        ProductDao productDao = new ProductDao();

//        String description1 = "Cricket kit kharid le bhai";
//        Category category1 = categoryDao.findById(3);
//        Product product1 = new Product("CricketKit",description1, BigDecimal.valueOf(12000),12, category1);
//        productDao.save(product1);

//        String description2 = "Hockey kit bhi le le bhai";
//        Category category2 = categoryDao.findById(3);
//        Product product2 = new Product("Hockey",description2, BigDecimal.valueOf(9000),18, category2);
//        productDao.save(product2);

//        String description3 = "Makeup kit bhi le le behen";
//        Category category3 = categoryDao.findById(2);
//        Product product3 = new Product("MakeupKit",description3, BigDecimal.valueOf(4500),7, category3);
//        productDao.save(product3);

//        String description4 = "Saree bhi fashion accessories hi hai";
//        Category category4 = categoryDao.findById(2);
//        Product product4 = new Product("Saree",description4, BigDecimal.valueOf(25000),7, category4);
//        productDao.save(product4);

//        String description5 = "Coding smart dikhata hai insaan ko";
//        Category category5 = categoryDao.findById(4);
//        Product product5 = new Product("Coding",description5, BigDecimal.valueOf(23000),11, category5);
//        productDao.save(product5);

//        System.out.println(productDao.findById(3));

//        System.out.println(productDao.findByName("Saree"));

//        List<Product> products = productDao.findAll();
//        for (Product product : products) {
//            System.out.println(product);
//        }

//        List<Product> products = productDao.findByCategoryId(1);
//        for (Product p : products) {
//            System.out.println(p);
//        }

//        List<Product> products = productDao.findByPriceRange(new BigDecimal(5000),new BigDecimal(50000));
//        for (Product p : products) {
//            System.out.println(p);
//        }

//        Product p = productDao.findById(1);
//        System.out.println(productDao.update(p));




        OrderDao orderDao = new OrderDao();

//        User user = userDao.findById(2);
//        Product product = productDao.findById(3);
//        Order order = new Order(user,product,new BigDecimal(10000),OrderStatus.CREATED,LocalDateTime.now());
//        orderDao.save(order);

//        User user2 = userDao.findById(1);
//        Product product2 = productDao.findById(8);
//        Order order2 = new Order(user2,product2,new BigDecimal(72000),OrderStatus.SHIPPED,LocalDateTime.now());
//        orderDao.save(order2);

//        orderDao.findById(10);

//        System.out.println(orderDao.findByUserId(2));

//        List<Order> orders = orderDao.findAll();
//        for (Order order : orders) {
//            System.out.println(order);
//        }

//        orderDao.updateStatus(1,OrderStatus.CANCELLED);

//        orderDao.deleteById(1);

    }
}