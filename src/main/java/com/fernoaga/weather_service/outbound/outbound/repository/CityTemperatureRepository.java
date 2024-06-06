package com.fernoaga.weather_service.outbound.outbound.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fernoaga.weather_service.model.CityTemperature;

public interface CityTemperatureRepository extends JpaRepository<CityTemperature, Long> {
}
