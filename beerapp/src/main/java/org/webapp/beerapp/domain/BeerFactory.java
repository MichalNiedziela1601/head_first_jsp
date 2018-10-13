package org.webapp.beerapp.domain;

import java.util.concurrent.atomic.AtomicLong;

public class BeerFactory {

    private final AtomicLong idGenerator = new AtomicLong();

    BeerAggregate createBeer(final CreateBeerCommand command) {
        if(command.getName() == null && command.getBrewery() == null && command.getGenre() == null) {
            throw new IllegalArgumentException("At least one argument is empty");
        }

        return new BeerAggregate(idGenerator.getAndIncrement(), command.getBrewery(), command.getName(), command.getGenre());
    }
}
