package entity;

public class Medicamento {
    private int id;
    private String nombre;

    public Medicamento(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // Getter y setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
