package com.fernoaga.weather_service.adapter.outbound.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fernoaga.weather_service.domain.model.CityTemperature;

public interface CityTemperatureRepository extends JpaRepository<CityTemperature, Long> {
}
