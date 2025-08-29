package AgendaAcademica;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Optional;
import java.util.TreeMap;

public class AgendaAcademica {

    // Mapa ordenado por fecha: día
    private final TreeMap<LocalDate, List<Actividad>> agenda = new TreeMap<>();

    /** Agregar una actividad a un día. Complejidad: O(log n) por acceso al TreeMap. */
    public void agregarActividad(LocalDate dia, Actividad actividad) {
        if (dia == null || actividad == null) {
            throw new IllegalArgumentException("Día y actividad no pueden ser nulos");
        }
        agenda.computeIfAbsent(dia, d -> new ArrayList<>()).add(actividad);
    }


    public Optional<Map.Entry<LocalDate, List<Actividad>>> obtenerDiaMasProximo(LocalDate hoy) {
        if (hoy == null) hoy = LocalDate.now();
        return Optional.ofNullable(agenda.ceilingEntry(hoy));
    }

    /**
     * Devuelve una actividad de la fecha más próxima (la primera en la lista de ese día),
     * o vacío si no hay ninguna fecha >= hoy.
     */
    public Optional<Actividad> obtenerActividadMasProxima(LocalDate hoy) {
        return obtenerDiaMasProximo(hoy)
                .filter(e -> !e.getValue().isEmpty())
                .map(e -> e.getValue().get(0));
    }

    /**
     * Reporte de actividades entre dos fechas, inclusivo.
     * Usa la vista de mapa: cambios en la vista afectan el mapa original.
     * Complejidad: operaciones de vista O(log n) para límites.
     */
    public NavigableMap<LocalDate, List<Actividad>> reporte(LocalDate desde, LocalDate hasta) {
        if (desde == null || hasta == null) throw new IllegalArgumentException("Fechas no pueden ser nulas");
        if (desde.isAfter(hasta)) throw new IllegalArgumentException("'desde' no puede ser posterior a 'hasta'");
        return agenda.subMap(desde, true, hasta, true);
    }

    /** Utilidad para imprimir un reporte legible en consola. */
    public void imprimirReporte(LocalDate desde, LocalDate hasta) {
        NavigableMap<LocalDate, List<Actividad>> rango = reporte(desde, hasta);
        if (rango.isEmpty()) {
            System.out.println("Sin actividades entre " + desde + " y " + hasta);
            return;
        }
        System.out.println("=== Reporte " + desde + " a " + hasta + " ===");
        for (Map.Entry<LocalDate, List<Actividad>> e : rango.entrySet()) {
            System.out.println(e.getKey() + ":");
            int i = 1;
            for (Actividad a : e.getValue()) {
                System.out.println("  " + (i++) + ". " + a);
            }
        }
    }


    public static final class Actividad {
        private final String titulo;
        private final LocalTime hora;     // opcional
        private final String detalle;     // opcional

        public Actividad(String titulo, LocalTime hora, String detalle) {
            if (titulo == null || titulo.isBlank())
                throw new IllegalArgumentException("El título no puede estar vacío");
            this.titulo = titulo;
            this.hora = hora;
            this.detalle = detalle;
        }

        public String getTitulo() { return titulo; }
        public LocalTime getHora() { return hora; }
        public String getDetalle() { return detalle; }

        @Override
        public String toString() {
            String h = (hora != null) ? hora.toString() + " - " : "";
            String d = (detalle != null && !detalle.isBlank()) ? " (" + detalle + ")" : "";
            return h + titulo + d;
        }
    }


    public static void main(String[] args) {
        AgendaAcademica ag = new AgendaAcademica();

        LocalDate hoy = LocalDate.now();
        LocalDate d1 = hoy.minusDays(1);
        LocalDate d2 = hoy.plusDays(2);
        LocalDate d3 = hoy.plusDays(5);

        ag.agregarActividad(d1, new Actividad("Repaso listas y colas", LocalTime.of(9, 0), "Aula 101"));
        ag.agregarActividad(hoy, new Actividad("Parcial Estructuras", LocalTime.of(14, 0), "Bloque B"));
        ag.agregarActividad(d2, new Actividad("Laboratorio ÁRBOLes", LocalTime.of(10, 30), null));
        ag.agregarActividad(d2, new Actividad("Tutoría grafos", LocalTime.of(12, 0), "Sala TA"));
        ag.agregarActividad(d3, new Actividad("Entrega proyecto", LocalTime.of(23, 59), "Campus Virtual"));

        // Día más próximo (>= hoy)
        ag.obtenerDiaMasProximo(hoy).ifPresentOrElse(
                e -> System.out.println("Próximo día con actividades: " + e.getKey() + " -> " + e.getValue()),
                () -> System.out.println("No hay actividades próximas.")
        );

        ag.obtenerActividadMasProxima(hoy).ifPresent(a ->
                System.out.println("Actividad más próxima: " + a)
        );


        ag.imprimirReporte(hoy, hoy.plusDays(6));
    }
}
