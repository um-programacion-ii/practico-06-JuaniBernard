package entity;

import java.util.List;

public class Receta {
    private int id;
    private List<Medicamento> medicamentos;
    private Paciente paciente;
    private Medico medico;

    public Receta(int id, List<Medicamento> medicamentos, Paciente paciente, Medico medico) {
        this.id = id;
        this.medicamentos = medicamentos;
        this.paciente = paciente;
        this.medico = medico;
    }

    // Getter y setter
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

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public List<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }
}
