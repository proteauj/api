package com.versatile.api.controller;

import com.versatile.api.exception.UserAlreadyExistException;
import com.versatile.api.exception.UserNotFoundException;
import com.versatile.api.model.UserModel;
import com.versatile.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<UserModel> getUsers(@RequestParam(value="email", required=false) String email) {
        if (email == null) {
            return userService.getUsers();
        } else {
            return Arrays.asList(userService.getByEmail(email));
        }
    }


    @GetMapping("/users/{id}")
    UserModel getById(@PathVariable int id) throws UserNotFoundException {
        return userService.getById(id);
    }

    @PostMapping("/users")
    UserModel createUser(@RequestBody UserModel user) throws UserAlreadyExistException {
        return userService.save(user);
    }

    @PutMapping("/users/{id}")
    UserModel updateUser(@RequestBody UserModel user, @PathVariable int id) {
        return userService.updateUser(user, id);
    }

    @DeleteMapping("/users/{id}")
    void deleteUser(@PathVariable int id) {
        userService.deleteById(id);
    }
}
