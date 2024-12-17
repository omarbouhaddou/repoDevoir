package com.example.microservice_commandes.controller;

import com.example.microservice_commandes.model.Commande;
import com.example.microservice_commandes.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RefreshScope
public class CommandeController {
    @Autowired
    private CommandeRepository repository;

    // Récupérer toutes les commandes
    @GetMapping
    public List<Commande> getAllCommandes() {
        return repository.findAll();
    }

    // Ajouter une nouvelle commande
    @PostMapping
    public Commande createCommande(@RequestBody Commande commande) {
        return repository.save(commande);
    }



    // Supprimer une commande
    @DeleteMapping("/{id}")
    public void deleteCommande(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
