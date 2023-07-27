package com.bbtutorials.users.service;

import com.bbtutorials.users.entity.Orders;
import com.bbtutorials.users.entity.Users;
import com.bbtutorials.users.repository.OrdersRepository;
import com.bbtutorials.users.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;
    @Autowired
    private UsersRepository usersRepository;

    public List<Orders> getOrders() {
        return ordersRepository.findAll();
    }

    public Orders saveOrder (Orders orders) {
        usersRepository.save(orders.getUserId());
        return ordersRepository.save(orders);
    }

    public Orders deleteOrder(int id) {
        ordersRepository.deleteById(id);
        return null;
    }

    public Optional<Orders> getOrderById(int id) {
        return ordersRepository.findById(id);
    }
}
