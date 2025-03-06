package com.softmatech.save_me.controller;

import com.softmatech.save_me.entity.*;
import com.softmatech.save_me.repository.PersonRepository;
import com.softmatech.save_me.service.AccountService;
import com.softmatech.save_me.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@RestController
@RequestMapping("/api/populate")
public class DataPopulationController {

    private final PersonService personService;
    private final AccountService accountService;

    @Autowired
    public DataPopulationController(PersonService personService, AccountService accountService) {
        this.personService = personService;
        this.accountService = accountService;
    }

    @PostMapping
    public String populateDatabase() throws ParseException {

        //One possible approach is to use a SimpleDateFormat and the java.sql.Date(long) constructor like

        DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
        Date sqlDate = new Date(df.parse("02-04-2015").getTime());
        // Create Persons
        Person person1 = new Person("Andy", "Example", Sexe.Masculin, "andy@email.com", sqlDate, "Fort-liberté", " 3, cite notre dame Fort liberte", "Haiti", "Haitien", "3428930493", DocumentType.CARTE_IDENTITICATION, "Danise Pierre", "Marie Louise", "Celibataire");

        Account account= new Account(person1, "Compte Epargne", 1000.50, AccountType.EPARGNE,Currency.GOURDES);
        // Save Persons to the database
        personService.createPerson(person1);
        accountService.createAccount(account);
        return  "Sample data populated from controller";
    }
}
