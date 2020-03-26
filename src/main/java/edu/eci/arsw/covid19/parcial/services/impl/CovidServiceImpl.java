package edu.eci.arsw.covid19.parcial.services.impl;

import com.google.gson.Gson;
import edu.eci.arsw.covid19.parcial.connection.Conexion;
import edu.eci.arsw.covid19.parcial.model.Covid19Stats;
import edu.eci.arsw.covid19.parcial.model.Status;
import edu.eci.arsw.covid19.parcial.services.CovidService;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CovidServiceImpl implements CovidService {


    private final Conexion conexion;

    private Gson gson;

    public CovidServiceImpl(Conexion conexion) {
        this.conexion = conexion;
    }

    public Covid19Stats[] getProvincesFromApi() throws IOException {

        System.out.println("hola");
        String data = conexion.getConnection();
        System.out.println("hola");
        Covid19Stats[] logs = gson.fromJson(data, Covid19Stats[].class);

        return logs;
    }
}
