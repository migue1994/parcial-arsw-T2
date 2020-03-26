package edu.eci.arsw.covid19.parcial.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Covid19Stats {
    private String city;
    private String province;
    private String country;
    private String keyId;
    private long confirmed;
    private long deaths;
    private long recovered;

}
