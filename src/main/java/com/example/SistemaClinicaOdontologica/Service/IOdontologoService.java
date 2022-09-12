package com.example.SistemaClinicaOdontologica.Service;

import com.example.SistemaClinicaOdontologica.DTO.OdontologoDTO;
import com.example.SistemaClinicaOdontologica.Entity.Odontologo;

import java.util.List;
import java.util.Optional;

public interface IOdontologoService {
    List<Odontologo> findAllOdontologos();
    Optional<Odontologo> findOdontologoById(Long id);
    void saveOdontologo (OdontologoDTO newOdontologo);
    void updateOdontologo(OdontologoDTO newOdontologo);
    void DeleteOdontologo(Long id);


}
