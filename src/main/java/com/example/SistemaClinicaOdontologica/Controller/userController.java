package com.example.SistemaClinicaOdontologica.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class userController {
    @GetMapping("/")
    public String home(){
        return "Bienvenido";
    }
    @GetMapping("/User")
    public String user(){
        return "Bienvenido User";
    }
    @GetMapping("/Admin")
    public String admin(){
        return "Bienvenido Admin";
    }
}
