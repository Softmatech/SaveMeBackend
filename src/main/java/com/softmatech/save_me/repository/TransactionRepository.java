package com.softmatech.save_me.repository;

import com.softmatech.save_me.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransactionRepository extends JpaRepository<Transaction, UUID> {
    Transaction findByAccountId(UUID id);
}
