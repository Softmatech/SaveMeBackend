package com.softmatech.save_me.service;

import com.softmatech.save_me.entity.Account;
import com.softmatech.save_me.entity.Transaction;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TransactionService {
    Transaction createTransaction(Transaction transaction);  // Create a new person
    Optional<Transaction> getTransactionById(UUID id);  // Get a person by their ID
    List<Transaction> getAllTransactions();  // Get all persons
    Transaction updateTransaction(UUID id, Transaction transaction);  // Update an existing person
    void deleteTransaction(UUID id);
}
