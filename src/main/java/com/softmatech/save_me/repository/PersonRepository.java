package com.softmatech.save_me.repository;

import com.softmatech.save_me.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface PersonRepository extends JpaRepository<Person, UUID> {
    Person findByEmail(String email);
}
