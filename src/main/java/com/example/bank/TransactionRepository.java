package com.example.bank;

import com.example.bank.TransactionService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transactions, Integer> {
}
