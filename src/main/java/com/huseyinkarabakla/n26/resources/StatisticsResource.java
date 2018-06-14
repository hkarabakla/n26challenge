package com.huseyinkarabakla.n26.resources;

public class StatisticsResource
{
    private double sum;
    private double avg;
    private double max;
    private double min;
    private double count;


    public StatisticsResource(double sum, double avg, double max, double min, double count)
    {
        this.sum = sum;
        this.avg = avg;
        this.max = max;
        this.min = min;
        this.count = count;
    }


    public double getSum()
    {
        return sum;
    }


    public double getAvg()
    {
        return avg;
    }


    public double getMax()
    {
        return max;
    }


    public double getMin()
    {
        return min;
    }


    public double getCount()
    {
        return count;
    }
}
