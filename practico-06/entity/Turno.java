package entity;

public class Turno {
    private int id;
    private boolean estado;
    private Paciente paciente;
    private Medico medico;
    private boolean conObraSocial;

    public Turno(int id, Paciente paciente, Medico medico, boolean conObraSocial) {
        this.id = id;
        this.estado = false;
        this.paciente = paciente;
        this.medico = medico;
        this.conObraSocial = conObraSocial;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public boolean getConObraSocial() {
        return conObraSocial;
    }

    public void setConObraSocial(boolean conObraSocial) {
        this.conObraSocial = conObraSocial;
    }
}
