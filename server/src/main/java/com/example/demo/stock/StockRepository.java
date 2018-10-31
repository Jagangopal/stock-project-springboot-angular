package com.example.demo.stock;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
interface StockRepository extends JpaRepository<Stock, Long> {
}