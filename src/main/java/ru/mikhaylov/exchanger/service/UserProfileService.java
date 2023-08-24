package ru.mikhaylov.exchanger.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mikhaylov.exchanger.security.JwtUtilities;
import ru.mikhaylov.exchanger.dto.BearerToken;
import ru.mikhaylov.exchanger.dto.LoginDto;
import ru.mikhaylov.exchanger.dto.RegisterDto;
import ru.mikhaylov.exchanger.repository.UserProfileRepository;
import ru.mikhaylov.exchanger.entity.UserProfile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserProfileService {

    private final UserProfileRepository userProfileRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtilities jwtUtilities;
    private final AuthenticationManager authenticationManager;

    public UserProfile getUserByLogin(String userName) {
        return userProfileRepository.findByLogin(userName).orElseThrow(
                () -> new UsernameNotFoundException("User not found"));
    }

    public ResponseEntity<?> register(RegisterDto registerDto) {
        if (userProfileRepository.existsByLogin(registerDto.getEmail())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("email is already taken !");
        }

        UserProfile user = new UserProfile();
        user.setLogin(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        userProfileRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User created");
    }

    public String authenticate(LoginDto loginDto) {
        UserProfile user = userProfileRepository.findByLogin(loginDto.getEmail()).orElseThrow(
                () -> new UsernameNotFoundException("User not found"));

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getEmail(),
                        loginDto.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return jwtUtilities.generateToken(user.getLogin());
    }
}
