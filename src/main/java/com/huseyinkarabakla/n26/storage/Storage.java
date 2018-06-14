package com.huseyinkarabakla.n26.storage;

import com.huseyinkarabakla.n26.model.Statistics;
import com.huseyinkarabakla.n26.model.Transaction;

public interface Storage
{
    void saveTransaction(Transaction transaction);

    Statistics getStatistics(long timestamp);
}
