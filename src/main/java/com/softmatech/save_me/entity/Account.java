package com.softmatech.save_me.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account extends AbstractEntity implements Cloneable{

@ManyToOne
@JoinColumn(name = "person_id")
private Person person;

@NotNull
private String accountName;

private double accountBalance = 0.00;

@NotNull
private AccountType accountType;

@NotNull
private Currency currency;

@NotNull
private LocalTime dateCreated = LocalTime.now();

    public Account(Person person, String accountName, double accountBalance, AccountType accountType, Currency currency) {
        this.person = person;
        this.accountName = accountName;
        this.accountBalance = accountBalance;
        this.accountType = accountType;
        this.currency = currency;
    }
}
