package com.markify.controller;

import com.markify.entity.Course;
import com.markify.entity.User;
import com.markify.repository.UserRepository;
import com.markify.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class UserController {
    private final UserService userService;
    private UserRepository userRepository;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/")
    public List<User> getUsers(){
        return userService.getAllUsers();
    };

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @PostMapping("/")
    public User postUser(@RequestBody @Valid  User user){
        return userService.createUser(user.getName(), user.getEmail(), user.getPassword());
    }

    @DeleteMapping("/{email}")
    public String deleteUser(@PathVariable String email){
         return userService.deleteUser(email);
    }
}
