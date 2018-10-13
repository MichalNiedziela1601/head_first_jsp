package org.webapp.beerapp.domain;

import org.webapp.beerapp.model.Beer;

public class BeerAggregate {

    private Long id;
    private String brewery;
    private String name;
    private String genre;

    public BeerAggregate(Long id, String brewery, String name, String genre) {
        this.id = id;
        this.brewery = brewery;
        this.name = name;
        this.genre = genre;
    }

    public Long getId() {
        return id;
    }

    public String getBrewery() {
        return brewery;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public Beer getSnapshot() {
        return new Beer(id,brewery,name,genre);
    }
}
