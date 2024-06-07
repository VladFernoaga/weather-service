package com.fernoaga.weather_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class CityTemperature {

    @Id
    @GeneratedValue
    private Long id;
    private String cityName;
    private Double temperature;
    private int openWeatherId;

    public CityTemperature(String cityName, Double temperature, int openWeatherId) {
        this.cityName = cityName;
        this.temperature = temperature;
        this.openWeatherId = openWeatherId;
    }

}

