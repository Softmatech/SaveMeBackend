package com.softmatech.save_me.controller;


import com.softmatech.save_me.entity.Account;
import com.softmatech.save_me.entity.Transaction;
import com.softmatech.save_me.service.AccountService;
import com.softmatech.save_me.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public Transaction createAccount(@RequestBody Transaction transaction) {
        return transactionService.createTransaction(transaction);
    }

    @GetMapping
    public List<Transaction> getTransactions(){
        return transactionService.getAllTransactions();
    }

    @GetMapping("{id}")
    public Optional<Transaction> getAccountById(@PathVariable("id")UUID id){
        return transactionService.getTransactionById(id);
    }

    @PutMapping("{id}")
    public Optional<Transaction> updateAccountById(@PathVariable("id")UUID id, @RequestBody Transaction providedTransaction){
        return Optional.ofNullable(transactionService.updateTransaction(id, providedTransaction));
    }

}
