package punto8.agendaReuniones;

import java.time.LocalDateTime;

public class Reunion implements Comparable<Reunion> {
    private LocalDateTime fechaHora;
    private String asunto;

    public Reunion(LocalDateTime fechaHora, String asunto) {
        this.fechaHora = fechaHora;
        this.asunto = asunto;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public String getAsunto() {
        return asunto;
    }

    @Override
    public int compareTo(Reunion reunionComparada) {
        return this.fechaHora.compareTo(reunionComparada.fechaHora);
    }

    @Override
    public String toString() {
        return fechaHora + " - " + asunto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reunion)) return false;
        Reunion r = (Reunion) o;
        return fechaHora.equals(r.fechaHora) && asunto.equals(r.asunto);
    }

    @Override
    public int hashCode() {
        return fechaHora.hashCode() + asunto.hashCode();
    }
}

