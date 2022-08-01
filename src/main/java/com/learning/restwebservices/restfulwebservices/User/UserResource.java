package com.learning.restwebservices.restfulwebservices.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URL;
import java.util.List;

@RestController
public class UserResource {
    @Autowired
    private UserDaoService service;

    // (/users)     -> get all users.

    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return service.findAll();
    }

    @GetMapping("/users/{id}")
    public User findUser(@PathVariable int id){
       User user = service.findOne(id);

       if (user == null){
           throw new UserNotFoundException("ID : " +id);
       }

       return user;
    }

    @PostMapping("/users")
    public ResponseEntity<Object> addUser(@RequestBody User user){
        User savedUser =  service.saveUser(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{/id}")
                .buildAndExpand(savedUser.getId()).toUri();
        
        return ResponseEntity.created(location).build();
    }
}