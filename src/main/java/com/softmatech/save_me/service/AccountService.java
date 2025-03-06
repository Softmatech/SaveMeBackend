package com.softmatech.save_me.service;

import com.softmatech.save_me.entity.Account;
import com.softmatech.save_me.entity.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AccountService {
    Account createAccount(Account account);  // Create a new person
    Optional<Account> getAccountById(UUID id);  // Get a person by their ID
    List<Account> getAllAccounts();  // Get all persons
    Account updateAccount(UUID id, Account account);  // Update an existing person
    void deleteAccount(UUID id);
}
