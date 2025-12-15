package com.example.bank.Controllers;

import com.example.bank.Services.AccountsService;
import com.example.bank.Entities.Accounts;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountsController {
    private final AccountsService accountService;

    public AccountsController(AccountsService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/all")
    public List<Accounts> getAllAccounts(){
        return accountService.getAllAccounts();
    }

    @GetMapping("/{id}")
    public Accounts getAccountById(@PathVariable int id){
        return accountService.getAccountById(id);
    }

    @PostMapping("/save")
    public Accounts saveAccount(@RequestBody Accounts account){
        return accountService.saveAccount(account);
    }

    @PutMapping("/update/{id}")
    public Accounts updateAccount(@PathVariable Integer id, @RequestBody Accounts account){
        account.setId(id);
        return accountService.updateAccount(account);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAccount(@PathVariable int id){
        accountService.deleteAccount(id);
    }
}
