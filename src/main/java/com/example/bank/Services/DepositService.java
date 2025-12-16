package com.example.bank.Services;

import com.example.bank.Entities.Accounts;
import com.example.bank.Entities.Transactions;
import com.example.bank.Repositories.AccountsRepository;
import com.example.bank.Repositories.TransactionRepository;
import org.springframework.stereotype.Service;

@Service
public class DepositService {

    private final AccountsRepository accountsRepository;
    private TransactionRepository transactionRepository;

    public DepositService(AccountsRepository accountsRepository, TransactionRepository transactionRepository) {
        this.accountsRepository = accountsRepository;
        this.transactionRepository = transactionRepository;
    }

    public Accounts deposit(Integer id, Double amount) {
        Accounts account = accountsRepository.findById(id).
                orElseThrow(() -> new IllegalStateException("Not Found"));
        transactionRepository.save(new Transactions(null, id, "DEPOSIT", amount, "test"));
        account.setBalance(account.getBalance() + amount);
        return accountsRepository.save(account);
    }
}
