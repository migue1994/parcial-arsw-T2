package edu.eci.arsw.covid19.parcial.controller;

import edu.eci.arsw.covid19.parcial.services.CovidService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class RestController {

    private final CovidService covidService;

    public RestController(CovidService covidService) {
        this.covidService = covidService;
    }

    @GetMapping("/allCountries")
    public ResponseEntity<?> getProvinces(){
        try {
            return new ResponseEntity<>(covidService.getProvincesFromApi(), HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>("No se encontraron registros", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/allCountries/{country}")
    public ResponseEntity<?> getStatsByCountry(@PathVariable String country){
        try {
            return new ResponseEntity<>(covidService.getByCountries(country), HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>("No se encontró el pais requerido", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/statistics")
    public ResponseEntity<?> getSumarizedStatistics(){
        try {
            return new ResponseEntity<>(covidService.getSumaryByCountry(), HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>("No fue posible",HttpStatus.NOT_FOUND);
        }
    }
}
