package ru.mikhaylov.exchanger.repository;

import org.springframework.data.repository.CrudRepository;
import ru.mikhaylov.exchanger.entity.Location;

import java.util.Optional;

public interface LocationRepository extends CrudRepository<Location, Long> {

    Optional<Location> findByName(String name);
}
