package com.proyectofullstack.envios.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyectofullstack.envios.Factory.EnvioFactory;
import com.proyectofullstack.envios.Strategy.EnvioStrategy;
@CrossOrigin
@RestController
@RequestMapping("/api/envios")
public class EnvioController {

    @GetMapping("/calcular/{pedidoId}")
    public ResponseEntity<String> calcular(
            @PathVariable Long pedidoId,
            @RequestParam(defaultValue = "estandar") String tipo) {

        EnvioStrategy estrategia = EnvioFactory.getEstrategia(tipo);
        String resultado = estrategia.calcularEnvio(pedidoId);
        return ResponseEntity.ok(resultado);
    }
}