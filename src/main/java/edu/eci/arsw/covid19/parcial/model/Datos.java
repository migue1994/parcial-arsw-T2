package edu.eci.arsw.covid19.parcial.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Datos {
    private List<Covid19Stats> covid19Stats;
}
