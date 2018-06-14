package com.huseyinkarabakla.n26.controller;

import com.huseyinkarabakla.n26.model.Transaction;
import com.huseyinkarabakla.n26.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<Void> saveTransaction(@RequestBody Transaction transaction)
    {
        boolean saveTransaction = transactionService.saveTransaction(transaction);
        if (!saveTransaction)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
