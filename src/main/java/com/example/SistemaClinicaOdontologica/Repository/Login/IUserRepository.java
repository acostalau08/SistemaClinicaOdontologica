package com.example.SistemaClinicaOdontologica.Repository.Login;

import com.example.SistemaClinicaOdontologica.Entity.Login.appUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface IUserRepository extends JpaRepository<appUser, Long> {

    Optional<appUser> findByEmail(String email);
}
