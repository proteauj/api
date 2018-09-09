package com.versatile.api.controller;

import com.versatile.api.model.UserModel;
import com.versatile.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/user")
    public UserModel getByEmail(@RequestParam(value="email") String email) {
        return userService.getByEmail(email);
    }
}
