package punto20.tarifasTramos;

import java.math.BigDecimal;
import java.util.Map;
import java.util.TreeMap;

public class TarifasPeaje {

    private final TreeMap<Integer, BigDecimal> tarifasPorPeso;

    public TarifasPeaje() {
        tarifasPorPeso = new TreeMap<>();
    }

    public void agregarTarifa(int pesoMinimo, BigDecimal tarifa) {
        tarifasPorPeso.put(pesoMinimo, tarifa);
    }

    public BigDecimal obtenerTarifa(int pesoVehiculo) {
        Map.Entry<Integer, BigDecimal> entrada = tarifasPorPeso.floorEntry(pesoVehiculo);
        return (entrada != null) ? entrada.getValue() : null;
    }

    public void imprimirTarifas() {
        for (Map.Entry<Integer, BigDecimal> entry : tarifasPorPeso.entrySet()) {
            System.out.println("Desde " + entry.getKey() + " kg: " + entry.getValue() + " Pesos");
        }
    }
}

