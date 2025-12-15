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

    public Transactions updateTransaction(Transactions transaction) {
        Transactions existing = transactionRepository.findById(transaction.getId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (transaction.getFrom_account_id() != null) existing.setFrom_account_id(transaction.getFrom_account_id());
        if (transaction.getTo_account_id() != null) existing.setTo_account_id(transaction.getTo_account_id());
        if (transaction.getType() != null) existing.setType(transaction.getType());
        if (transaction.getAmount() != null) existing.setAmount(transaction.getAmount());
        if (transaction.getDescription() != null) existing.setDescription(transaction.getDescription());

        return transactionRepository.save(existing);
    }

    public void deleteTransaction(int id){
         transactionRepository.deleteById(id);
    }

}
