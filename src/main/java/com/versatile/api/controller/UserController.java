package com.versatile.api.controller;

import com.versatile.api.exception.LogInNotFoundException;
import com.versatile.api.exception.MakeNotFoundException;
import com.versatile.api.exception.UserAlreadyExistException;
import com.versatile.api.exception.UserNotFoundException;
import com.versatile.api.ressource.LogInRessource;
import com.versatile.api.ressource.MakeRessource;
import com.versatile.api.ressource.ModelRessource;
import com.versatile.api.ressource.UserRessource;
import com.versatile.api.service.LogInService;
import com.versatile.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    LogInService logInService;

    @GetMapping("/users")
    public List<UserRessource> getUsers(@RequestParam(value="email", required=false) String email) {
        if (email == null) {
            return userService.getUsers();
        } else {
            return Arrays.asList(userService.getByEmail(email));
        }
    }

    @GetMapping("/users/{id}")
    UserRessource getById(@PathVariable int id) throws UserNotFoundException {
        return userService.getById(id);
    }

    @GetMapping("/users/{id}/logIns")
    LogInRessource getLogInByUser(@PathVariable int id) throws UserNotFoundException {
        UserRessource user = userService.getById(id);
        return logInService.getLogInByUser(user);
    }

    @PostMapping("/users")
    UserRessource createUser(@RequestBody UserRessource user) throws UserAlreadyExistException {
        return userService.save(user);
    }

    @PutMapping("/users/{id}")
    UserRessource updateUser(@RequestBody UserRessource user, @PathVariable int id) {
        return userService.updateUser(user, id);
    }

    @DeleteMapping("/users/{id}")
    void deleteUser(@PathVariable int id) {
        userService.deleteById(id);
    }
}
