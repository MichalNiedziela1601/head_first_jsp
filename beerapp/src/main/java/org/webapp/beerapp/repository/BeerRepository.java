package org.webapp.beerapp.repository;

import org.webapp.beerapp.model.Beer;

import java.util.List;
import java.util.Optional;

public interface BeerRepository {

    List<Beer> findAll();

    void save(Beer beer);

    Optional<Beer> findById(long id);
}
