package com.learning.restwebservices.restfulwebservices.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
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
    public ResponseEntity<Object> addUser(@Valid @RequestBody User user){
        User savedUser =  service.saveUser(user);

        URI location = ServletUriComponentsBuilder  //get location to pass in ResponseEntity
                .fromCurrentRequest()
                .path("{/id}")
                .buildAndExpand(savedUser.getId()).toUri();
        
        return ResponseEntity.created(location).build();        // responseEntity is used to get the status code for an OP.
                                                            // 201 for created, 200 for success etc.
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id){
        User user = service.deleteById(id);

        if (user == null){
            throw new UserNotFoundException("ID : " +id);
        }
    }
}
