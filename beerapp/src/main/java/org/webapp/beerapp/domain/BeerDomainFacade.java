package org.webapp.beerapp.domain;

import org.webapp.beerapp.repository.BeerRepository;
import org.webapp.beerapp.repository.InMemoryBeerRepository;
import org.webapp.beerapp.model.Beer;

import java.util.List;

public class BeerDomainFacade implements DomainFacade {

    private BeerRepository beerRepository = new InMemoryBeerRepository();
    private BeerFactory factory = new BeerFactory();
    private BeerAdvice beerAdvice;

    public BeerDomainFacade() {
        CreateBeerCommand command1 = new CreateBeerCommand("Okocim light","Okocim","light");
        CreateBeerCommand command2 = new CreateBeerCommand("Okocim dark","Okocim","dark");
        CreateBeerCommand command3 = new CreateBeerCommand("Zywiec premium","Żywiec","dark");

        beerRepository.save(factory.createBeer(command1).getSnapshot());
        beerRepository.save(factory.createBeer(command2).getSnapshot());
        beerRepository.save(factory.createBeer(command3).getSnapshot());

        beerAdvice = new BeerAdvice(beerRepository);

    }

    public BeerDomainFacade(final BeerRepository repository) {
        beerAdvice = new BeerAdvice(repository);
    }

    @Override
    public List<Beer> beerAdvice(String genre) {
        return beerAdvice.advice(genre);
    }
}
