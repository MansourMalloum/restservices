package com.easyschools.restservices.services;

import com.easyschools.restservices.entities.User;
import com.easyschools.restservices.exceptions.SsnIDExistException;
import com.easyschools.restservices.exceptions.UserNotFoundException;
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




    public User createUser(User user) throws SsnIDExistException {
        String ssn = user.getSsn();
        Optional<User> optionalSsn = userRepository.findBySsn(ssn);

        if(optionalSsn.isPresent()){
            throw new SsnIDExistException("The given SSN ID already Exists");
        }
        return  userRepository.save(user);
    }




    public Optional<User> getUserById(Long id)  throws UserNotFoundException {
        if (userRepository.findById(id).isPresent()) {
            return userRepository.findById(id);
        }
        throw new UserNotFoundException("The user you search is not found !!!!");
    }




    public User updateUser(Long id , User user) throws UserNotFoundException{

        Optional<User> optionalUser = userRepository.findById(id);

        if(optionalUser.isEmpty()){
           throw new UserNotFoundException("The user is not found on the DB");
        }

        userRepository.save(user);
        return user;
    }





    public void  deleteUserById(Long id) throws UserNotFoundException {

        Optional<User> optionalUser = userRepository.findById(id);

        if(optionalUser.isEmpty()){
            throw new UserNotFoundException("The user is not found on the DB");
        }

       userRepository.deleteById(id);
    }




    public Optional<User> findByUserBySsn(String ssn)  {

        return userRepository.findBySsn(ssn);
    }


}


























