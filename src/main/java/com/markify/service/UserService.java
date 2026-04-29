package com.markify.service;

import com.markify.entity.User;
import com.markify.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(String name, String email, String password){
        Optional<User> existing = userRepository.findByEmail(email);

        if(existing.isPresent()){
            throw new RuntimeException("User already exist");
        }

        User user = new User(name, email, password);
        return userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Long id){
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void deleteUser(Long id){
         userRepository.deleteById(id);
    }

}
