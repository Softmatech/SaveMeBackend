package com.softmatech.save_me.service;

import com.softmatech.save_me.entity.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonService {
    Person createPerson(Person person);  // Create a new person
    Optional<Person> getPersonById(UUID id);  // Get a person by their ID
    List<Person> getAllPersons();  // Get all persons
    Person updatePerson(UUID id, Person person);  // Update an existing person
    void deletePerson(UUID id);
}
