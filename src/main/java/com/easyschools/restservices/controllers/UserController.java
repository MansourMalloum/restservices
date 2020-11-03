package com.easyschools.restservices.controllers;


import com.easyschools.restservices.entities.User;
import com.easyschools.restservices.exceptions.SsnIDExistException;
import com.easyschools.restservices.exceptions.UserNotFoundException;
import com.easyschools.restservices.services.UserService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

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
    public ResponseEntity<Void>  createUser(@RequestBody User user , UriComponentsBuilder build) throws SsnIDExistException {
        try {

            userService.createUser(user);
            HttpHeaders httpHeaders =  new HttpHeaders();
            httpHeaders.setLocation(build.path("/user/{id}").buildAndExpand(user.getId()).toUri());
            return new ResponseEntity<Void>(httpHeaders, HttpStatus.CREATED);


        } catch (SsnIDExistException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
    }


    @GetMapping("/user/{id}")
    public Optional<User> getUser(@PathVariable Long id) throws UserNotFoundException {
        try {
            return userService.getUserById(id);
        } catch (UserNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }

    }

    @PutMapping("/user/{id}")
    public User updateUser(@RequestBody User user, @PathVariable Long id) throws UserNotFoundException {

        try {
            return userService.updateUser(id, user);
        } catch (UserNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
    }


    @DeleteMapping("/user/{id}")
    public void deleteUserById(@PathVariable Long id) throws UserNotFoundException {
        try {
            userService.deleteUserById(id);
        } catch (UserNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
    }

    @GetMapping("/user/bySsn/{ssn}")
    public Optional<User> findUserBySsn(@PathVariable String ssn) {

        return userService.findByUserBySsn(ssn);

    }
}






