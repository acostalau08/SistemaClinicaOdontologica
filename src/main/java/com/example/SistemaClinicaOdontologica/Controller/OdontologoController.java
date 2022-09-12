package com.example.SistemaClinicaOdontologica.Controller;

import com.example.SistemaClinicaOdontologica.DTO.OdontologoDTO;
import com.example.SistemaClinicaOdontologica.Entity.Odontologo;
import com.example.SistemaClinicaOdontologica.Service.impl.OdontologoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Odontologo")
public class OdontologoController {
    @Autowired
    OdontologoServiceImpl OdontologoService;

    @RequestMapping( "/all")
        public List<Odontologo> getOdontologo(){
        return OdontologoService.findAllOdontologos();

    }
    @GetMapping("/{id}")
    public Optional<Odontologo> getOdontologoById(@PathVariable Long id){
    return OdontologoService.findOdontologoById(id);
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveOdontolgo( @RequestBody OdontologoDTO odontologoDTO){
        OdontologoService.saveOdontologo(odontologoDTO);
        return ResponseEntity.ok("Odontologo creado Exitosamente");
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateOdontologo(OdontologoDTO odontologoDTO) {
        ResponseEntity<String> response;
        if (OdontologoService.findOdontologoById(odontologoDTO.getId()) != null) {
           OdontologoService.updateOdontologo(odontologoDTO);
            response = ResponseEntity.ok("Odontologo Actualizado");
        } else {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return response;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteOdontologo(@PathVariable Long id) {
        ResponseEntity<String> response;
        if (OdontologoService.findOdontologoById(id) != null) {
           OdontologoService.DeleteOdontologo(id);
            response = ResponseEntity.ok("Odontologo Elimanod con id: " + id);
        } else {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return response;
    }




}
