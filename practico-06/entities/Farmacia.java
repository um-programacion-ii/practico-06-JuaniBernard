package entities;

import java.util.HashMap;
import java.util.Map;

public class Farmacia {
    private Map<Medicamento, Integer> stock;

    public Farmacia() {
        this.stock = new HashMap<>();
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
