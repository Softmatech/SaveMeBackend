package com.softmatech.save_me.service.Impl;

import com.softmatech.save_me.entity.User;
import com.softmatech.save_me.repository.UserRepository;
import com.softmatech.save_me.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        // Save the person in the database
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUserById(UUID id) {
        // Find a person by their ID
        return userRepository.findById(id);
    }

    @Override
    public List<User> getAllUsers() {
        // Get all persons from the database
        return userRepository.findAll();
    }

    @Override
    public User updateUser(UUID id, User user) {
        // Check if the person exists, then update
        Optional<User> existingPerson = userRepository.findById(id);
        if (existingPerson.isPresent()) {
            user.setId(id);  // Set the ID of the person to update
            return userRepository.save(user);
        } else {
            throw new RuntimeException("User not found with ID: " + id);
        }
    }

    @Override
    public void deleteUser(UUID id) {
        // Check if the person exists, then delete
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new RuntimeException("User not found with ID: " + id);
        }
    }
}
