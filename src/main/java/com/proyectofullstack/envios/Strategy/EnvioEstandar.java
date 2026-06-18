package com.proyectofullstack.envios.Strategy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EnvioEstandar implements EnvioStrategy {
    @Override
    public String calcularEnvio(Long pedidoId) {
        log.info("Calculando envío ESTÁNDAR para pedido {}", pedidoId);
        return "Estándar 3-5 días - $2990";
    }
}