package ru.mikhaylov.exchanger.repository;

import org.springframework.data.repository.CrudRepository;
import ru.mikhaylov.exchanger.entity.UserProfile;

import java.util.Optional;

public interface UserProfileRepository extends CrudRepository<UserProfile, Long> {

    Optional<UserProfile> findByLogin(String login);
    boolean existsByLogin(String login);

}