package com.example.bank.Controllers;

import com.example.bank.Entities.Accounts;
import com.example.bank.Services.WithdrawService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/withdraw")
public class WithdrawController {
    public WithdrawService withdrawService;

    public WithdrawController(WithdrawService withdrawService) {
        this.withdrawService = withdrawService;
    }

    @PostMapping("/{id}/{amount}")
    public Accounts withdraw(@PathVariable Integer id, @PathVariable double amount){
        return withdrawService.withdraw(id, amount);
    }
}

