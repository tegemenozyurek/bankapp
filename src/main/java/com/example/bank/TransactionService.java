package com.example.bank;

import java.util.List;

public class TransactionService {
    private TransactionRepository transactionRepository;

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
