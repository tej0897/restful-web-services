package com.learning.restwebservices.restfulwebservices.User;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();

    private static int userCount = 3;

    static {
        users.add(new User(1,"Tejas", new Date()));
        users.add(new User(2, "Vyk", new Date()));
        users.add((new User(3, "Veena", new Date())));
    }

    public List<User> findAll(){
        return users;
    }

    public User saveUser(User user){
        if (user.getId() == null){
            user.setId(++userCount);
        }
        users.add(user);
        return user;
    }

    public User findOne(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }
}

