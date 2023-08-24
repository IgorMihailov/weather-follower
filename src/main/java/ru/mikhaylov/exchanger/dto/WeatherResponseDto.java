package ru.mikhaylov.exchanger.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherResponseDto {

    private String name;
    private Main main;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class Main {

        private String temp;

    }

}
