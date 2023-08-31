package com.microservices.users.services;

import com.microservices.users.entity.Users;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface IUsersService {

    List<Users> getAllUsers();
    Optional<Users> getUserById(String ID);
    Users addUsers(Users user);
}
