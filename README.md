# ms-envios

Microservicio encargado de calcular el costo y tiempo de envío de los pedidos en SmartLogix SaaS, utilizando el patrón Strategy para intercambiar dinámicamente entre tipos de envío.

## Patrón de diseño implementado

| Patrón | Ubicación | Propósito |
|---|---|---|
| Strategy | `EnvioStrategy`, `EnvioEstandar`, `EnvioExpress` | Permite seleccionar el algoritmo de cálculo de envío sin modificar el código cliente |
| Factory | `EnvioFactory` | Instancia la estrategia concreta según el tipo solicitado, cumpliendo el principio Open/Closed |

## Tecnologías

- Java 21
- Spring Boot 3.5.14
- Lombok
- Docker

## Endpoints

| Método | Endpoint | Descripción |
|---|---|---|
| GET | `/api/envios/calcular/{pedidoId}?tipo=estandar\|express` | Calcula el costo de envío según la estrategia elegida |

## Cómo ejecutar localmente

### Requisitos
- Java 21
- Maven 3.9+
- Docker (opcional)

### Con Maven

```bash
mvn clean package -DskipTests
java -jar target/ms-envios-0.0.1-SNAPSHOT.jar
```

El servicio queda disponible en `http://localhost:8081`.

### Con Docker

```bash
docker build -t ms-envios .
docker run -p 8081:8081 ms-envios
```

## Cómo probar

```bash
curl "http://localhost:8081/api/envios/calcular/1?tipo=estandar"
```

Respuesta esperada: `Estándar 3-5 días - $2990`

```bash
curl "http://localhost:8081/api/envios/calcular/1?tipo=express"
```

Respuesta esperada: `Express 24h - $5990`

## Estructura del proyecto

```
src/main/java/com/proyectofullstack/envios/
├── Controller/   EnvioController
├── Strategy/     EnvioStrategy, EnvioEstandar, EnvioExpress
├── Factory/      EnvioFactory
└── EnviosApplication.java
```
