package it.antlia.store.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import it.antlia.store.model.TShirt;

@Repository
public class StoreRepositoryInMemory implements TShirtRepository {
    private List<TShirt> magazzino;
    
    public StoreRepositoryInMemory() {
        TShirt armani = new TShirt(42, "Red", "Armani");
		TShirt prada = new TShirt(44, "Red", "Prada");

        magazzino = new ArrayList<>();
        magazzino.add(armani);
        magazzino.add(prada);
    }

    @Override
    public List<TShirt> getList() {
        return magazzino;
    }

    @Override
    public TShirt get(int id) {
        return magazzino
                    .stream()
                    .filter(shirt->{ return shirt.getId() == id; })
                    .findFirst()
                    .orElse(null);
    }

    @Override
    public void add(TShirt tshirt) {
        magazzino.add(tshirt);
    }

    @Override
    public void update(TShirt thirt) {
        // TODO
    }

    @Override
    public void delete(TShirt tshirt) {
        magazzino.remove(tshirt);
    }
}
