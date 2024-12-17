package com.example.microservice_produit.controller;

import com.example.microservice_produit.model.Produit;
import com.example.microservice_produit.repository.ProduitRepository;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/produits")
public class ProduitController {
    @Autowired
    private ProduitRepository produitRepository;

    // Ajouter un produit
    @PostMapping
    public Produit ajouterProduit(@RequestBody Produit produit) {
        return produitRepository.save(produit);
    }

    // Récupérer tous les produits
    @Retry(name = "produitService", fallbackMethod = "fallbackListeDesProduits")
    @TimeLimiter(name = "produitService")
    @GetMapping
    public CompletableFuture<List<Produit>> getProduits() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000); // Simule un délai de 3 secondes
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return produitRepository.findAll();
        });
    }

    // Récupérer un produit par ID
    @GetMapping("/{id}")
    public Produit getProduitById(@PathVariable Long id) {
        return produitRepository.findById(id).orElse(null);
    }

    // Supprimer un produit
    @DeleteMapping("/{id}")
    public void supprimerProduit(@PathVariable Long id) {
        produitRepository.deleteById(id);
    }

    public CompletableFuture<List<Produit>> fallbackListeDesProduits(Throwable t) {
        System.out.println("Fallback triggered due to: " + t.getMessage());
        return CompletableFuture.completedFuture(List.of()); // Retourne une liste vide
    }

}
