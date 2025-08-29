package punto18;

import java.util.LinkedList;
import java.util.Scanner;

public class ListaReproduccion {
    public static void main(String[] args) {
        LinkedList<Cancion> lista = new LinkedList<>();
        lista.add(new Cancion("Canción 1"));
        lista.add(new Cancion("Canción 2"));
        lista.add(new Cancion("Canción 3"));
        lista.add(new Cancion("Canción 4"));

        int cursor = 0;
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nLista de Reproducción:");
            for (int i = 0; i < lista.size(); i++) {
                if (i == cursor) {
                    System.out.print("-> "); // indica canción actual
                } else {
                    System.out.print("   ");
                }
                System.out.println(lista.get(i).getTitulo());
            }

            System.out.println("\n1. Siguiente canción");
            System.out.println("2. Canción anterior");
            System.out.println("3. Mover canción");
            System.out.println("4. Salir");
            System.out.print("Elige: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1: // siguiente
                    if (cursor < lista.size() - 1) cursor++;
                    break;

                case 2: // anterior
                    if (cursor > 0) cursor--;
                    break;

                case 3: // mover canción
                    System.out.print("Posición actual (0-" + (lista.size() - 1) + "): ");
                    int origen = sc.nextInt();
                    System.out.print("Nueva posición (0-" + (lista.size() - 1) + "): ");
                    int destino = sc.nextInt();

                    if (origen >= 0 && origen < lista.size() &&
                            destino >= 0 && destino < lista.size()) {
                        Cancion c = lista.remove(origen);
                        lista.add(destino, c);
                        cursor = destino; // el cursor sigue a la canción movida
                    } else {
                        System.out.println("Posiciones inválidas.");
                    }
                    break;

                case 4:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 4);

        sc.close();
    }
}
