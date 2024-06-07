package com.fernoaga.weather_service.outbound.outbound.weatherdataprovider;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class WeatherDataFetchingService {
    private static final String OPEN_WEATHER_BASE_URL = "https://api.openweathermap.org/data/2.5/weather?";
    @Value("${openweathermap.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    public Double getTemperature(Integer cityId, String cityName) {
        try {
            String url = OPEN_WEATHER_BASE_URL + "id=" + cityId + "&appid=" + apiKey + "&units=metric";
            ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);
            Map<String, Object> body = response.getBody();
            Map<String, Object> main = (Map<String, Object>) body.get("main");
            return (Double) main.get("temp");
        } catch (Exception e) {
            log.error("Cannot retrieve temperature for cityName: " + cityName, e);
            return -9999d;
        }
    }
}
