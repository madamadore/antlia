package it.antlia.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.antlia.store.model.TShirt;
import it.antlia.store.repository.ProductRepository;

@RestController
@RequestMapping("/tshirts")
public class TShirtController {

    @Autowired
    private ProductRepository<TShirt> magazzino;

    @GetMapping("/list")
    public List<TShirt> getTShirts() {
        return magazzino.getList();
    }

    @GetMapping("/{id}")
    public @ResponseBody TShirt getTShirt(@PathVariable int id) {
        return magazzino.get(id);
    }

    @PostMapping("/add")
    public void insertTShirt(@RequestBody TShirt tshirt) {
        magazzino.add(tshirt);
    }

    @PutMapping("/update")
    public void updateTShirt(@RequestBody TShirt tshirt) {
        magazzino.add(tshirt);
    }

    @DeleteMapping("/delete")
    public void deleteTShirt(@RequestBody TShirt tshirt) {
        magazzino.add(tshirt);
    }
}
