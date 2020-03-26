package edu.eci.arsw.covid19.parcial.controller;

import edu.eci.arsw.covid19.parcial.services.CovidService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/api")
public class RestController {

    private final CovidService covidService;

    public RestController(CovidService covidService) {
        this.covidService = covidService;
    }

    @GetMapping("/provinces")
    public ResponseEntity<?> getProvinces(){
        try {
            return new ResponseEntity<>(covidService.getProvincesFromApi(), HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>("No se encontraron registros", HttpStatus.NOT_FOUND);
        }
    }

}
