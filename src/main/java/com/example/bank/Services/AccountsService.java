package com.example.bank.Services;

import com.example.bank.Entities.Accounts;
import com.example.bank.Repositories.AccountsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountsService {
    private final AccountsRepository accountRepository;

    public AccountsService(AccountsRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Accounts> getAllAccounts(){
        return accountRepository.findAll();
    }

    public Accounts getAccountById(int id){
        return accountRepository.findById(id).orElse(null);
    }

    public Accounts saveAccount(Accounts account){
        return accountRepository.save(account);
    }

    public void deleteAccount(int id){
        accountRepository.deleteById(id);
    }

    public Accounts updateAccount(Accounts account){

        Accounts existing = accountRepository.findById(account.getId())
                .orElseThrow(() -> new RuntimeException("Account not found"));

        if (account.getUser_id() != null) existing.setUser_id(account.getUser_id());
        if (account.getIban() != null) existing.setIban(account.getIban());
        if (account.getAccount_number() != null) existing.setAccount_number(account.getAccount_number());
        if (account.getCurrency() != null) existing.setCurrency(account.getCurrency());
        if (account.getBalance() != null) existing.setBalance(account.getBalance());
        if (account.getStatus() != null) existing.setStatus(account.getStatus());
        if (account.getCreatedAt() != null) existing.setCreatedAt(account.getCreatedAt());

        return accountRepository.save(existing);
    }
}
