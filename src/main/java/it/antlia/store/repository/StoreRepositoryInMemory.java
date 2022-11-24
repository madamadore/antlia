package it.antlia.store.repository;

import org.springframework.stereotype.Repository;
import it.antlia.store.model.TShirt;

@Repository
public class StoreRepositoryInMemory extends ProductRepository<TShirt> {
    
    public StoreRepositoryInMemory() {
        TShirt armani = new TShirt(42, "Red", "Armani");
		TShirt prada = new TShirt(44, "Red", "Prada");

        add(armani);
        add(prada);
    }
}
