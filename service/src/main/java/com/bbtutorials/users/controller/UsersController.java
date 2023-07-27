package com.bbtutorials.users.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bbtutorials.users.entity.Users;
import com.bbtutorials.users.links.UserLinks;
import com.bbtutorials.users.service.UsersService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/")
public class UsersController {
	@Autowired
	UsersService usersService;

	@GetMapping(path = UserLinks.LIST_USERS)
    public ResponseEntity<?> listUsers() {
        log.info("UsersController: list users");
        List<Users> resource = usersService.getUsers();
        return ResponseEntity.ok(resource);
    }

    @PostMapping(path = UserLinks.ADD_USER)
    public ResponseEntity<?> saveUser(@RequestBody Users user) {
        log.info("UsersController: list users");
        Users resource = usersService.saveUser(user);
        return ResponseEntity.ok(resource);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") int id) {
        log.info("UsersController: delete user");
        Users resource = usersService.deleteUser(id);
        return ResponseEntity.ok(resource);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> findUserById(@PathVariable("id") int id) {
        log.info("UsersController: get user");
        Optional<Users> resource = usersService.getUserById(id);
        return ResponseEntity.ok(resource);
    }
}
