package com.fernoaga.weather_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class CityTemperature {

    @Id
    @GeneratedValue
    private Long id;
    private String cityName;
    private Double temperature;
}

