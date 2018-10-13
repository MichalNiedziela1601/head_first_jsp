package org.webapp.beerapp.repository;

import org.webapp.beerapp.model.Beer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryBeerRepository implements BeerRepository {
    private Map<Long, Beer> storage = new ConcurrentHashMap<>();


    @Override
    public List<Beer> findAll() {
        List<Beer> beers = new ArrayList<>();
        for(Map.Entry<Long, Beer> entry : storage.entrySet()){
            beers.add(entry.getValue());
        }
        return beers;
    }

    @Override
    public void save(Beer beer) {
        storage.put(beer.getId(),beer);

    }

    @Override
    public Optional<Beer> findById(long id) {
        if(id <= 0) {
            throw new IllegalArgumentException("Reference id need to be positive");
        }
        return Optional.ofNullable(storage.get(id));
    }
}
