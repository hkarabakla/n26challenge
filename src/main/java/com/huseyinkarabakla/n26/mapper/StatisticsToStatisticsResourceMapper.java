package com.huseyinkarabakla.n26.mapper;

import com.huseyinkarabakla.n26.model.Statistics;
import com.huseyinkarabakla.n26.resources.StatisticsResource;

public class StatisticsToStatisticsResourceMapper
{
    public static StatisticsResource getResource(Statistics statistics)
    {
        return new StatisticsResource(statistics.getSum(), statistics.getAverage(), statistics.getMax(), statistics.getMin(), statistics.getCount());
    }
}
