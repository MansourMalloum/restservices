package com.easyschools.restservices.controllers;


import com.easyschools.restservices.entities.Order;
import com.easyschools.restservices.entities.User;
import com.easyschools.restservices.exceptions.UserNotFoundException;
import com.easyschools.restservices.repositories.OrderRepository;
import com.easyschools.restservices.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@RestController
@RequestMapping(value = "/users")
public class OrderController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;


    // Get All Orders for a user
    @GetMapping("/{userId}/orders")
    public List<Order> getAllOrders(@PathVariable Long userId) throws UserNotFoundException {


        try {
            Optional<User> userOptional = userRepository.findById(userId);
            if (userOptional.isEmpty()) {
                throw new UserNotFoundException("The given User can't be found !!");
            }
            return userOptional.get().getOrders();

        } catch (UserNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }


    }

    @PostMapping("/{userId}/orders")
    public void createOrder(@PathVariable Long userId, @RequestBody Order order) throws UserNotFoundException {

        try {
            Optional<User> userOptional = userRepository.findById(userId);

            if (userOptional.isEmpty()) {
                throw new UserNotFoundException("there is not user with the given ID ! please provide a correct ID");
            }

            User user = userOptional.get();
            order.setUser(user);
            orderRepository.save(order);


        } catch (UserNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Please no no no !");
        }
    }


//    @GetMapping("/{userId/orders/orderId}")
//    public Order getOrderByOrderId(@PathVariable Long userId, Long orderId){
//        try {
//            Optional<User> userOptional = userRepository.findById(userId);
//
//            if (userOptional.isEmpty()) {
//                throw new UserNotFoundException("there is not user with the given ID ! please provide a correct ID");
//            }
//
//            User user = userOptional.get();
//            List<Order> orders = user.getOrders();
//
//            Stream<Order> orderStream = orders.stream().filter(elt -> elt.getOrderId().equals(orderId));
//            return  orderStream;
//
//
//        } catch (UserNotFoundException ex) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Please no no no !");
//        }
//    }

}
