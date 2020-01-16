package org.webapp.beerapp.domain;

import org.webapp.beerapp.model.Beer;
import org.webapp.beerapp.repository.BeerRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class BeerAdvice {

    private final BeerRepository beerRepository;

    public BeerAdvice(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    List<Beer> adviceGenre(String genre, String brewery) {
        List<Beer> allBeers = beerRepository.findAll();
        List<Beer> collect = allBeers.stream().filter(beer -> genre.equals(beer.getGenre()) && brewery.equals(beer.getBrewery()))
                .collect(Collectors.toList());
        if(collect.size() < 1) {
            throw new NoSuchElementException("Not found beer for this genre");
        }
        return collect;
    }
}
