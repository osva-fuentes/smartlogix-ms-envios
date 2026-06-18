package com.proyectofullstack.envios.Strategy;
import lombok.extern.slf4j.Slf4j;
@Slf4j
public class EnvioExpress implements EnvioStrategy {
    @Override
    public String calcularEnvio(Long pedidoId) {
        log.info("Calculando envío EXPRESS para pedido {}", pedidoId);
        return "Express 24h - $5990";
    }
}