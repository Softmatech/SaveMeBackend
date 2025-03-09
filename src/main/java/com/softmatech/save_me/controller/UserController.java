package com.softmatech.save_me.controller;


import com.softmatech.save_me.entity.Person;
import com.softmatech.save_me.entity.User;
import com.softmatech.save_me.service.PersonService;
import com.softmatech.save_me.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping
    public List<User> getUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("{id}")
    public Optional<User> getUserById(@PathVariable("id")UUID id){
        return userService.getUserById(id);
    }

    @PutMapping("{id}")
    public Optional<User> updateUserById(@PathVariable("id")UUID id, @RequestBody User providedUser){
        return Optional.ofNullable(userService.updateUser(id, providedUser));
    }

}
