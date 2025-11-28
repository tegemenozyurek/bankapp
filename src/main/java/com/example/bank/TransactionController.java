package com.example.bank;

import com.example.bank.TransactionService;
import com.example.bank.Transactions;
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