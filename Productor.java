import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Productor extends Thread {
    private final BlockingQueue<Pedido> cola;
    private final String nombre;
    private final int pedidosACrear;
    private static final AtomicInteger generadorId = new AtomicInteger(1);

    public Productor(String nombre, BlockingQueue<Pedido> cola, int pedidosACrear) {
        this.nombre = nombre;
        this.cola = cola;
        this.pedidosACrear = pedidosACrear;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < pedidosACrear; i++) {
                int id = generadorId.getAndIncrement();
                Pedido pedido = new Pedido(id, nombre);
                cola.put(pedido);
                System.out.println(nombre + " creó " + pedido);
                Thread.sleep(300);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
