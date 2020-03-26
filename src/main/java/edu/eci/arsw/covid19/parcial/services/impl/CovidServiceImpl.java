package edu.eci.arsw.covid19.parcial.services.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import edu.eci.arsw.covid19.parcial.connection.Conexion;
import edu.eci.arsw.covid19.parcial.model.Status;
import edu.eci.arsw.covid19.parcial.model.covid19Stats;
import edu.eci.arsw.covid19.parcial.services.CovidService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class CovidServiceImpl implements CovidService {


    private final Conexion conexion;

    private Gson gson;

    public CovidServiceImpl(Conexion conexion) {
        this.conexion = conexion;
    }

    public Status getProvincesFromApi() throws IOException {

        String data = conexion.getConnection();
        Status status = gson.fromJson(data, Status.class);
        System.out.println("hola");

        return status;
    }
}
