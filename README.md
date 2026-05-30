# MS-Compradores

Microservicio encargado de gestionar los compradores y sus órdenes de compra en la Caleta Lo Abarca.

## Tecnologías
- Java 21
- Spring Boot 3.5.14
- PostgreSQL (Neon)
- Maven

## Puerto
8084

## Endpoints

### Compradores
- POST /api/compradores - Crear nuevo comprador
- GET /api/compradores - Obtener todos los compradores
- GET /api/compradores/{id} - Obtener comprador por ID
- GET /api/compradores/rut/{rut} - Obtener comprador por RUT
- GET /api/compradores/activos - Obtener compradores activos
- PUT /api/compradores/{id} - Actualizar comprador
- DELETE /api/compradores/{id} - Desactivar comprador

### Ordenes de Compra
- POST /api/ordenes - Crear nueva orden
- GET /api/ordenes - Obtener todas las ordenes
- GET /api/ordenes/{id} - Obtener orden por ID
- GET /api/ordenes/comprador/{compradorId} - Obtener ordenes por comprador
- PUT /api/ordenes/{id}/ejecutar - Ejecutar orden
- PUT /api/ordenes/{id}/cancelar - Cancelar orden

## Como correr el proyecto
1. git clone https://github.com/Malos-pal-catre/ms-compradores.git
2. cd ms-compradores
3. ./mvnw spring-boot:run
