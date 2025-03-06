package com.softmatech.save_me.service.Impl;

import com.softmatech.save_me.entity.Account;
import com.softmatech.save_me.entity.Transaction;
import com.softmatech.save_me.repository.AccountRepository;
import com.softmatech.save_me.repository.TransactionRepository;
import com.softmatech.save_me.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Transaction createTransaction(Transaction transaction) {
        // Save the person in the database
        return transactionRepository.save(transaction);
    }

    @Override
    public Optional<Transaction> getTransactionById(UUID id) {
        // Find a person by their ID
        return transactionRepository.findById(id);
    }

    @Override
    public List<Transaction> getAllTransactions() {
        // Get all persons from the database
        return transactionRepository.findAll();
    }

    @Override
    public Transaction updateTransaction(UUID id, Transaction transaction) {
        // Check if the person exists, then update
        Optional<Transaction> existingTransaction = transactionRepository.findById(id);
        if (existingTransaction.isPresent()) {
            transaction.setId(id);  // Set the ID of the person to update
            return transactionRepository.save(transaction);
        } else {
            throw new RuntimeException("Transaction not found with ID: " + id);
        }
    }

    @Override
    public void deleteTransaction(UUID id) {
        // Check if the person exists, then delete
        if (transactionRepository.existsById(id)) {
            transactionRepository.deleteById(id);
        } else {
            throw new RuntimeException("Transaction not found with ID: " + id);
        }
    }
}
