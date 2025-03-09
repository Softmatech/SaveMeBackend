package com.softmatech.save_me.service;

import com.softmatech.save_me.entity.User;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {
    User createUser(User user);  // Create a new User
    Optional<User> getUserById(UUID id);  // Get a User by their ID
    List<User> getAllUsers();  // Get all Users
    User updateUser(UUID id, User user);  // Update an existing User
    void deleteUser(UUID id);
}
