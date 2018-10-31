package com.example.demo.stock;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class StockCommandLineRunner implements CommandLineRunner {

    private final StockRepository repository;

    public StockCommandLineRunner(StockRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) throws Exception {
        Stream.of("Reliance", "ICICI Bank", "Sun Network", "ITC Hotels",
                "Titan", "Adhitya Birla Group", "Tata Sons").forEach(name ->
                repository.save(new Stock(name))
        );
        repository.findAll().forEach(System.out::println);
    }
}