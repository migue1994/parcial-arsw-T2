package edu.eci.arsw.covid19.parcial.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Status {
    private boolean error;
    private int statusCode;
    private String message;
    private Dato data;
}
