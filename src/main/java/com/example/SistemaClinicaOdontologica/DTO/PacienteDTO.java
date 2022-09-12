package com.example.SistemaClinicaOdontologica.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PacienteDTO {
    private Long id;
    private String Nombre;
    private String Apellido;
    private String DNI;
    private String FechaAlta;
    private String domicilio;
}
