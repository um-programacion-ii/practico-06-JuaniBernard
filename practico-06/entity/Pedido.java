package entity;

import java.util.HashMap;
import java.util.Map;

public class Pedido {
    private int id;
    private Map<Medicamento, Integer> medicamentos;
    private boolean estado;

    public Pedido(int id) {
        this.id = id;
        this.medicamentos = new HashMap<>();
        this.estado = false;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<Medicamento, Integer> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(Map<Medicamento, Integer> medicamentos) {
        this.medicamentos = medicamentos;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    // Método para gestionar los medicamentos del pedido
    public void agregarMedicamento(Medicamento medicamento, int cantidad) {
        medicamentos.put(medicamento, cantidad);
    }
}
