package com.thinking.spring.controller;

import com.thinking.spring.pojo.User;
import com.thinking.spring.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RequiredArgsConstructor
@RestController
public class UserController {

    private final IUserService userService;

    @PostMapping("/users/addUser")
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

}
