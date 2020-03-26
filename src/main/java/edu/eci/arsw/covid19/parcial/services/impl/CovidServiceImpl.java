package edu.eci.arsw.covid19.parcial.services.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import edu.eci.arsw.covid19.parcial.cache.CacheService;
import edu.eci.arsw.covid19.parcial.model.Country;
import edu.eci.arsw.covid19.parcial.model.CovidStats;
import edu.eci.arsw.covid19.parcial.model.Status;
import edu.eci.arsw.covid19.parcial.services.CovidService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

@Service
public class CovidServiceImpl implements CovidService {

    private final CacheService cacheService;

    private long currentTime = 0;
    private int minutes = 5;
    private long timeCache = minutes * 1000000000;

    private Gson gson = new GsonBuilder().create();

    public CovidServiceImpl(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    /**
     * Se encarga de realizar la consulta de todos los paises con su respectivos datos
     * @return Una lista con las estadisticas de todos los paises sin ordenar
     * @throws IOException IoException
     */
    public List<CovidStats> getProvincesFromApi() throws IOException {
        Status s = getAll();
        List<CovidStats> countries = s.getData().getCovid19Stats();
        return countries;

    }

    /**
     *
     * @param countr
     * @return
     */
    public List<CovidStats> getByCountries(String countr){
        Status s = getAll();
        List<CovidStats> allCountries = s.getData().getCovid19Stats();
        Map<String, List<CovidStats>> country = allCountries.stream().collect(groupingBy(CovidStats::getCountry));
        return country.get(countr);
    }

    public List<Country> getSumaryByCountry(){
        Status s = getAll();
        List<CovidStats> allCountries = s.getData().getCovid19Stats();
        List<Country> results = new ArrayList<>();
        Map<String, List<CovidStats>> country = allCountries.stream().collect(groupingBy(CovidStats::getCountry));
        for (String pais : country.keySet()){
            List<CovidStats> covidStats = country.get(pais);
            Country c = new Country();
            int numDeaths = 0;
            int numInfected = 0;
            int numCured = 0;
            c.setName(pais);
            for (CovidStats cs : covidStats){
                numCured += cs.getRecovered();
                numDeaths += cs.getDeaths();
                numInfected += cs.getConfirmed();
            }
            c.setNumCured(numCured);
            c.setNumDeaths(numDeaths);
            c.setNumInfected(numInfected);
            results.add(c);
        }
        return results;
    }

    private Status getAll(){
        if (System.nanoTime() - this.currentTime > this.timeCache){
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
            cacheService.saveStatus(status);
            return status;
        }else {
            return cacheService.getStatus();
        }
    }

}
