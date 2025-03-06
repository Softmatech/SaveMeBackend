package com.softmatech.save_me.service.Impl;

import com.softmatech.save_me.entity.Person;
import com.softmatech.save_me.repository.PersonRepository;
import com.softmatech.save_me.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person createPerson(Person person) {
        // Save the person in the database
        return personRepository.save(person);
    }

    @Override
    public Optional<Person> getPersonById(UUID id) {
        // Find a person by their ID
        return personRepository.findById(id);
    }

    @Override
    public List<Person> getAllPersons() {
        // Get all persons from the database
        return personRepository.findAll();
    }

    @Override
    public Person updatePerson(UUID id, Person person) {
        // Check if the person exists, then update
        Optional<Person> existingPerson = personRepository.findById(id);
        if (existingPerson.isPresent()) {
            person.setId(id);  // Set the ID of the person to update
            return personRepository.save(person);
        } else {
            throw new RuntimeException("Person not found with ID: " + id);
        }
    }

    @Override
    public void deletePerson(UUID id) {
        // Check if the person exists, then delete
        if (personRepository.existsById(id)) {
            personRepository.deleteById(id);
        } else {
            throw new RuntimeException("Person not found with ID: " + id);
        }
    }
}
