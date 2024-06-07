package com.fernoaga.weather_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.fernoaga.weather_service.dto.CityTemperatureDto;
import com.fernoaga.weather_service.dto.PagedTemperaturesDto;
import com.fernoaga.weather_service.model.CityTemperature;
import com.fernoaga.weather_service.model.SortType;
import com.fernoaga.weather_service.outbound.outbound.repository.CityTemperatureRepository;

@Service
public class CityTemperatureService {

    @Autowired
    private CityTemperatureRepository repository;

    public PagedTemperaturesDto getAllTemperatures(int page, int size, SortType sortType) {

        Page<CityTemperature> cityTemperaturePage = repository.findAll(PageRequest.of(page, size, toSort(sortType)));

        List<CityTemperatureDto> pageContent = cityTemperaturePage.stream()
          .map(cityTemp -> new CityTemperatureDto(cityTemp.getCityName(), cityTemp.getTemperature()))
          .toList();

        return new PagedTemperaturesDto(pageContent, page, size, cityTemperaturePage.getTotalElements(), cityTemperaturePage.getTotalPages());
    }

    public void deleteAllData() {
        repository.deleteAll();
    }

    private Sort toSort(SortType sortType) {
        var byCityName = Sort.by("cityName");
        return switch (sortType) {
            case NAME_ASC -> byCityName.ascending();
            case NAME_DESC -> byCityName.descending();
            default -> byCityName.ascending();
        };
    }
}
