package punto4.soporteTecnico;

import java.time.LocalDateTime;

public class Ticket implements Comparable<Ticket> {

    // en el enum se colocan la prioridad critica como la mas importante y baja la de menor peso
    // se usa .ordinal() para obtener el valor de las prioridad: 0= baja, 3=critica

    public enum Severidad {
        BAJA,MEDIA,ALTA,CRITICA
    }

    private String descripcion;
    private Severidad severidad;
    private LocalDateTime fechaCreacion;

    public Ticket(String descripcion, Severidad severidad, LocalDateTime fechaCreacion) {
        this.descripcion = descripcion;
        this.severidad = severidad;
        this.fechaCreacion = fechaCreacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Severidad getSeveridad() {
        return severidad;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    @Override
    public int compareTo(Ticket siguiente) {
        // Comparar por severidad, el orden es CRITICA > ALTA > MEDIA > BAJA
        int compSeveridad = siguiente.severidad.ordinal() - this.severidad.ordinal();
        if (compSeveridad != 0) {
            return compSeveridad;
        }

        // Si tienen la misma severidad, se compara por fecha de creación (más antigua primero)
        return this.fechaCreacion.compareTo(siguiente.fechaCreacion);
    }

    @Override
    public String toString() {
        return "[" + severidad + "] " + descripcion + " - " + fechaCreacion;
    }
}

