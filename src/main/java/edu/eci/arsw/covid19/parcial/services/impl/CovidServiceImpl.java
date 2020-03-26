package edu.eci.arsw.covid19.parcial.services.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import edu.eci.arsw.covid19.parcial.connection.Conexion;
import edu.eci.arsw.covid19.parcial.model.Covid19Stats;
import edu.eci.arsw.covid19.parcial.model.Status;
import edu.eci.arsw.covid19.parcial.services.CovidService;
import org.springframework.stereotype.Service;

import javax.swing.plaf.nimbus.State;
import java.io.IOException;

@Service
public class CovidServiceImpl implements CovidService {

    private Gson gson;
    
    public Status getProvincesFromApi() throws IOException {

//        System.out.println("hola");
//        String data = conexion.getConnection();
//        System.out.println("hola");
//        Status logs = gson.fromJson(data, Status.class);
//
//        return logs;
        String url = "https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/stats?country=Colombia";
        StringBuilder apiUrl = new StringBuilder();
        apiUrl.append(url);
        HttpResponse<String> apiResponse = null;
        try{
            apiResponse = Unirest.get(apiUrl.toString())
                    .header("x-rapidapi-host","cometari-airportsfinder-v1.p.rapidapi.com")
                    .header("x-rapidapi-key","5e6848da64msh2ec50afdafc1d85p141a5cjsnf9238ee9a445")
                    .asString();
        }catch (UnirestException e){
            e.printStackTrace();
        }
        Status status = null;
        status = gson.fromJson(apiResponse.getBody(),new TypeToken<Status>(){}.getType());
        return status;
    }
}
