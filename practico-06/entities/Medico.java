package entities;

import java.util.ArrayList;
import java.util.List;

public class Medico {
    private String nombre;
    private int documento;
    private Especialidad especialidad;
    private List<ObraSocial> obraSociales;
    private boolean particular;

    public Medico(String nombre, int documento, Especialidad especialidad, boolean particular) {
        this.nombre = nombre;
        this.documento = documento;
        this.especialidad = especialidad;
        this.obraSociales = new ArrayList<>();
        this.particular = particular;
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

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public List<ObraSocial> getObraSociales() {
        return obraSociales;
    }

    public void setObraSociales(List<ObraSocial> obraSociales) {
        this.obraSociales = obraSociales;
    }

    public boolean isParticular() {
        return particular;
    }

    public void setParticular(boolean particular) {
        this.particular = particular;
    }
}
