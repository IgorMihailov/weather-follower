package ru.mikhaylov.exchanger.dto;

import lombok.Data;
import java.io.Serializable;

@Data
public class RegisterDto implements Serializable {

    private String firstName;
    private String lastName;
    private String email;
    private String password;

}