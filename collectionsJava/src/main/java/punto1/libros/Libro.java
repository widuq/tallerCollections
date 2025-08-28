package punto1.libros;

import java.util.Objects;

public class Libro implements Comparable<Libro> {
    private String titulo;
    private String autor;
    private int year;
    private String ISBN;

    public Libro(String titulo, String autor, int year, String ISBN) {
        this.titulo = titulo;
        this.autor = autor;
        this.year = year;
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    @Override
    public String toString() {
        return titulo + " | " + autor + " | " + year + " | " + ISBN;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return ISBN.equals(libro.ISBN);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ISBN);
    }

    @Override
    public int compareTo(Libro o) {
        return 0;
    }
}
