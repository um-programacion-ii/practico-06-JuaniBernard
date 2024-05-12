package entity;

import java.util.HashMap;
import java.util.Map;

public class Drogueria {
    private Map<Medicamento, Integer> stock;

    public Drogueria() {
        this.stock = new HashMap<>();
    }
/*
    // Métodos para gestionar el stock
    public void agregarStock(Medicamento medicamento, int cantidad) {
        int cantidadActual = stock.getOrDefault(medicamento, 0);
        stock.put(medicamento, cantidadActual + cantidad);
    }

    public boolean hayStockSuficiente(Medicamento medicamento, int cantidad) {
        return stock.getOrDefault(medicamento, 0) >= cantidad;
    }

    public void reducirStock(Medicamento medicamento, int cantidad) {
        int cantidadActual = stock.getOrDefault(medicamento, 0);
        stock.put(medicamento, cantidadActual - cantidad);
    }*/
}
