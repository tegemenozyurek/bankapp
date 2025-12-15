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
    public List<Transactions> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @GetMapping(path = "{id}")
    public Transactions getTransactionById(@PathVariable int id) {return transactionService.getTransactionById(id);}

    @PostMapping
    public Transactions saveTransaction(@RequestBody Transactions transaction) {return transactionService.saveTransaction(transaction);}

    @PutMapping("/updateTransaction/{id}")
    public Transactions updateTransaction(@PathVariable Integer id, @RequestBody Transactions transaction) {
        transaction.setId(id);
        return transactionService.updateTransaction(transaction);
    }

    @DeleteMapping(path = "{id}")
    public void deleteTransaction(@PathVariable int id) {transactionService.deleteTransaction(id);}

}