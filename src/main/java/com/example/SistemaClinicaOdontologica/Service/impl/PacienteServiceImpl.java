package com.example.SistemaClinicaOdontologica.Service.impl;

import com.example.SistemaClinicaOdontologica.DTO.PacienteDTO;
import com.example.SistemaClinicaOdontologica.Entity.Paciente;
import com.example.SistemaClinicaOdontologica.Repository.IPacienteRepository;
import com.example.SistemaClinicaOdontologica.Service.IPacienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteServiceImpl implements IPacienteService{
    @Autowired
    IPacienteRepository PacienteRepository;

    @Autowired
    ObjectMapper mapper;
    @Override
    public List<Paciente> findAllPacientes() {
        return PacienteRepository.findAll();
    }

    @Override
    public Optional<Paciente> findPacientesById(Long id) {
        return PacienteRepository.findById(id);
    }

    @Override
    public Paciente savePaciente(PacienteDTO pacienteNuevo) {
        if(pacienteNuevo != null){
            Paciente paciente = mapper.convertValue(pacienteNuevo,Paciente.class);
            PacienteRepository.save(paciente);
        }
        return null;
    }

    @Override
    public String updatePaciente(PacienteDTO pacientenuevo) {
        if (pacientenuevo != null){
            Paciente paciente = mapper.convertValue(pacientenuevo, Paciente.class);
            PacienteRepository.save(paciente);
        }
        return null;
    }

    @Override
    public String DeletePaciente(Long id) {
 if(PacienteRepository.findById(id).isPresent()){
     PacienteRepository.deleteById(id);
     return "Paciente con ID:" + id + "ha sido eliminado";
 }   return "Paciente con Id:" + id + "No Existe";
    }
}
