package com.fernoaga.weather_service.inbound.job;

import static com.fernoaga.weather_service.config.Constants.DEFAULT_CITIES;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fernoaga.weather_service.service.WeatherDataLoaderService;


@Component
public class StartupDataLoader implements CommandLineRunner {

    @Autowired
    private WeatherDataLoaderService weatherDataLoaderService;

    @Override
    public void run(String... args) throws Exception {
        weatherDataLoaderService.loadCitiesWithCurrentWeatherData(DEFAULT_CITIES);
    }
}
