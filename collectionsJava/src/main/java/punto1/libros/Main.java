package punto1.libros;

import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        ArrayList<Libro> libros = new ArrayList<>();

        libros.add(new Libro("Cien años de soledad", "Gabriel García Márquez", 1967, "978-0307474728"));
        libros.add(new Libro("1984", "George Orwell", 1949, "978-0451524935"));
        libros.add(new Libro("El Aleph", "Jorge Luis Borges", 1925, "978-0307959958"));
        libros.add(new Libro("Don Quijote", "Miguel de Cervantes", 1605, "978-8424119869"));
        libros.add(new Libro("La casa de los espíritus", "Isabel Allende", 1982, "978-0307949580"));
        libros.add(new Libro("El_2025", "Wid", 2025, "ALZ-113"));

        // Ordenar por año ascendente
        libros.sort(new Comparadores.PorAnio());

        System.out.println("--- Libros ordenados por año ---");
        libros.forEach(System.out::println);

        // Buscar por autor
        String autorBuscado = "George Orwell";
        System.out.println("\n--- Libros de " + autorBuscado + " ---");
        libros.stream()
                .filter(libro -> libro.getAutor().equalsIgnoreCase(autorBuscado))
                .forEach(System.out::println);

        // Eliminar por ISBN
        String isbnEliminar = "978-0451524935";
        libros.removeIf(libro -> libro.getISBN().equals(isbnEliminar));

        // Mostrar los 5 más recientes
        System.out.println("\n--- 5 libros más recientes ---");
        libros.stream()
                .sorted(Comparator.comparing(Libro::getYear).reversed())
                .limit(5)
                .forEach(System.out::println);
    }
}

