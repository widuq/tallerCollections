package punto5;
import java.util.ArrayDeque;
import java.util.Deque;

public class Navegador {

    private final Deque<String> pilaAtras = new ArrayDeque<>();
    private final Deque<String> pilaAdelante = new ArrayDeque<>();

    // Página actualmente mostrada
    private String actual;

    public Navegador(String paginaInicial) {
        this.actual = paginaInicial;
    }

    /**
     * Visitar una nueva página.
     * - La página actual pasa a la pila "atrás".
     * - La pila "adelante" se limpia
     */
    public void visitar(String url) {
        if (actual != null) {
            pilaAtras.push(actual);
        }
        actual = url;
        pilaAdelante.clear(); // visitar invalida el futuro
    }


    // Devuelve la página actual tras el movimiento o null si no hay atrás.

    public String atras() {
        if (pilaAtras.isEmpty()) return null;
        pilaAdelante.push(actual);
        actual = pilaAtras.pop();
        return actual;
    }

    //Devuelve la página actual tras el movimiento o null si no hay adelante.

    public String adelante() {
        if (pilaAdelante.isEmpty()) return null;
        pilaAtras.push(actual);
        actual = pilaAdelante.pop();
        return actual;
    }

    /** Ver la página actual. */
    public String actual() {
        return actual;
    }

    public boolean puedeAtras()    { return !pilaAtras.isEmpty(); }
    public boolean puedeAdelante() { return !pilaAdelante.isEmpty(); }

    /** Solo para demo/depuración. */
    public void imprimirEstado() {
        System.out.println("ATRÁS (tope→fondo): " + pilaAtras);
        System.out.println("ACTUAL: " + actual);
        System.out.println("ADELANTE (tope→fondo): " + pilaAdelante);
        System.out.println("----");
    }

    // ---- Demo rápida ----
    public static void main(String[] args) {
        Navegador nav = new Navegador("inicio");

        nav.visitar("google.com");
        nav.visitar("docs.com");
        nav.atras(); // vuelve a google.com; "adelante" contiene docs.com
        nav.imprimirEstado();

        // Visitar una nueva página limpia "adelante"
        nav.visitar("news.com");
        System.out.println("¿Hay adelante? " + nav.puedeAdelante()); // false
        nav.imprimirEstado();

        // Jugar con atrás/adelante
        nav.atras();     // vuelve a google.com
        nav.atras();     // vuelve a inicio
        nav.adelante();  // adelante -> google.com
        nav.imprimirEstado();
    }
}
