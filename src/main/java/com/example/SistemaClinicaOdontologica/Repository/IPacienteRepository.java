package com.example.SistemaClinicaOdontologica.Repository;

import com.example.SistemaClinicaOdontologica.DTO.PacienteDTO;
import com.example.SistemaClinicaOdontologica.Entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPacienteRepository extends JpaRepository<Paciente,Long> {
}
