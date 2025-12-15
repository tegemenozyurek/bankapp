package com.example.bank.Services;

import com.example.bank.Entities.Accounts;
import com.example.bank.Entities.Transactions;
import com.example.bank.Repositories.AccountsRepository;
import com.example.bank.Repositories.TransactionRepository;
import org.springframework.stereotype.Service;

@Service
public class TransferService {
    private final AccountsRepository accountRepository;
    private final TransactionRepository transactionRepository;

    public TransferService(AccountsRepository accountRepository, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    public void transfer(Integer from_account_id, Integer to_account_id, Double amount){
        Accounts fromAccount = accountRepository.findById(from_account_id).orElseThrow(() -> new RuntimeException("Account not found"));
        Accounts toAccount = accountRepository.findById(to_account_id).orElseThrow(() -> new RuntimeException("Account not found"));

        fromAccount.setBalance(fromAccount.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);

        transactionRepository.save(new Transactions(from_account_id, to_account_id, "TRANSFER", amount, amount + " transferred from " + from_account_id + " to " + to_account_id));

        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);
    }
}
