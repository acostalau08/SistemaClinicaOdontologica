package com.example.SistemaClinicaOdontologica.Service.impl;

import com.example.SistemaClinicaOdontologica.DTO.OdontologoDTO;
import com.example.SistemaClinicaOdontologica.Entity.Odontologo;
import com.example.SistemaClinicaOdontologica.Repository.IOdontologoRepository;
import com.example.SistemaClinicaOdontologica.Service.IOdontologoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoServiceImpl implements IOdontologoService {
    @Autowired
    IOdontologoRepository OdontologoRepository;
    @Autowired
    ObjectMapper mapper;
    @Override
    public List<Odontologo> findAllOdontologos() {
        return OdontologoRepository.findAll();
    }

    @Override
    public Optional<Odontologo> findOdontologoById(Long id) {
        return OdontologoRepository.findById(id);
    }

    @Override
    public void saveOdontologo(OdontologoDTO newOdontologo) {
        if(newOdontologo != null){
            Odontologo odontologo = mapper.convertValue(newOdontologo, Odontologo.class);
            OdontologoRepository.save(odontologo);
        }

    }

    @Override
    public void updateOdontologo(OdontologoDTO newOdontologo) {
        if(newOdontologo != null){
            Odontologo odontologo = mapper.convertValue(newOdontologo, Odontologo.class);
            OdontologoRepository.save(odontologo);
        }
    }

    @Override
    public void DeleteOdontologo(Long id) {
    if(OdontologoRepository.findById(id).isPresent()){
        OdontologoRepository.deleteById(id);

    }
    }
}
