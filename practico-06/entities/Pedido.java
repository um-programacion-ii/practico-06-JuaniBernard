package entities;

public class Pedido {
    private int id;
    private Medicamento medicamento;
    private int cantidad;
    private boolean estado;

    public Pedido(int id, Medicamento medicamento, int cantidad) {
        this.id = id;
        this.medicamento = medicamento;
        this.cantidad = cantidad;
        this.estado = false;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
