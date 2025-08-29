package punto17;

import java.util.ArrayDeque;

public class Procesamiento {

    public static void main(String[] args){


        ArrayDeque<Lote> cola= new ArrayDeque<>();

        cola.addLast(new Lote("L1", "Generación de reportes"));
        cola.addLast(new Lote("L2", "Backup nocturno"));
        cola.addLast(new Lote("L3", "Indexación de búsqueda"));

        cola.addFirst(new Lote("U1", "Parche crítico de seguridad"));

        cola.addLast(new Lote("L4", "Exportación CSV"));
        cola.addLast(new Lote("L5", "Envío de notificaciones"));

        // Otra urgencia inesperada
        cola.addFirst(new Lote("U2", "Corte de servicio inminente"));

        System.out.println("=== Orden en cola (inicio -> fin) ===");
        System.out.println(cola);

        System.out.println("\n=== Ejecución real (de inicio) ===");
        while (cola.isEmpty() == false) {
            Lote ejecutado = cola.pollFirst();
            System.out.println("Ejecutando: " + ejecutado);
        }

        System.out.println("\nCola vacía: " + cola.isEmpty());
    }
}
