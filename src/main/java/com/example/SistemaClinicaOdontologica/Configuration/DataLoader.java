package com.example.SistemaClinicaOdontologica.Configuration;

import com.example.SistemaClinicaOdontologica.Entity.Login.appUser;
import com.example.SistemaClinicaOdontologica.Entity.Login.appUsuarioRoles;
import com.example.SistemaClinicaOdontologica.Repository.Login.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.persistence.Access;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    IUserRepository userRepository;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("password");
        String password2 = passwordEncoder.encode("password2");

        userRepository.save(new appUser("Laura", "Acosta", "laurada.acosta@gmail.com", "password", appUsuarioRoles.ROLE_ADMIN));
        userRepository.save(new appUser("Laura", "Acosta", "laurada.acosta@gmail.com", "password2", appUsuarioRoles.ROLE_USER));
    }
}
