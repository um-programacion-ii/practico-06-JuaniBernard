package entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
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
}
