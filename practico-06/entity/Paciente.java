package entity;

public class Paciente {
    private String nombre;
    private int documento;
    private ObraSocial obraSocial;

    public Paciente(String nombre, int documento, ObraSocial obraSocial) {
        this.nombre = nombre;
        this.documento = documento;
        this.obraSocial = obraSocial;
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public ObraSocial getObraSocial() {
        return obraSocial;
    }

    public void setObraSocial(ObraSocial obraSocial) {
        this.obraSocial = obraSocial;
    }
}
