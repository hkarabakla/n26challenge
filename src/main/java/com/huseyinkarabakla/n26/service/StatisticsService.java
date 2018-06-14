package com.huseyinkarabakla.n26.service;

import com.huseyinkarabakla.n26.model.Statistics;
import com.huseyinkarabakla.n26.storage.Storage;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.TimeZone;

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
        return storage.getStatistics(Calendar.getInstance(TimeZone.getTimeZone("UTC")).getTimeInMillis());
    }
}
