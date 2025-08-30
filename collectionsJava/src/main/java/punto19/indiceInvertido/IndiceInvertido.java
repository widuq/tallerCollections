package punto19.indiceInvertido;

import java.util.*;

public class IndiceInvertido {
    // Estructura: palabra -> conjunto ordenado de páginas (sin duplicados)
    private Map<String, TreeSet<Integer>> indice;

    public IndiceInvertido() {
        indice = new HashMap<>();
    }

    // Agrega una ocurrencia de la palabra en la página dada
    public void agregar(String palabra, int pagina) {
        // Convierte la palabra a minúsculas para evitar duplicados por mayúsculas
        palabra = palabra.toLowerCase();

        // Obtiene el conjunto de páginas o crea uno nuevo si no existe
        TreeSet<Integer> paginas = indice.getOrDefault(palabra, new TreeSet<>());
        paginas.add(pagina); // TreeSet evita duplicados automáticamente

        indice.put(palabra, paginas);
    }

    // Consulta las páginas en las que aparece la palabra
    public Set<Integer> consultar(String palabra) {
        palabra = palabra.toLowerCase();
        return indice.getOrDefault(palabra, new TreeSet<>());
    }

    // Opcional: mostrar todo el índice
    public void mostrarIndice() {
        for (String palabra : indice.keySet()) {
            System.out.println(palabra + " → " + indice.get(palabra));
        }
    }

    // Ejemplo de uso
    public static void main(String[] args) {
        IndiceInvertido indice = new IndiceInvertido();

        // Agregar ocurrencias
        indice.agregar("java", 1);
        indice.agregar("java", 17);
        indice.agregar("estructura", 2);
        indice.agregar("java", 3);
        indice.agregar("Java", 1); // Duplicado, no se repetirá


        // Consultar
        System.out.println("Páginas con 'java': " + indice.consultar("java"));
        System.out.println("Páginas con 'estructura': " + indice.consultar("estructura"));
        System.out.println("Páginas con 'python': " + indice.consultar("python"));

        // Mostrar todo el índice
        System.out.println("\nÍndice completo:");
        indice.mostrarIndice();
    }
}
