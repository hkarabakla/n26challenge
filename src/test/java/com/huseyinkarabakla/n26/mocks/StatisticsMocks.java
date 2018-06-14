package com.huseyinkarabakla.n26.mocks;

import com.huseyinkarabakla.n26.constants.TestConstants;
import com.huseyinkarabakla.n26.model.Statistics;

import java.util.Date;

public class StatisticsMocks
{
    public static Statistics getStatisticsMock()
    {
        Statistics statistics = new Statistics();
        statistics.accept(TestConstants.AMOUNT_ONE, new Date().getTime());
        statistics.accept(TestConstants.AMOUNT_TWO, new Date().getTime());
        statistics.accept(TestConstants.AMOUNT_THREE, new Date().getTime());
        statistics.accept(TestConstants.AMOUNT_FOUR, new Date().getTime());
        statistics.accept(TestConstants.AMOUNT_FIVE, new Date().getTime());
        return statistics;
    }


    private StatisticsMocks()
    {
    }
}
