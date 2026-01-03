package org.practice;

import org.practice.dao.UserDao;
import org.practice.model.User;
import org.practice.model.UserRole;

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

        userDao.deleteById(3);
    }
}