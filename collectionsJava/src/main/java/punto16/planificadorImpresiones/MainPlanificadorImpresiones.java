package punto16.planificadorImpresiones;

import java.time.LocalDateTime;
import java.util.PriorityQueue;

public class MainPlanificadorImpresiones {
    public static void main(String[] args) throws InterruptedException {
        PriorityQueue<Trabajo> colaTrabajos = new PriorityQueue<>();



        colaTrabajos.add(new Trabajo(300, LocalDateTime.now().minusHours(2))); // simula que llegó hace 2 horas
        Thread.sleep(10);
        colaTrabajos.add(new Trabajo(200, LocalDateTime.now()));
        Thread.sleep(10);
        colaTrabajos.add(new Trabajo(300, LocalDateTime.now()));
        Thread.sleep(10);
        colaTrabajos.add(new Trabajo(100, LocalDateTime.now()));
        Thread.sleep(10);
        colaTrabajos.add(new Trabajo(200, LocalDateTime.now().minusHours(1)));

        System.out.println("Procesando trabajos en orden óptimo:");
        while (!colaTrabajos.isEmpty()) {
            Trabajo t = colaTrabajos.poll();
            System.out.println("Imprimiendo: " + t);
        }
    }
}
