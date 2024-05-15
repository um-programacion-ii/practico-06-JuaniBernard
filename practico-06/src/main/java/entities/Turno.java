package entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
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
}
