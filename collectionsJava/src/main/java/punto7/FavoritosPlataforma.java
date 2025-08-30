package punto7;

import java.util.LinkedHashSet;
import java.util.Set;

public class FavoritosPlataforma {

    /** Representa un curso. Dos cursos son iguales si tienen el mismo id. */
    public static final class Curso {
        private final int id;
        private final String titulo;

        public Curso(int id, String titulo) {
            this.id = id;
            this.titulo = titulo;
        }

        public int getId() { return id; }
        public String getTitulo() { return titulo; }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Curso curso = (Curso) o;
            return id == curso.id; // igualdad por id
        }

        @Override
        public int hashCode() {
            return Integer.hashCode(id);
        }

        @Override
        public String toString() {
            return "(" + id + ") " + titulo;
        }
    }

    // Mantiene orden de inserción y evita duplicados
    private final Set<Curso> favoritos = new LinkedHashSet<>();

    public boolean marcarFavorito(Curso curso) {
        return favoritos.add(curso);
    }


    public boolean desmarcarFavoritoPorId(int id) {
        return favoritos.remove(new Curso(id, ""));
    }

    /** ¿Está un curso por id en favoritos? */
    public boolean esFavorito(int id) {
        return favoritos.contains(new Curso(id, ""));
    }

    /** Imprime el orden actual de favoritos. */
    public void imprimirFavoritos() {
        System.out.println("Favoritos (en orden): " + favoritos);
    }

    public static void main(String[] args) {
        FavoritosPlataforma fp = new FavoritosPlataforma();

        Curso c1 = new Curso(101, "Estructuras de Datos");
        Curso c2 = new Curso(102, "Bases de Datos");
        Curso c3 = new Curso(103, "Redes");
        Curso c4 = new Curso(104, "POO");

        // Marcamos en orden
        fp.marcarFavorito(c1);
        fp.marcarFavorito(c2);
        fp.marcarFavorito(c3);
        fp.imprimirFavoritos();

        // Intento de duplicado (mismo id, distinto título no importa)
        fp.marcarFavorito(new Curso(102, "Bases de Datos (duplicado)"));
        fp.imprimirFavoritos(); // Sin cambios: [101, 102, 103]

        // Eliminamos uno del medio
        fp.desmarcarFavoritoPorId(102);
        fp.imprimirFavoritos();

        // Reinsertamos el 102: pasa al FINAL
        fp.marcarFavorito(new Curso(102, "Bases de Datos"));
        fp.imprimirFavoritos();

        // Insertamos uno nuevo
        fp.marcarFavorito(c4);
        fp.imprimirFavoritos();           //
    }
}
