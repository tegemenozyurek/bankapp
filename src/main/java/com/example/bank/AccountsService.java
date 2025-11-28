package com.example.bank;

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
        return accountRepository.save(account);
    }
}
