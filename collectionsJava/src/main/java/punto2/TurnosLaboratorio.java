package punto2;
import java.util.LinkedList;

public class TurnosLaboratorio {

    // Cola de estudiantes por nombre
    private final LinkedList<String> cola = new LinkedList<>();

    /**
     * Agrega un turno: si el equipo está reservado, entra al inicio (preferencial),
     * si no, entra al final (orden de llegada).
     * Operaciones O(1) gracias a LinkedList.
     */
    public void agregarTurno(String estudiante, boolean equipoReservado) {
        if (equipoReservado) {
            cola.addFirst(estudiante);   // turno preferencial
        } else {
            cola.addLast(estudiante);    // turno normal
        }
    }

    /** Atender al siguiente estudiante (cabeza de la cola). O(1) */
    public String atender() {
        // pollFirst() devuelve null si está vacía (no lanza excepción)
        return cola.pollFirst();
    }

    /** Ver el próximo a ser atendido sin sacarlo. O(1) */
    public String proximo() {
        return cola.peekFirst();
    }

    /** ¿La cola está vacía? O(1) */
    public boolean estaVacia() {
        return cola.isEmpty();
    }

    /** Tamaño de la cola. O(1) */
    public int tamano() {
        return cola.size();
    }

    /** Imprime el estado actual de la cola (solo para depurar/demostrar). */
    public void imprimirCola() {
        System.out.println("Cola actual: " + cola);
    }

    // --- Demo rápida ---
    public static void main(String[] args) {
        TurnosLaboratorio lab = new TurnosLaboratorio();

        // Llegadas
        lab.agregarTurno("Ana", false);   // normal -> al final
        lab.agregarTurno("Juan", false);  // normal -> al final
        lab.agregarTurno("Luisa", true);  // preferencial -> al inicio
        lab.agregarTurno("Carlos", false);
        lab.agregarTurno("María", true);  // preferencial -> al inicio

        lab.imprimirCola(); // Esperado: [María, Luisa, Ana, Juan, Carlos]

        // Atención
        System.out.println("Atendiendo: " + lab.atender()); // María
        System.out.println("Siguiente: " + lab.proximo());  // Luisa
        System.out.println("Tamaño: " + lab.tamano());      // 4

        lab.imprimirCola();

        // Atender todo
        while (!lab.estaVacia()) {
            System.out.println("Atendiendo: " + lab.atender());
        }
        System.out.println("¿Vacía? " + lab.estaVacia()); // true
    }
}