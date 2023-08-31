package com.microservices.users.services;

import com.microservices.users.entity.Orders;
import com.microservices.users.entity.Users;
import com.microservices.users.feignclientservice.OrdersService;
import com.microservices.users.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class UsersService implements IUsersService {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    OrdersService service;

    @Override
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    @Override
    public Optional<Users> getUserById(String ID) {
        return usersRepository.findById(ID);
    }

    @Override
    public Users addUsers(Users user) {
        List<Orders> allOrders = service.getAllOrder();
        List<Orders> filterOrderByUser = allOrders.stream().filter(orders -> allOrders.contains(user.getUserName()))
                                        .collect(Collectors.toList());
        Users usersDTO= new Users();
        usersDTO.setUserId(user.getUserId());
        usersDTO.setUserName(user.getUserName());
        usersDTO.setAddress(user.getAddress());
        usersDTO.setMyOrders(filterOrderByUser);
        return usersDTO;
    }
}
