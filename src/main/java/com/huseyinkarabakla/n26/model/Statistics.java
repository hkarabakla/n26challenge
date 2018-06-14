package com.huseyinkarabakla.n26.model;

import java.util.DoubleSummaryStatistics;

public class Statistics extends DoubleSummaryStatistics
{
    private long lastTimestap;


    public long getLastTimestap()
    {
        return lastTimestap;
    }


    public void accept(double value, long timestamp)
    {
        super.accept(value);
        this.lastTimestap = Long.max(this.lastTimestap, timestamp);
    }
}
