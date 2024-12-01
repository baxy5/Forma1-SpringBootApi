package com.example.forma1restapi.Services;

import com.example.forma1restapi.Models.Role;
import com.example.forma1restapi.Models.User;
import com.example.forma1restapi.Repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UsersRepository usersRepository;

    private final PasswordEncoder passwordEncoder;

    @Lazy
    public UserService(PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
    }

    private Role role = Role.ROLE_USER;

    public User registerUser(User user){
        user.setJelszo(passwordEncoder.encode(user.getJelszo()));
        user.setRole(role);
        return usersRepository.save(user);
    }

    public User findByUsername(String username){
        return usersRepository.findByFelhasznalonev(username);
    }
}
