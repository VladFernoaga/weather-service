package com.fernoaga.weather_service.inbound.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.fernoaga.weather_service.service.WeatherDataLoaderService;

@Component
public class TemperatureUpdateScheduler {

    @Autowired
    private WeatherDataLoaderService weatherDataLoaderService;

    @Scheduled(cron = "0 0 0 * * *") // Second, Minute, Hour, Day of month, Month, Day of week
    public void updateTemperaturesDaily() {
        weatherDataLoaderService.updateCitesTemperature();
    }
}
