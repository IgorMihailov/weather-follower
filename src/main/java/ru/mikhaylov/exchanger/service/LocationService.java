package ru.mikhaylov.exchanger.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import ru.mikhaylov.exchanger.entity.Location;
import ru.mikhaylov.exchanger.entity.UserProfile;
import ru.mikhaylov.exchanger.repository.LocationRepository;

import java.util.Optional;

@Service
public class LocationService {

    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }


    public Location addLocationToUser(Location location, UserProfile userProfile) {
        location.getUserProfiles().add(userProfile);
        locationRepository.save(location);
        return location;
    }

    public Location findByName(String locationName) {
        return locationRepository.findByName(locationName).orElseThrow(
                () -> new EntityNotFoundException("Location with name " + locationName + " not found."));
    }

}
