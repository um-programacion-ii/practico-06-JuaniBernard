package entities;

public class Compra {
    private int id;
    private Paciente paciente;
    private Receta receta;
    private boolean estado;

    public Compra(int id, Paciente paciente, Receta receta) {
        this.id = id;
        this.paciente = paciente;
        this.receta = receta;
        this.estado = false;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
