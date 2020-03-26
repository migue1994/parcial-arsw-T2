package edu.eci.arsw.covid19.parcial.services.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import edu.eci.arsw.covid19.parcial.model.CovidStats;
import edu.eci.arsw.covid19.parcial.model.Status;
import edu.eci.arsw.covid19.parcial.services.CovidService;
import org.springframework.stereotype.Service;

import static java.util.stream.Collectors.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class CovidServiceImpl implements CovidService {

    private Gson gson = new GsonBuilder().create();

    public List<CovidStats> getProvincesFromApi() throws IOException {
        Status s = getAll();
        List<CovidStats> countries = s.getData().getCovid19Stats();
        return countries;

    }

    public List<CovidStats> getByCountries(String countr){
        Status s = getAll();
        List<CovidStats> allCountries = s.getData().getCovid19Stats();
        Map<String, List<CovidStats>> country = allCountries.stream().collect(groupingBy(CovidStats::getCountry));
        return country.get(countr);
    }

    private Status getAll(){
        String url = "https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/stats";
        StringBuilder apiUrl = new StringBuilder();
        apiUrl.append(url);
        HttpResponse<String> apiResponse = null;
        try {
            apiResponse = Unirest.get(apiUrl.toString())
                    .header("x-rapidapi-host", "covid-19-coronavirus-statistics.p.rapidapi.com")
                    .header("x-rapidapi-key", "5e6848da64msh2ec50afdafc1d85p141a5cjsnf9238ee9a445")
                    .asString();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        Status status = null;
        status = gson.fromJson(apiResponse.getBody(), new TypeToken<Status>() {}.getType());
        return status;
    }
}
