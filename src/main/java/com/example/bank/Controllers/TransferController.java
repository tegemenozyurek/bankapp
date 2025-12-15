package com.example.bank.Controllers;

import com.example.bank.Services.TransferService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transfer")
public class TransferController {
    public TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping("/from/{from_account_id}/to/{to_account_id}/amount/{amount}")
    public void transfer(@PathVariable Integer from_account_id, @PathVariable Integer to_account_id, @PathVariable Double amount){
        transferService.transfer(from_account_id, to_account_id, amount);
    }
}
