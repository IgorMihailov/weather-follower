package ru.mikhaylov.exchanger.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mikhaylov.exchanger.entity.UserProfile;

import java.security.Principal;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserProfileController {

    @PostMapping("/current")
    public String getCurrentUser(Principal principal) {
        if (principal == null) {
            return "not logged";
        }
        UserProfile profile = (UserProfile) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return profile.getLogin();
    }

}
