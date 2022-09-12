package com.example.SistemaClinicaOdontologica.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TurnoDTO {
    private Long id;
    private PacienteDTO pacienteDTO;
    private OdontologoDTO odontologoDTO;
    private String date;

}
