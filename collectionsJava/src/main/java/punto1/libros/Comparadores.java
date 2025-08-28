package punto1.libros;

import java.util.Comparator;

public class Comparadores {
    public static class PorAnio implements Comparator<Libro> {
        public int compare(Libro l1, Libro l2) {
            return Integer.compare(l1.getYear(), l2.getYear());
        }
    }

    public static class PorAutor implements Comparator<Libro> {
        public int compare(Libro l1, Libro l2) {
            return l1.getAutor().compareToIgnoreCase(l2.getAutor());
        }
    }

    public static class PorTitulo implements Comparator<Libro> {
        public int compare(Libro l1, Libro l2) {
            return l1.getTitulo().compareToIgnoreCase(l2.getTitulo());
        }
    }
}
