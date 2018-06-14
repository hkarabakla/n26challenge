package com.huseyinkarabakla.n26.controller;

import com.huseyinkarabakla.n26.model.Transaction;
import com.huseyinkarabakla.n26.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
public class TransactionController
{
    private final TransactionService transactionService;


    public TransactionController(final TransactionService transactionService)
    {
        this.transactionService = transactionService;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveTransaction(@RequestBody Transaction transaction)
    {
        transactionService.saveTransaction(transaction);
    }
}
