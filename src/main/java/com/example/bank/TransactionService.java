package com.example.bank;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transactions getTransactionById(Integer id) {
        return transactionRepository.findById(id).
                orElseThrow(() -> new IllegalStateException("Not Found"));
    }

    public List<Transactions> findAll() {
        return transactionRepository.findAll();
    }
}
