package com.example.bank.Services;

import com.example.bank.Entities.Accounts;
import com.example.bank.Entities.Transactions;
import com.example.bank.Repositories.AccountsRepository;
import com.example.bank.Repositories.TransactionRepository;
import org.springframework.stereotype.Service;

@Service
public class WithdrawService {
    private final AccountsRepository accountRepository;
    private final TransactionRepository transactionRepository;

    public WithdrawService(AccountsRepository accountRepository, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    public Accounts withdraw(Integer id, double amount){
        Accounts account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account not found"));
        transactionRepository.save(new Transactions(id, null, "WITHDRAW", amount, "ivj"));
        account.setBalance(account.getBalance() - amount);
        return accountRepository.save(account);
    }
}
