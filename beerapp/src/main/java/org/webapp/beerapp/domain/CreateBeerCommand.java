package org.webapp.beerapp.domain;

public class CreateBeerCommand {

    private final String name;
    private final String brewery;
    private final String genre;

    public CreateBeerCommand(String name, String brewery, String genre) {
        this.name = name;
        this.brewery = brewery;
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public String getBrewery() {
        return brewery;
    }

    public String getGenre() {
        return genre;
    }
}
