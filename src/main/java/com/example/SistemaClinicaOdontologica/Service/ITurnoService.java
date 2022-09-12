package com.example.SistemaClinicaOdontologica.Service;

import com.example.SistemaClinicaOdontologica.DTO.TurnoDTO;
import com.example.SistemaClinicaOdontologica.Entity.Turno;

import java.util.Collection;

public interface ITurnoService {
    Collection<TurnoDTO> findAllTurnos();
    TurnoDTO findTurnosById(Long id);
    Turno saveTurno (TurnoDTO turnonuevo);
    void updateTurno(TurnoDTO turnonuevo);
    public String DeleteTurno(Long id);
}
