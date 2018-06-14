package com.huseyinkarabakla.n26.service;

import com.huseyinkarabakla.n26.constants.SystemConstants;
import com.huseyinkarabakla.n26.model.Transaction;
import com.huseyinkarabakla.n26.storage.Storage;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.TimeZone;

@Service
public class TransactionService
{
    private final Storage storage;


    public TransactionService(final Storage storage)
    {
        this.storage = storage;
    }


    public boolean saveTransaction(Transaction transaction)
    {
        if (transaction.getTimestamp() >= Calendar.getInstance(TimeZone.getTimeZone("UTC")).getTimeInMillis() - SystemConstants.MINUTE_IN_MILISECONDS
            && transaction.getTimestamp() < Calendar.getInstance(TimeZone.getTimeZone("UTC")).getTimeInMillis())
        {
            storage.saveTransaction(transaction);
            return true;
        }

        return false;
    }
}
