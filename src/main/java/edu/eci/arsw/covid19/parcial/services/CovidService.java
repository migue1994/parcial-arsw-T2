package edu.eci.arsw.covid19.parcial.services;

import edu.eci.arsw.covid19.parcial.model.Status;

import java.io.IOException;

public interface CovidService {
    Status getProvincesFromApi() throws IOException;
}
