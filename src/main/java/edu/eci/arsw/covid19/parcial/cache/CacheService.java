package edu.eci.arsw.covid19.parcial.cache;

import edu.eci.arsw.covid19.parcial.model.Status;

public interface CacheService {
    void saveStatus(Status status);
    Status getStatus();
}
