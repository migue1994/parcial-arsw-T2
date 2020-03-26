package edu.eci.arsw.covid19.parcial.model;

import lombok.*;
import lombok.Data;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dato {
    private String lastChecked;
    private List<CovidStats> covid19Stats;
}
