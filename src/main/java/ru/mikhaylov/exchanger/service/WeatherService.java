package ru.mikhaylov.exchanger.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.mikhaylov.exchanger.client.WeatherClient;
import ru.mikhaylov.exchanger.dto.WeatherResponseDto;

@Service
public class WeatherService {

    @Value("${weather.api.key}")
    private String apiKey;

    private final WeatherClient weatherClient;

    public WeatherService(WeatherClient weatherClient) {
        this.weatherClient = weatherClient;
    }

    public WeatherResponseDto getWeatherByCityName(String cityName) {
        return weatherClient.getWeatherByCityName(cityName, apiKey);
    }

}
