package ru.mikhaylov.exchanger.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mikhaylov.exchanger.dto.WeatherRequestDto;
import ru.mikhaylov.exchanger.dto.WeatherResponseDto;
import ru.mikhaylov.exchanger.entity.Location;
import ru.mikhaylov.exchanger.entity.UserProfile;
import ru.mikhaylov.exchanger.service.LocationService;
import ru.mikhaylov.exchanger.service.UserProfileService;
import ru.mikhaylov.exchanger.service.WeatherService;

import java.security.Principal;
import java.util.Optional;

@RestController
@RequestMapping("/location")
public class LocationController {

    private final WeatherService weatherService;
    private final LocationService locationService;
    private final UserProfileService profileService;

    public LocationController(WeatherService weatherService, LocationService locationService, UserProfileService profileService) {
        this.weatherService = weatherService;
        this.locationService = locationService;
        this.profileService = profileService;
    }

    @PostMapping
    public WeatherResponseDto subscribeToLocation(@RequestBody WeatherRequestDto requestDto,
                                                  Principal principal) {
        UserProfile currentUser = profileService.getUserByLogin(principal.getName());
        Location location = locationService.findByName(requestDto.getCityName());

        locationService.addLocationToUser(location, currentUser);

        return weatherService.getWeatherByCityName(requestDto.getCityName());
    }

    @GetMapping
    public String getCurrentUserLocations() {
        return weatherService.getWeatherByCityName("Moscow").getName();
    }

}
