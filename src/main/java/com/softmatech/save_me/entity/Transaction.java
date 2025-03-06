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
public class Transaction  extends AbstractEntity implements Cloneable{

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @NotNull
    private TransactionType transactionType;

    @NotNull
    private double amount;

    @NotNull
    LocalTime transactionDate = LocalTime.now();

    private String description;

    public Transaction(Account account, TransactionType transactionType, double amount, String description) {
        this.account = account;
        this.transactionType = transactionType;
        this.amount = amount;
        this.description = description;
    }
}
