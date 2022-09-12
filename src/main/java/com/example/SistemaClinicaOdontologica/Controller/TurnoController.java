package com.example.SistemaClinicaOdontologica.Controller;

import com.example.SistemaClinicaOdontologica.DTO.TurnoDTO;
import com.example.SistemaClinicaOdontologica.Service.impl.TurnoServiceImpl;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/Turno")
public class TurnoController {

    @Autowired
    TurnoServiceImpl turnoService;

    @RequestMapping("/all")
    public ResponseEntity<Collection<TurnoDTO>> getTurnos(){
        return ResponseEntity.ok(turnoService.findAllTurnos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTurno(@PathVariable Long id){
        TurnoDTO turnoDTO = turnoService.findTurnosById(id);
        return ResponseEntity.ok(turnoDTO);
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveTurno(@RequestBody TurnoDTO turnoDTO){
        turnoService.saveTurno(turnoDTO);
        return ResponseEntity.ok("Turno creado exitosamente");
    }
    @PutMapping ("/update")
    public ResponseEntity<?> updateTurno(@RequestBody TurnoDTO turnoDTO){
        ResponseEntity <String> response;
        if (turnoService.findTurnosById(turnoDTO.getId()) != null){
            turnoService.updateTurno(turnoDTO);
            response = ResponseEntity.ok("Actualización de Turno");
        }else
        {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return response;
    }


}
