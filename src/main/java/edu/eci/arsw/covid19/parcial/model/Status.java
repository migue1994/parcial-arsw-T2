package edu.eci.arsw.covid19.parcial.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Status {
    private boolean error;
    private String statusCode;
    private String message;
    private Datos data;
}
