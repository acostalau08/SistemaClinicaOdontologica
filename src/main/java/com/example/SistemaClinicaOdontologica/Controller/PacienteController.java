package com.example.SistemaClinicaOdontologica.Controller;

import com.example.SistemaClinicaOdontologica.DTO.PacienteDTO;
import com.example.SistemaClinicaOdontologica.Entity.Odontologo;
import com.example.SistemaClinicaOdontologica.Entity.Paciente;
import com.example.SistemaClinicaOdontologica.Service.impl.PacienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    PacienteServiceImpl PacienteService;

    @RequestMapping("/all")
    public List<Paciente> getPaciente() {
        return PacienteService.findAllPacientes();

    }

    @GetMapping("/{id}")
    public Optional<Paciente> getPacienteById(@PathVariable Long id){
        return PacienteService.findPacientesById(id);

    }
    @PostMapping("/save")
    public Paciente guardarPaciente(PacienteDTO pacienteDTO){
        return PacienteService.savePaciente(pacienteDTO);
    }
    @PutMapping("/Update")
    public String updatePaciente(PacienteDTO pacienteDTO){
        return PacienteService.updatePaciente(pacienteDTO);
    }

    @DeleteMapping ("/Delete/{id}")
    public String deletePaciente(@PathVariable Long id){
        return PacienteService.DeletePaciente(id);
    }



}
