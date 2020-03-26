package edu.eci.arsw.covid19.parcial.services;

import edu.eci.arsw.covid19.parcial.model.Country;
import edu.eci.arsw.covid19.parcial.model.CovidStats;

import java.io.IOException;
import java.util.List;

public interface CovidService {
    List<CovidStats> getProvincesFromApi() throws IOException;
    List<CovidStats> getByCountries(String countr);
    List<Country> getSumaryByCountry();
}
