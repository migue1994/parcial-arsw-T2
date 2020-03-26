package edu.eci.arsw.covid19.parcial.cache.impl;

import edu.eci.arsw.covid19.parcial.cache.CacheService;
import edu.eci.arsw.covid19.parcial.model.Status;
import org.springframework.stereotype.Service;

@Service
public class CacheServiceImpl implements CacheService {

    private Status status;

    @Override
    public void saveStatus(Status status) {
        this.status = status;
    }

    @Override
    public Status getStatus() {
        return this.status;
    }
}

