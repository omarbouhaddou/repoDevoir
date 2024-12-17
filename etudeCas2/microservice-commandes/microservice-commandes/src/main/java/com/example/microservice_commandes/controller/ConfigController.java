package com.example.microservice_commandes.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
@RefreshScope

public class ConfigController {
    @Value("${mes-config-ms.commandes-last}")
    private String commandesLast;

    @GetMapping
    public String getCommandesLast() {
        return "Commandes des " + commandesLast + " derniers jours.";
    }
}
