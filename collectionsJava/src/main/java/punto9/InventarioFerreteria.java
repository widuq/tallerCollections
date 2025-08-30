package punto9;

import java.util.*;
import java.util.stream.Collectors;

public class InventarioFerreteria {


    private final Map<String, Producto> inventario = new HashMap<>();

    public boolean agregarProducto(String codigo, String nombre, double precio, int stock) {
        validarCodigo(codigo);
        if (precio < 0 || stock < 0) {
            throw new IllegalArgumentException("Precio y stock no pueden ser negativos");
        }
        return inventario.putIfAbsent(codigo, new Producto(codigo, nombre, precio, stock)) == null;
    }

    public boolean actualizarStock(String codigo, int nuevoStock) {
        validarCodigo(codigo);
        if (nuevoStock < 0) throw new IllegalArgumentException("El stock no puede ser negativo");
        Producto p = inventario.get(codigo);
        if (p == null) return false;
        p.setStock(nuevoStock);
        return true;
    }

    public boolean ajustarStock(String codigo, int delta) {
        validarCodigo(codigo);
        Producto p = inventario.get(codigo);
        if (p == null) return false;
        int nuevo = p.getStock() + delta;
        if (nuevo < 0) throw new IllegalArgumentException("Resultado de stock negativo");
        p.setStock(nuevo);
        return true;
    }


    public OptionalDouble consultarPrecio(String codigo) {
        validarCodigo(codigo);
        Producto p = inventario.get(codigo);
        return p == null ? OptionalDouble.empty() : OptionalDouble.of(p.getPrecio());
    }


    public List<Producto> listarFaltantes() {
        return inventario.values().stream()
                .filter(p -> p.getStock() == 0)
                .collect(Collectors.toList());
    }

    public boolean actualizarPrecio(String codigo, double nuevoPrecio) {
        validarCodigo(codigo);
        if (nuevoPrecio < 0) throw new IllegalArgumentException("El precio no puede ser negativo");
        Producto p = inventario.get(codigo);
        if (p == null) return false;
        p.setPrecio(nuevoPrecio);
        return true;
    }


    public void imprimirInventario() {
        inventario.values().forEach(System.out::println);
    }

    private void validarCodigo(String codigo) {
        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("Código inválido");
        }
    }

    // ---------- Modelo ----------
    public static class Producto {
        private final String codigo;
        private final String nombre;
        private double precio;
        private int stock;

        public Producto(String codigo, String nombre, double precio, int stock) {
            this.codigo = codigo;
            this.nombre = nombre;
            this.precio = precio;
            this.stock = stock;
        }

        public String getCodigo() { return codigo; }
        public String getNombre() { return nombre; }
        public double getPrecio() { return precio; }
        public int getStock() { return stock; }

        public void setPrecio(double precio) { this.precio = precio; }
        public void setStock(int stock) { this.stock = stock; }

        @Override
        public String toString() {
            return String.format("Producto{codigo='%s', nombre='%s', precio=%.2f, stock=%d}",
                    codigo, nombre, precio, stock);
        }
    }


    public static void main(String[] args) {
        InventarioFerreteria inv = new InventarioFerreteria();

        // Agregar productos
        inv.agregarProducto("A001", "Martillo", 25_000, 10);
        inv.agregarProducto("A002", "Destornillador", 12_500, 0);
        inv.agregarProducto("A003", "Alicate", 18_900, 5);

        // Consultar precio por código
        System.out.println("Precio A001: " + inv.consultarPrecio("A001").orElse(-1));
        System.out.println("Precio A999 (no existe): " + inv.consultarPrecio("A999").orElse(-1));

        // Ajustar y actualizar stock
        inv.ajustarStock("A003", -3);
        inv.actualizarStock("A002", 20);
        inv.ajustarStock("A001", -10);

        // Listar faltantes
        System.out.println("Faltantes: " + inv.listarFaltantes());

        // Actualizar precio (opcional)
        inv.actualizarPrecio("A003", 19_900);

        inv.imprimirInventario();
    }
}
