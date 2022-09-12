package com.example.SistemaClinicaOdontologica.Service.impl;

import com.example.SistemaClinicaOdontologica.DTO.TurnoDTO;
import com.example.SistemaClinicaOdontologica.Entity.Odontologo;
import com.example.SistemaClinicaOdontologica.Entity.Paciente;
import com.example.SistemaClinicaOdontologica.Entity.Turno;
import com.example.SistemaClinicaOdontologica.Repository.IOdontologoRepository;
import com.example.SistemaClinicaOdontologica.Repository.IPacienteRepository;
import com.example.SistemaClinicaOdontologica.Repository.ITurnoRepository;
import com.example.SistemaClinicaOdontologica.Service.ITurnoService;
import com.example.SistemaClinicaOdontologica.exception.ResourceNotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TurnoServiceImpl implements ITurnoService {
    @Autowired
    ITurnoRepository turnoRepository;
    @Autowired
    IPacienteRepository pacienteRepository;
    @Autowired
    IOdontologoRepository odontologoRepository;
    @Autowired
    ObjectMapper mapper;

    @Override
    public Collection<TurnoDTO> findAllTurnos() {
        List<Turno> turnos = turnoRepository.findAll();
        Set<TurnoDTO> turnoDTO = new HashSet<>();

        for (Turno turno : turnos) {
            Long PacienteId = turno.getPaciente().getId();
            Paciente paciente = pacienteRepository.findById(turno.getPaciente().getId()).orElseThrow();
            Odontologo odontologo = odontologoRepository.findById(turno.getOdontologo().getId()).orElseThrow();

            if (paciente != null) {
                turno.setPaciente(paciente);
            }
            if (odontologo != null) {
                turno.setOdontologo(odontologo);
            }
            turnoDTO.add(mapper.convertValue(turno, TurnoDTO.class));
        }
        return turnoDTO;
    }

    @Override
    public TurnoDTO findTurnosById(Long id) {
        Optional<Turno> turno = turnoRepository.findById(id);
        TurnoDTO turnoDTO = null;
        turnoDTO = mapper.convertValue(turno, TurnoDTO.class);
        return turnoDTO;
    }

    @Override
    public Turno saveTurno(TurnoDTO turnonuevo) {
        Odontologo odontologo = odontologoRepository.findById(turnonuevo.getOdontologoDTO().getId()).orElseThrow();
        Paciente paciente = pacienteRepository.findById(turnonuevo.getPacienteDTO().getId()).orElseThrow();
        Turno turno = mapper.convertValue(turnonuevo, Turno.class);
        if (paciente != null) {
            turno.setPaciente(paciente);
        }
        if (odontologo != null) {
            turno.setOdontologo(odontologo);
        } else {
            throw new ResourceNotFoundException("Turn", "id", "id no encontrado: " + turno.getId());

        }
        return turnoRepository.save(turno);
    }

    @Override
    public void updateTurno(TurnoDTO turnonuevo) {
        Odontologo odontologo = odontologoRepository.findById(turnonuevo.getOdontologoDTO().getId()).orElseThrow();
        Paciente paciente = pacienteRepository.findById(turnonuevo.getPacienteDTO().getId()).orElseThrow();
        Turno turno = mapper.convertValue(turnonuevo, Turno.class);
        if (odontologo != null) {
            turno.setOdontologo(odontologo);
        }
        if (paciente != null) {
            turno.setPaciente(paciente);
        } else {
            throw new ResourceNotFoundException("turno", "id", "id no encontrado:" + turno.getId());
        }
         turnoRepository.save(turno);

    }


    @Override
    public String DeleteTurno(Long id) {

        Turno turno = turnoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Turno", "id", "id no encontrado: " +id));
            turnoRepository.deleteById(id);
        return "Paciente con ID:" + id + "ha sido eliminado";
    }
}
