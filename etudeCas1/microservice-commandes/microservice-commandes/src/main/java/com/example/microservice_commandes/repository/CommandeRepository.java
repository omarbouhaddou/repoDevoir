package com.example.microservice_commandes.repository;

import com.example.microservice_commandes.model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande, Long> {
}
