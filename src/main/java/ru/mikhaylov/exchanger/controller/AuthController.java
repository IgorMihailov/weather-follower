package ru.mikhaylov.exchanger.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mikhaylov.exchanger.dto.LoginDto;
import ru.mikhaylov.exchanger.dto.RegisterDto;
import ru.mikhaylov.exchanger.service.UserProfileService;

@RestController
@RequestMapping(("/auth"))
@RequiredArgsConstructor
public class AuthController {

    private final UserProfileService userProfileService;

    @PostMapping("/register")
    public ResponseEntity<?> register (@RequestBody RegisterDto registerDto) {
        return userProfileService.register(registerDto);
    }

    @PostMapping("/authenticate")
    public String authenticate(@RequestBody LoginDto loginDto) {
        return userProfileService.authenticate(loginDto);
    }
}
