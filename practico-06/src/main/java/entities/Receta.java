package entities;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Receta {
    private int id;
    private List<Medicamento> medicamentos;
    private Paciente paciente;
    private Medico medico;
}
