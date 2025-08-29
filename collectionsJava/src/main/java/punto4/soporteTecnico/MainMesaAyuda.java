package punto4.soporteTecnico;

import java.time.LocalDateTime;
import java.util.PriorityQueue;

public class MainMesaAyuda {
    public static void main(String[] args) {
        PriorityQueue<Ticket> tickets = new PriorityQueue<>();

        tickets.add(new Ticket("Servidor caído", Ticket.Severidad.CRITICA, LocalDateTime.now().minusHours(2)));
        tickets.add(new Ticket("Error menor en UI", Ticket.Severidad.BAJA, LocalDateTime.now().minusHours(1)));
        tickets.add(new Ticket("Problema de login", Ticket.Severidad.ALTA, LocalDateTime.now().minusHours(3)));
        tickets.add(new Ticket("Lentitud en sistema", Ticket.Severidad.ALTA, LocalDateTime.now().minusHours(1)));
        tickets.add(new Ticket("error base de datos", Ticket.Severidad.CRITICA, LocalDateTime.now().minusHours(5)));
        tickets.add(new Ticket("Warning de acceso", Ticket.Severidad.BAJA, LocalDateTime.now().minusHours(3)));
        tickets.add(new Ticket("Red no disponible", Ticket.Severidad.MEDIA, LocalDateTime.now().minusHours(3)));
        int numeroAtencion = 1;
        while (!tickets.isEmpty()) {
            Ticket ticket = tickets.poll();
            System.out.println("Atención número " + numeroAtencion + ": " + ticket);
            numeroAtencion++;
        }
    }
}
