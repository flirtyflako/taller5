# Simulación Productores y Consumidores con BlockingQueue (Java)

## Descripción
Este proyecto simula una situación donde múltiples clientes (productores) generan pedidos y múltiples operarios (consumidores) los procesan. Se utiliza una `BlockingQueue` para manejar de forma segura la concurrencia y un `AtomicInteger` para contar los pedidos procesados.

## Implementación
- `Pedido.java`: Representa un pedido con ID y nombre de cliente.
- `Productor.java`: Crea pedidos y los agrega a la cola compartida.
- `Consumidor.java`: Procesa pedidos desde la cola y actualiza el contador de forma atómica.
- `Main.java`: Coordina la ejecución de los hilos y señala el final de la simulación.

## Justificación del diseño
- `BlockingQueue` permite que los hilos productores y consumidores se comuniquen de manera segura, evitando la necesidad de sincronización manual.
- `AtomicInteger` asegura que el contador compartido se actualice sin condiciones de carrera.

## Pruebas realizadas
Se ejecutó la simulación con 2 productores (5 pedidos cada uno) y 2 consumidores. Se verificó en consola que todos los pedidos fueran procesados y contados correctamente.

## Requisitos
- Java 8 o superior
- IDE como NetBeans, IntelliJ o compilación por terminal
