package punto20.tarifasTramos;

import java.math.BigDecimal;

public class MainPeaje {

    public static void main(String[] args) {
        TarifasPeaje tarifas = new TarifasPeaje();
        //valores del peaje:
        tarifas.agregarTarifa(0, new BigDecimal("2500.00"));
        tarifas.agregarTarifa(1000, new BigDecimal("5800.00"));
        tarifas.agregarTarifa(2000, new BigDecimal("10700.00"));
        tarifas.agregarTarifa(3000, new BigDecimal("20000.00"));

        System.out.println("Tarifas definidas:");
        tarifas.imprimirTarifas();
        System.out.println();

        //pruebas
        int[] pesosDePrueba = {500, 1500, 2500, 3500, 100};

        for (int peso : pesosDePrueba) {
            BigDecimal tarifa = tarifas.obtenerTarifa(peso);
            System.out.println("Vehículo con " + peso + " kg -> Tarifa: " + tarifa + " Pesos");
        }
    }
}

