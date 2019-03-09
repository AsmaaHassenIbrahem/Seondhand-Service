package com.fontys.secondhand.service;

import com.fontys.secondhand.model.User;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class UserService {

    List<User> users = new ArrayList<>();

    public UserService() {
        users.add(new User("A", "a@a.com", "1234"));
        users.add(new User("B", "b@b.com", "1234"));
        users.add(new User("C", "c@c.com", "1234"));
    }

    public User login(String email, String password) {
        for (User user : users) {
            if (user.getEmail().contains(email) && user.getPassword().contains(password)) {
                return user;
            }
        }
        return null;
    }

    public boolean createAccount(String email, String password, String name) {
        // TODO: 3/7/2019 make a validation on email
        users.add(new User(name, email, password));
        return true;
    }
}
