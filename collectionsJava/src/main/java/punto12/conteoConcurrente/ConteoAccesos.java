package punto12.conteoConcurrente;


/**
 * Este programa utiliza Hashtable<String, Integer> para contar accesos concurrentes
 * de usuarios en un sistema legado.

 * *** Diferencia entre HashMap y Hashtable en concurrencia: ****

  - HashMap no es seguro para el acceso concurrente. Si múltiples hilos acceden y modifican
    un HashMap simultáneamente sin sincronización externa, pueden corromperse los datos

  - Hashtable es una clase sincronizada. Todos sus métodos están sincronizados,
   lo que significa que solo un hilo puede acceder o modificar su contenido a la vez.
   Esto hace que sea seguro en entornos multihilo, aunque menos eficiente.

  Por esta razón, en sistemas antiguos (legados), es común utilizar Hashtable para mantener
  compatibilidad y seguridad en la concurrencia.
 */



import java.util.*;
        import java.util.concurrent.*;

public class ConteoAccesos {
    private static Hashtable<String, Integer> contadorUsuarios = new Hashtable<>();

    // Incrementa contador de forma sincronizada
    public static void registrarAcceso(String usuario) {
        synchronized (contadorUsuarios) {
            contadorUsuarios.put(usuario, contadorUsuarios.getOrDefault(usuario, 0) + 1);
        }
    }

    // Devuelve los top 3 usuarios con más accesos
    public static List<Map.Entry<String, Integer>> obtenerTop3Usuarios() {
        List<Map.Entry<String, Integer>> lista = new ArrayList<>(contadorUsuarios.entrySet());

        // Ordenar por valor descendente
        lista.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        // Tomar los primeros 3 (o menos si hay pocos)
        return lista.subList(0, Math.min(3, lista.size()));
    }
    public static void main(String[] args) throws InterruptedException {
        ExecutorService ejecutor = Executors.newFixedThreadPool(5);
        Random random = new Random(); // Generador random de numero de accesos

        // Simular accesos concurrentes aleatorios
        for (int i = 0; i < 100; i++) { // i representa la cantidad de accesos
            String usuario = "usuario" + random.nextInt(10); // genera usuario entre 0 y 9
            ejecutor.submit(() -> registrarAcceso(usuario));
        }

        ejecutor.shutdown();
        ejecutor.awaitTermination(5, TimeUnit.SECONDS);

        // Mostrar resultados
        System.out.println("Lista completa de accesos por usuario:");
        for (Map.Entry<String, Integer> entry : contadorUsuarios.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " accesos");
        }

        System.out.println("\nTop 3 usuarios con más accesos:");
        for (Map.Entry<String, Integer> entry : obtenerTop3Usuarios()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " accesos");
        }
    }



}

