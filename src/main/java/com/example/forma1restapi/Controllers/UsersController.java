package com.example.forma1restapi.Controllers;

import com.example.forma1restapi.Models.User;
import com.example.forma1restapi.Repositories.UsersRepository;
import com.example.forma1restapi.Services.JwtUtil;
import com.example.forma1restapi.Services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UsersController {
    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManagerBuilder authenticationManagerBuilder;
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody User user){
        if(userService.findByUsername(user.getFelhasznalonev()) != null){
            return ResponseEntity.badRequest().body("User already exists.");
        }

        userService.registerUser(user);
        return ResponseEntity.ok("User registered successfully.");
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User userCred){
        User user = userService.findByUsername(userCred.getFelhasznalonev());
        if(user == null || !passwordEncoder.matches(userCred.getJelszo(), user.getJelszo())){
            return ResponseEntity.badRequest().body("Invalid credentials.");
        }

        String token = jwtUtil.generateToken(user.getFelhasznalonev(), user.getRole());
        return ResponseEntity.ok(Map.of("token", token));
    }

    @GetMapping("/users")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<User> getAllUsers(){
        List<User> users = usersRepository.findAll();

        return users;
    }
}
