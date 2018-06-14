package com.huseyinkarabakla.n26.controller;

import com.huseyinkarabakla.n26.mapper.StatisticsToStatisticsResourceMapper;
import com.huseyinkarabakla.n26.resources.StatisticsResource;
import com.huseyinkarabakla.n26.service.StatisticsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/statistics")
public class StatisticsController
{
    private final StatisticsService statisticsService;


    public StatisticsController(final StatisticsService statisticsService)
    {
        this.statisticsService = statisticsService;
    }


    @GetMapping
    public ResponseEntity<StatisticsResource> getStatistics()
    {
        return ResponseEntity.status(HttpStatus.OK).body(StatisticsToStatisticsResourceMapper.getResource(statisticsService.getStatistics()));
    }
}
