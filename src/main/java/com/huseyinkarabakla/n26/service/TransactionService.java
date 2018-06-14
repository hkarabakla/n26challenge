package com.huseyinkarabakla.n26.service;

import com.huseyinkarabakla.n26.model.Transaction;
import com.huseyinkarabakla.n26.storage.Storage;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TransactionService
{
    private final Storage storage;


    public TransactionService(final Storage storage)
    {
        this.storage = storage;
    }


    public void saveTransaction(Transaction transaction)
    {
        if (transaction.getTimestamp() >= new Date().getTime() - 60000)
        {
            storage.saveTransaction(transaction);
        }
    }
}
