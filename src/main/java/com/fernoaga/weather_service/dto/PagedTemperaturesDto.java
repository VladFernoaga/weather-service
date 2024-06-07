package com.fernoaga.weather_service.dto;

import java.util.List;

public record PagedTemperaturesDto (List<CityTemperatureDto> content, int page, int size, long totalElements, int totalPages) {
}
