package com.huseyinkarabakla.n26.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.huseyinkarabakla.n26.mocks.StatisticsMocks;
import com.huseyinkarabakla.n26.model.Statistics;
import com.huseyinkarabakla.n26.service.StatisticsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(StatisticsController.class)
public class StatisticsControllerTests
{
    private final String rootMapping = "/statistics";

    @MockBean
    private StatisticsService statisticsServiceMock;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    public void getStatistics() throws Exception
    {
        // GIVEN
        Statistics statisticsMock = StatisticsMocks.getStatisticsMock();
        when(statisticsServiceMock.getStatistics()).thenReturn(statisticsMock);

        // WHEN
        mockMvc.perform(get(rootMapping))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.sum", is(statisticsMock.getSum())))
            .andExpect(jsonPath("$.avg", is(statisticsMock.getAverage())))
            .andExpect(jsonPath("$.max", is(statisticsMock.getMax())))
            .andExpect(jsonPath("$.min", is(statisticsMock.getMin())))
            .andExpect(jsonPath("$.count", is((int) statisticsMock.getCount())));

        // THEN
        verify(statisticsServiceMock).getStatistics();
    }

}
