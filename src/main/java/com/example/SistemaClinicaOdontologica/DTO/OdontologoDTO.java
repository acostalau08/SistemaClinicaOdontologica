package com.example.SistemaClinicaOdontologica.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OdontologoDTO {
    private Long id;
    private String apellido;
    private String nombre;
    private int matricula;
}
