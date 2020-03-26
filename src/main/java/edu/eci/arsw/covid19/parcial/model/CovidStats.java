package edu.eci.arsw.covid19.parcial.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CovidStats {
    private String city;
    private String province;
    private String country;
    private Integer confirmed;
    private Integer deaths;
    private Integer recovered;

}
