package edu.eci.arsw.covid19.parcial.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Datos {
    private String lastChecked;
    private Set<covid19Stats> covid19Stats;
}
