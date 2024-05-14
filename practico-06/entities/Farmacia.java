package entities;

import java.util.HashMap;
import java.util.Map;

public class Farmacia {
    private Map<Medicamento, Integer> stock;

    private static Farmacia instancia;

    private Farmacia() {
        this.stock = new HashMap<>();
    }

    public static Farmacia getInstancia() {
        if (instancia == null) {
            instancia = new Farmacia();
        }
        return instancia;
    }

    public Map<Medicamento, Integer> getStock() {
        return stock;
    }

    // Métodos para gestionar el stock
    public void agregarStock(Medicamento medicamento, int cantidad) {
        int cantidadActual = stock.getOrDefault(medicamento, 0);
        stock.put(medicamento, cantidadActual + cantidad);
    }

    public boolean hayStockSuficiente(Medicamento medicamento) {
        return stock.getOrDefault(medicamento, 0) >= 1;
    }

    public void reducirStock(Medicamento medicamento) {
        int cantidadActual = stock.getOrDefault(medicamento, 0);
        stock.put(medicamento, cantidadActual - 1);
    }
}
