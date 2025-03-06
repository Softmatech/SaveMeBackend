package com.softmatech.save_me.controller;

import com.softmatech.save_me.entity.*;
import com.softmatech.save_me.repository.PersonRepository;
import com.softmatech.save_me.service.AccountService;
import com.softmatech.save_me.service.PersonService;
import com.softmatech.save_me.service.TransactionService;
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
    private final TransactionService transactionService;

    @Autowired
    public DataPopulationController(PersonService personService, AccountService accountService, TransactionService transactionService) {
        this.personService = personService;
        this.accountService = accountService;
        this.transactionService = transactionService;
    }

    @PostMapping
    public String populateDatabase() throws ParseException {

        //One possible approach is to use a SimpleDateFormat and the java.sql.Date(long) constructor like

        DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
        Date sqlDate = new Date(df.parse("02-04-2015").getTime());
        // Create Persons
        Person personOne = new Person("Andy", "Example", Sexe.Masculin, "andy@email.com", sqlDate, "Fort-liberté", " 3, cite notre dame Fort liberte", "Haiti", "Haitien", "3428930493", DocumentType.CARTE_IDENTITICATION, "Danise Pierre", "Marie Louise", "Celibataire");

        Account accountOne= new Account(personOne, "Compte Epargne", 1000.50, AccountType.EPARGNE,Currency.GOURDES);

        Transaction transactionOne = new Transaction(accountOne, TransactionType.OUVERTURE, 1000.50, "Ouverture de compte");
        // Save Persons to the database
        personService.createPerson(personOne);
        accountService.createAccount(accountOne);
        transactionService.createTransaction(transactionOne);
        return  "Sample data populated from controller";
    }
}
