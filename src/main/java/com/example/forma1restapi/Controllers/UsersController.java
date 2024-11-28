package com.example.forma1restapi.Controllers;

import com.example.forma1restapi.Models.User;
import com.example.forma1restapi.Repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UsersController {
    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        List<User> users = usersRepository.findAll();

        return users;
    }
}
