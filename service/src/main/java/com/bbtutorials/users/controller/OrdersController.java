package com.bbtutorials.users.controller;

import com.bbtutorials.users.entity.Orders;
import com.bbtutorials.users.entity.Users;
import com.bbtutorials.users.links.OrdersLinks;
import com.bbtutorials.users.service.OrdersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/")
public class OrdersController {
    @Autowired
    OrdersService ordersService;

    @GetMapping(path = OrdersLinks.LIST_ORDERS)
    public ResponseEntity<?> listOrders() {
        log.info("OrdersController: list orders");
        List<Orders> resource = ordersService.getOrders();
        return ResponseEntity.ok(resource);
    }

    @PostMapping(path = OrdersLinks.ADD_ORDER)
    public ResponseEntity<?> saveOrder(@RequestBody Orders order) {
        log.info("OrdersController: list orders");
        Orders resource = ordersService.saveOrder(order);
        return ResponseEntity.ok(resource);
    }

    @DeleteMapping("/orders/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable("id") int id) {
        log.info("OrdersController: delete order");
        Orders resource = ordersService.deleteOrder(id);
        return ResponseEntity.ok(resource);
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<?> findOrderById(@PathVariable("id") int id) {
        log.info("OrdersController: get order");
        Optional<Orders> resource = ordersService.getOrderById(id);
        return ResponseEntity.ok(resource);
    }
}
