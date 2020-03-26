package edu.eci.arsw.covid19.parcial.cache.impl;

import edu.eci.arsw.covid19.parcial.cache.CacheService;
import edu.eci.arsw.covid19.parcial.model.Status;
import org.springframework.stereotype.Service;

@Service
public class CacheServiceImpl implements CacheService {

    private Status status;

    /**
     * Permite consultar la información que hay en cache, siempre y cuando no hayan pasado 5 seg
     * @param status El objeto json que viene del api
     */
    @Override
    public void saveStatus(Status status) {
        this.status = status;
    }

    /**
     * Permite consultar el cache siempre y cuando no se haya pasado los 5 seg
     * @return el objeto json proveniente del api
     */
    @Override
    public Status getStatus() {
        return this.status;
    }
}

