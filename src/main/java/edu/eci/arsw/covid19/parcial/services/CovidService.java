package edu.eci.arsw.covid19.parcial.services;

import edu.eci.arsw.covid19.parcial.model.Status;
import edu.eci.arsw.covid19.parcial.model.covid19Stats;

import java.io.IOException;
import java.util.List;

public interface CovidService {
    Status getProvincesFromApi() throws IOException;
}
