package com.softmatech.save_me.controller;


import com.softmatech.save_me.entity.Account;
import com.softmatech.save_me.entity.Person;
import com.softmatech.save_me.service.AccountService;
import com.softmatech.save_me.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public Account createAccount(@RequestBody Account account) {
        return accountService.createAccount(account);
    }

    @GetMapping
    public List<Account> getAccounts(){
        return accountService.getAllAccounts();
    }

    @GetMapping("{id}")
    public Optional<Account> getAccountById(@PathVariable("id")UUID id){
        return accountService.getAccountById(id);
    }

    @PutMapping("{id}")
    public Optional<Account> updateAccountById(@PathVariable("id")UUID id, @RequestBody Account providedAccount){
        return Optional.ofNullable(accountService.updateAccount(id, providedAccount));
    }

}
