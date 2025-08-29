package punto16.planificadorImpresiones;

import java.time.LocalDateTime;

public class Trabajo implements Comparable<Trabajo> {
    private int tamaño;
    private LocalDateTime antiguedad; // Fecha de llegada

    public Trabajo(int tamaño, LocalDateTime antigüedad) {
        this.tamaño = tamaño;
        this.antiguedad = antigüedad;
    }

    @Override
    public int compareTo(Trabajo siguiente) {
        // Primero por tamaño (menor primero)
        if (this.tamaño != siguiente.tamaño) {
            return Integer.compare(this.tamaño, siguiente.tamaño);
        }
        // Si tamaño igual, el más antiguo pasa primero (fecha menor)
        return this.antiguedad.compareTo(siguiente.antiguedad);
    }

    @Override
    public String toString() {
        return "Trabajo [ tamaño=" + tamaño + ", antigüedad=" + antiguedad + "]";
    }
}
