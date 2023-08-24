package ru.mikhaylov.exchanger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableFeignClients
public class ExchangerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExchangerApplication.class, args);
    }

}
