package com.example.microservice_produit.repository;

import com.example.microservice_produit.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
    
}
