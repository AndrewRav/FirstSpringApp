package com.bbtutorials.users.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.bbtutorials.users.entity.Users;
import com.bbtutorials.users.repository.UsersRepository;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
	
	@Autowired
    private UsersRepository usersRepository;

    public List<Users> getUsers() {
        return usersRepository.findAll();
    }
    
    public Users saveUser(Users users) {
        return usersRepository.save(users);
    }

    public Users deleteUser(int id) {
        usersRepository.deleteById(id);
        return null;
    }

    public Optional<Users> getUserById(int id) {
        return usersRepository.findById(id);
    }

}
