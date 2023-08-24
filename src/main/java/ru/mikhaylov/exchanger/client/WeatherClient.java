package ru.mikhaylov.exchanger.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mikhaylov.exchanger.dto.WeatherResponseDto;

@FeignClient(value = "jplaceholder", url = "https://api.openweathermap.org/data/2.5")
public interface WeatherClient {

    @RequestMapping(method = RequestMethod.GET, value = "/weather")
    WeatherResponseDto getWeatherByCityName(@RequestParam("q") String cityName, @RequestParam("appid") String apiKey);

}
