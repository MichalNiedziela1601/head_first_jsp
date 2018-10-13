package org.webapp.beerapp.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.webapp.beerapp.model.Beer;
import org.webapp.beerapp.repository.BeerRepository;
import org.webapp.beerapp.repository.InMemoryBeerRepository;

import java.util.List;
import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.*;
//import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BeerDomainFacadeTest {

    private DomainFacade domainFacade;
    private BeerRepository repository;

    @Before
    public void setUp() throws Exception {
        repository = new InMemoryBeerRepository();
        Beer beer1 = new Beer(1L,"Okocim","Okocim full","light");
        Beer beer2 = new Beer(2L,"Żywiec","Zywiec premium", "amber");
        Beer beer3 = new Beer(3L,"German Pilsner","Groger","dark");
        repository.save(beer1);
        repository.save(beer2);
        repository.save(beer3);
        domainFacade = new BeerDomainFacade(repository);


    }

    @Test
    public void givenBrightWhenBeerAdviceThenReturnList() throws Exception {
        String genre = "light";

        List<Beer> beers = domainFacade.beerAdvice(genre);

        assertThat("Okocim full", is(beers.get(0).getName()));
    }

    @Test
    public void givenDarkWhenBeerAdviceThenReturnList() throws Exception {
        String genre = "dark";

        List<Beer> beers = domainFacade.beerAdvice(genre);

        assertThat("Groger", is(beers.get(0).getName()));
    }

    @Test
    public void givenBrownWhenBeerAdviceThenThrowError() throws Exception {
        String genre = "brown";
        try {
            domainFacade.beerAdvice(genre);
            Assert.fail("Should throw NoSuchElementException");
        } catch (Exception e) {
            assertThat(e, instanceOf(NoSuchElementException.class));
            assertThat(e.getMessage(), equalTo("Not found beer for this genre"));
        }
    }
}