package com.microservices.users.controllers;

import com.microservices.users.entity.Users;
import com.microservices.users.services.IUsersService;
import com.microservices.users.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UsersController {

    @Autowired
    IUsersService usersService;

    @GetMapping("/users")
    public List<Users> getAllItems(){
        return usersService.getAllUsers();
    }

    @GetMapping("/users/{userId}")
    public Optional<Users> getItemById(@PathVariable String userId){
        return usersService.getUserById(userId);
    }

    @PostMapping("/users")
    public Users addItems(@RequestBody Users users){
        return usersService.addUsers(users);
    }
}
