package com.example.SistemaClinicaOdontologica.Service;

import com.example.SistemaClinicaOdontologica.DTO.PacienteDTO;
import com.example.SistemaClinicaOdontologica.Entity.Paciente;

import java.util.List;
import java.util.Optional;

public interface IPacienteService {
    List<Paciente> findAllPacientes();
    Optional<Paciente> findPacientesById(Long id);
    Paciente savePaciente (PacienteDTO pacienteNuevo);
    String updatePaciente(PacienteDTO pacientenuevo);
    public String DeletePaciente(Long id);
}
