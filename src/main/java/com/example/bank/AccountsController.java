package com.example.bank;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountsController {
    private final AccountsService accountService;

    public AccountsController(AccountsService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping("/all")
    public List<Accounts> getAllAccounts(){
        return accountService.getAllAccounts();
    }

    @RequestMapping("/{id}")
    public Accounts getAccountById(@PathVariable int id){
        return accountService.getAccountById(id);
    }

    @RequestMapping("/save")
    public Accounts saveAccount(Accounts account){
        return accountService.saveAccount(account);
    }

    @RequestMapping("/delete/{id}")
    public void deleteAccount(@PathVariable int id){
        accountService.deleteAccount(id);
    }
}
