package com.example.springCache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class CountryService {

    @Autowired
    private CountryDAO countryDAO;

    @Cacheable(value = "countries")
    public String getCountry(int id){
        simulateSlowService();
        System.out.println("...");
        return countryDAO.getCountries().get(id).getName();
    }

    private void simulateSlowService() {
        try {
            long time = 3000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
