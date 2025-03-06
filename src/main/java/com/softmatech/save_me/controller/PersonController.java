package com.softmatech.save_me.controller;


import com.softmatech.save_me.entity.Person;
import com.softmatech.save_me.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    public Person createPerson(@RequestBody Person person) {
        return personService.createPerson(person);
    }

    @GetMapping
    public List<Person> getPersons(){
        return personService.getAllPersons();
    }

    @GetMapping("{id}")
    public Optional<Person> getPersonById(@PathVariable("id")UUID id){
        return personService.getPersonById(id);
    }

    @PutMapping("{id}")
    public Optional<Person> updatePersonById(@PathVariable("id")UUID id, @RequestBody Person providedPerson){
        return Optional.ofNullable(personService.updatePerson(id, providedPerson));
    }

}
