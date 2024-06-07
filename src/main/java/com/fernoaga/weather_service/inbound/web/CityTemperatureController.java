package com.fernoaga.weather_service.inbound.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fernoaga.weather_service.dto.PagedTemperaturesDto;
import com.fernoaga.weather_service.model.SortType;
import com.fernoaga.weather_service.service.CityTemperatureService;
import com.fernoaga.weather_service.service.WeatherDataLoaderService;

@RestController
@RequestMapping("/api/city-temperatures")
public class CityTemperatureController {

    @Autowired
    private CityTemperatureService cityTemperatureService;

    @Autowired
    private WeatherDataLoaderService weatherDataLoaderService;

    @GetMapping
    public PagedTemperaturesDto getAllTemperatures(@RequestParam int page, @RequestParam int size, @RequestParam String sortType) {
        return cityTemperatureService.getAllTemperatures(validatePage(page), validateSize(size), toSortType(sortType));
    }

    @PostMapping("/refresh")
    public void refreshData() {
        this.weatherDataLoaderService.updateCitesTemperature();
    }

    @DeleteMapping
    public void deleteAllTemperatures() {
      cityTemperatureService.deleteAllData();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    private int validatePage(int page) {
        if (page >= 0) {
            return page;
        } else {
            throw new IllegalArgumentException("Invalid page " + page);
        }
    }

    private int validateSize(int size) {
        if (size > 0) {
            return size;
        } else {
            throw new IllegalArgumentException("Invalid size " + size);
        }
    }

    private SortType toSortType(String sortType) {
        try {
            return SortType.valueOf(sortType);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid sortType " + sortType);
        }
    }
}
