package edu.eci.arsw.covid19.parcial.services;

import edu.eci.arsw.covid19.parcial.model.Covid19Stats;
import edu.eci.arsw.covid19.parcial.model.Status;

import java.io.IOException;

public interface CovidService {
    Covid19Stats[] getProvincesFromApi() throws IOException;
}
