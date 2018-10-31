package com.example.demo.stock;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
public class StockController {
    private StockRepository repository;

    public StockController(StockRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/stocks")
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<Stock> goodBeers() {

        return repository.findAll().stream()
                .filter(this::isGreat)
                .collect(Collectors.toList());
    }

    private boolean isGreat(Stock stock) {
        return !stock.getName().equals("Tata Sons");
                
    }
}