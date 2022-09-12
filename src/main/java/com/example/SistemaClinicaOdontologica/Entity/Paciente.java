package com.example.SistemaClinicaOdontologica.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Getter
@Setter
@Entity
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String Nombre;
    private String Apellido;
    private String DNI;
    private String FechaAlta;
    private String domicilio;



}
