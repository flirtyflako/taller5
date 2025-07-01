import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Pedido> cola = new LinkedBlockingQueue<>();
        AtomicInteger contador = new AtomicInteger(0);

        Productor p1 = new Productor("Cliente-1", cola, 5);
        Productor p2 = new Productor("Cliente-2", cola, 5);

        Consumidor c1 = new Consumidor("Operario-1", cola, contador);
        Consumidor c2 = new Consumidor("Operario-2", cola, contador);

        p1.start();
        p2.start();
        c1.start();
        c2.start();

        p1.join();
        p2.join();

        // Señales de finalización para los consumidores
        cola.put(new Pedido(-1, "FIN"));
        cola.put(new Pedido(-1, "FIN"));

        c1.join();
        c2.join();

        System.out.println("Simulación terminada. Pedidos totales procesados: " + contador.get());
    }
}
