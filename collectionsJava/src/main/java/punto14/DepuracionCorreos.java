package punto14;

import java.util.*;

public class DepuracionCorreos {

    public static int depurar(Set<String> correos, Set<String> dominiosVetados) {
        int eliminados = 0;
        for (Iterator<String> it = correos.iterator(); it.hasNext(); ) {
            String email = it.next();
            if (esDominioVetado(email, dominiosVetados)) {
                it.remove();   // eliminación segura durante la iteración
                eliminados++;
            }
        }
        return eliminados;
    }

    /** Extrae el dominio y verifica si está vetado (exacto o subdominio). */
    private static boolean esDominioVetado(String email, Set<String> dominiosVetados) {
        int at = email.lastIndexOf('@');
        if (at < 0 || at == email.length() - 1) return false; // formato simple
        String dominio = email.substring(at + 1).toLowerCase(Locale.ROOT);

        for (String vet : dominiosVetados) {
            String v = vet.toLowerCase(Locale.ROOT);
            if (dominio.equals(v) || dominio.endsWith("." + v)) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        // Conjunto de correos (únicos, sin orden)
        Set<String> correos = new HashSet<>(Arrays.asList(
                "ana@uni.edu",
                "spam1@spam.com",
                "profe@facultad.edu",
                "promo@junk.net",
                "soporte@banned.org",
                "user@gmail.com",
                "info@sub.spam.com" // subdominio de spam.com
        ));

        // Dominios vetados
        Set<String> vetados = new HashSet<>(Arrays.asList(
                "spam.com", "banned.org", "junk.net"
        ));

        // Tamaño antes
        int antes = correos.size();
        System.out.println("Tamaño antes: " + antes);
        System.out.println("Correos (antes): " + correos);

        // Depurar (eliminar vetados) con iterator.remove()
        int eliminados = depurar(correos, vetados);

        // Tamaño después
        int despues = correos.size();
        System.out.println("Eliminados: " + eliminados);
        System.out.println("Tamaño después: " + despues);
        System.out.println("Correos (después): " + correos);
    }
}
