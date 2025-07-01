import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Consumidor extends Thread {
    private final BlockingQueue<Pedido> cola;
    private final String nombre;
    private final AtomicInteger contadorProcesados;

    public Consumidor(String nombre, BlockingQueue<Pedido> cola, AtomicInteger contadorProcesados) {
        this.nombre = nombre;
        this.cola = cola;
        this.contadorProcesados = contadorProcesados;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Pedido pedido = cola.take();
                if (pedido.getId() == -1) break; // Señal de finalización
                System.out.println(nombre + " procesó " + pedido);
                int total = contadorProcesados.incrementAndGet();
                System.out.println("Total procesados: " + total);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
