package com.huseyinkarabakla.n26.storage;

import com.huseyinkarabakla.n26.model.Statistics;
import com.huseyinkarabakla.n26.model.Transaction;

import java.util.stream.IntStream;

public class InMemoryStorage implements Storage
{
    private final int WINDOW_SIZE = 60 * 1000;
    private final int ARRAY_SIZE = 60 * 1000 * 2;
    private final Statistics[] statisticsArray = new Statistics[ARRAY_SIZE];
    private final Object LOCK = new Object();


    public InMemoryStorage()
    {
        IntStream.range(0, ARRAY_SIZE).forEach(index -> statisticsArray[index] = new Statistics());
    }


    @Override
    public void saveTransaction(Transaction transaction)
    {
        int startingIndex = (int) (transaction.getTimestamp() % WINDOW_SIZE);
        synchronized (LOCK)
        {
            IntStream.range(startingIndex, startingIndex + WINDOW_SIZE).forEachOrdered(index -> {
                Statistics statistics = statisticsArray[index];
                if (transaction.getTimestamp() > statistics.getLastTimestap())
                {
                    Statistics newStatistics = new Statistics();
                    newStatistics.accept(transaction.getAmount(), transaction.getTimestamp());
                    statisticsArray[index] = newStatistics;
                }
                else
                {
                    statistics.accept(transaction.getAmount(), transaction.getTimestamp());
                }
            });
        }
    }


    @Override
    public Statistics getStatistics(long timestamp)
    {
        int index = (int) (timestamp % WINDOW_SIZE) + WINDOW_SIZE;
        synchronized (LOCK)
        {
            if (statisticsArray[index].getLastTimestap() >= timestamp - ARRAY_SIZE)
            {
                return statisticsArray[index];
            }
            else
            {
                return new Statistics();
            }
        }
    }
}
