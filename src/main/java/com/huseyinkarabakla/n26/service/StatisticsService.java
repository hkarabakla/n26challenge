package com.huseyinkarabakla.n26.service;

import com.huseyinkarabakla.n26.model.Statistics;
import com.huseyinkarabakla.n26.storage.Storage;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class StatisticsService
{
    private final Storage storage;


    public StatisticsService(final Storage storage)
    {
        this.storage = storage;
    }


    public Statistics getStatistics()
    {
        return storage.getStatistics(new Date().getTime());
    }
}
