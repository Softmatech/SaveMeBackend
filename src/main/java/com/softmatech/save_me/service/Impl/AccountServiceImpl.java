package com.softmatech.save_me.service.Impl;

import com.softmatech.save_me.entity.Account;
import com.softmatech.save_me.entity.Person;
import com.softmatech.save_me.repository.AccountRepository;
import com.softmatech.save_me.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account createAccount(Account account) {
        // Save the person in the database
        return accountRepository.save(account);
    }

    @Override
    public Optional<Account> getAccountById(UUID id) {
        // Find a person by their ID
        return accountRepository.findById(id);
    }

    @Override
    public List<Account> getAllAccounts() {
        // Get all persons from the database
        return accountRepository.findAll();
    }

    @Override
    public Account updateAccount(UUID id, Account account) {
        // Check if the person exists, then update
        Optional<Account> existingAccount = accountRepository.findById(id);
        if (existingAccount.isPresent()) {
            account.setId(id);  // Set the ID of the person to update
            return accountRepository.save(account);
        } else {
            throw new RuntimeException("Person not found with ID: " + id);
        }
    }

    @Override
    public void deleteAccount(UUID id) {
        // Check if the person exists, then delete
        if (accountRepository.existsById(id)) {
            accountRepository.deleteById(id);
        } else {
            throw new RuntimeException("Person not found with ID: " + id);
        }
    }
}
