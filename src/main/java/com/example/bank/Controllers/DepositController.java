package com.example.bank.Controllers;

import com.example.bank.Entities.Accounts;
import com.example.bank.Services.DepositService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/deposit")
public class DepositController {
    private final DepositService depositService;

    public DepositController(DepositService depositService) {
        this.depositService = depositService;
    }

    @PostMapping("/{id}/{amount}")
    public Accounts deposit(@PathVariable Integer id, @PathVariable Double amount){
        return depositService.deposit(id, amount);
    }

}
