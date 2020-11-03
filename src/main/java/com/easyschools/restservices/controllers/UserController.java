package com.easyschools.restservices.controllers;


import com.easyschools.restservices.entities.User;
import com.easyschools.restservices.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }


    @PostMapping("/users")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }


    @GetMapping("/user/{id}")
    public Optional<User> getUser(@PathVariable Long id) {
        Optional<User> user =  userService.getUserById(id);
        if(user.isPresent()){
            return user ;
        }else{
            return  null;
        }
    }

    @PutMapping("/user/{id}")
    public User updateUser(@RequestBody User user, @PathVariable Long id) {
        return userService.updateUser(id, user);
    }


    @DeleteMapping("/user/{id}")
    public void deleteUserById(@PathVariable  Long id) {
        userService.deleteUserById(id);
    }

    @GetMapping("/user/bySsn/{ssn}")
    public  User findUserBySsn(@PathVariable String ssn){
        return userService.findByUserBySsn(ssn);
    }
}



























