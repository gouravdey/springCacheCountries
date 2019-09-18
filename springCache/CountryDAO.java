package com.example.springCache;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class CountryDAO {
    private Map<Integer, Country> countries = new HashMap<Integer, Country>();

    @PostConstruct
    void populateData() {
        Country c1 = new Country(1, "INDIA");
        Country c2 = new Country(2, "USA");
        Country c3 = new Country(3, "UK");

        countries.put(c1.getId(), c1);
        countries.put(c2.getId(), c2);
        countries.put(c3.getId(), c3);
    }

    public Map<Integer, Country> getCountries(){
        return countries;
    }
}
