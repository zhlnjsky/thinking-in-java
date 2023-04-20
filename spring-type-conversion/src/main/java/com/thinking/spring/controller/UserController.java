package com.thinking.spring.controller;


import com.thinking.spring.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/users/create")
    public void addUser(User user){
        System.out.println(user);
    }

}
