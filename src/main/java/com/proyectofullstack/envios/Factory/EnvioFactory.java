package com.proyectofullstack.envios.Factory;
import com.proyectofullstack.envios.Strategy.EnvioEstandar;
import com.proyectofullstack.envios.Strategy.EnvioExpress;
import com.proyectofullstack.envios.Strategy.EnvioStrategy;
public class EnvioFactory {
    public static EnvioStrategy getEstrategia(String tipo) {
        return switch (tipo.toLowerCase()) {
            case "express"    -> new EnvioExpress();
            default           -> new EnvioEstandar();
        };
    }
}