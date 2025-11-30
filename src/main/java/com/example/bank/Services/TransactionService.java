package com.example.bank.Services;

import com.example.bank.Entities.Transactions;
import com.example.bank.Repositories.TransactionRepository;
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

    public List<Transactions> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Transactions saveTransaction(Transactions transaction) {
        return transactionRepository.save(transaction);
    }

    public void deleteTransaction(int id){
         transactionRepository.deleteById(id);
    }

}
