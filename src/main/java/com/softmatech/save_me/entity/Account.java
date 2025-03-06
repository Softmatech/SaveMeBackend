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

private AccountType accountType;

private Currency currency;

private LocalTime dateCreated = LocalTime.now();

}
