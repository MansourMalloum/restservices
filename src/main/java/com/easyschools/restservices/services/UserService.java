package com.easyschools.restservices.services;

import com.easyschools.restservices.entities.User;
import com.easyschools.restservices.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    @Autowired
     private UserRepository userRepository;



    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    public User createUser(User user) {
        return  userRepository.save(user);
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }


    public User updateUser(Long id , User user) {
        user.setId(id); // Setting Id in the persistent content
        userRepository.save(user);
        return user;
    }



    public void  deleteUserById(Long id) {
       userRepository.deleteById(id);
    }


    public User findByUserBySsn(String ssn) {
        return userRepository.findBySsn(ssn);
    }


}


























