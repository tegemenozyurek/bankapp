package com.example.bank.Controllers;

import com.example.bank.Entities.Transactions;
import com.example.bank.Services.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public List<Transactions> findAll() {
        return transactionService.findAll();
    }
}