package com.arenaconnect.backend.services;

import com.arenaconnect.backend.models.User;
import com.arenaconnect.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // Save a user
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // Find a user by username
    public Optional<User> findUserByUsername(String username) {
        return Optional.ofNullable(userRepository.findByUsername(username));
    }

    // Find a user by ID
    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    // Get all users
    public Iterable<User> findAllUsers() {
        return userRepository.findAll();
    }
}