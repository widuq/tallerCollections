package punto8.agendaReuniones;

import java.time.*;
import java.util.*;

public class MainAgendaReuniones {
    private TreeSet<Reunion> reuniones;

    public MainAgendaReuniones() {
        reuniones = new TreeSet<>();
    }

    public void agregarReunion(Reunion r) {
        reuniones.add(r);
    }

    public Reunion obtenerPrimera() {
        return reuniones.first();
    }

    public Reunion obtenerUltima() {
        return reuniones.last();
    }

    public NavigableSet<Reunion> obtenerReunionesDesdeHoyHastaFinDeMes() {
        LocalDateTime inicio = LocalDateTime.now().withHour(0).withMinute(0).withSecond(0);
        LocalDate today = LocalDate.now();
        LocalDate finDeMes = today.withDayOfMonth(today.lengthOfMonth());
        LocalDateTime fin = LocalDateTime.of(finDeMes, LocalTime.MAX);

        Reunion desde = new Reunion(inicio, "");
        Reunion hasta = new Reunion(fin, Character.toString(Character.MAX_VALUE)); // para asegurar que entra cualquier "asunto"

        return reuniones.subSet(desde, true, hasta, true);
    }

    public void imprimirReuniones() {
        reuniones.forEach(System.out::println);
    }

    // Main de prueba
    public static void main(String[] args) {
        MainAgendaReuniones agenda = new MainAgendaReuniones();

        agenda.agregarReunion(new Reunion(LocalDateTime.of(2025, 8, 30, 10, 0), "Reunión con cliente"));
        agenda.agregarReunion(new Reunion(LocalDateTime.of(2025, 12, 29, 15, 30), "Planificación interna"));
        agenda.agregarReunion(new Reunion(LocalDateTime.of(2025, 9, 2, 9, 0), "Inicio de proyecto"));
        agenda.agregarReunion(new Reunion(LocalDateTime.of(2025, 8, 31, 11, 0), "Evaluación mensual"));

        System.out.println("Lista de todas las reuniones:");
        agenda.imprimirReuniones();

        System.out.println("\nPrimera reunión:");
        System.out.println(agenda.obtenerPrimera());

        System.out.println("\nÚltima reunión:");
        System.out.println(agenda.obtenerUltima());

        System.out.println("\nReuniones desde hoy hasta fin de mes:");
        agenda.obtenerReunionesDesdeHoyHastaFinDeMes().forEach(System.out::println);
    }
}

