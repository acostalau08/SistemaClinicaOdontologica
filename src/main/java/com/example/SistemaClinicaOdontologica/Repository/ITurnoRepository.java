package com.example.SistemaClinicaOdontologica.Repository;

import com.example.SistemaClinicaOdontologica.Entity.Turno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITurnoRepository extends JpaRepository<Turno, Long> {
}
