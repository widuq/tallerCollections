package punto10;

import java.util.Iterator;
import java.util.LinkedHashMap;

public class Factura {

    public static void main(String[] args) {

        LinkedHashMap<String, Detalle> factura = new LinkedHashMap<>();

        agregarProducto(factura, "Arroz", 2000, 2);
        agregarProducto(factura, "Leche", 3500, 1);
        agregarProducto(factura, "Galletas", 4300, 1);
        agregarProducto(factura, "Chocolate", 3650, 3); // Manzana repetida
        agregarProducto(factura, "Huevos", 12000, 1);

        imprimirFactura(factura);
    }

    public static void agregarProducto(LinkedHashMap<String, Detalle> factura, String nombre, double precio, int cantidad) {

        if (factura.containsKey(nombre)) {
            factura.get(nombre).sumarCantidad(cantidad);

        } else {
            factura.put(nombre, new Detalle(nombre, precio, cantidad));
        }
    }

    public static void imprimirFactura(LinkedHashMap<String, Detalle> factura) {

        double subtotal = 0;
        double iva = 0.19;

        System.out.println("--------FACTURA---------");

        Iterator<Detalle> it = factura.values().iterator();
        while (it.hasNext()) {
            Detalle d = it.next();
            System.out.println(d);
            subtotal += d.getSubtotal();
        }

        double ivaTotal = subtotal * iva;
        double totalCompra = subtotal + ivaTotal;

        System.out.println("---------------------------");
        System.out.println("Subtotal: " + subtotal);
        System.out.println("IVA (19%): " + ivaTotal);
        System.out.println("TOTAL: " + totalCompra);
    }

}
