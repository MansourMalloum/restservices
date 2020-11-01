package com.easyschools.restservices.hello;

import com.easyschools.restservices.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("hello")
    public  String helloWorld() {
        return  "Hello World";
    }

    @GetMapping("helloworld-bean")
    public UserDetails helloWorldBeans(){
        return new UserDetails("Kalyan", "Reddy", "mumbay");
    }
}
