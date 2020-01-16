package org.webapp.beerapp.domain;

import org.webapp.beerapp.model.Beer;

import java.util.List;

public interface DomainFacade {

    List<Beer> beerAdvice(String genre, String brewery);

}
