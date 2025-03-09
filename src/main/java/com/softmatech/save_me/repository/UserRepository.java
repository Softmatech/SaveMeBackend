package com.softmatech.save_me.repository;

import com.softmatech.save_me.entity.Person;
import com.softmatech.save_me.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    User findByUserName(String name);
}
