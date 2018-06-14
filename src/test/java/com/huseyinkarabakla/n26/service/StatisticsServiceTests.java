package com.huseyinkarabakla.n26.service;

import com.huseyinkarabakla.n26.storage.Storage;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
public class StatisticsServiceTests
{
    @MockBean
    private Storage storageMock;

    private StatisticsService underTest;


    @Before
    public void setUp()
    {
        underTest = new StatisticsService(storageMock);
    }


    @Test
    public void getStatistics()
    {
        // GIVEN

        // WHEN
        underTest.getStatistics();

        // THEN
        verify(storageMock).getStatistics(anyLong());
    }

}
