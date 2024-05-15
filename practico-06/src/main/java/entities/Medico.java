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
public class Medico {
    private String nombre;
    private int documento;
    private Especialidad especialidad;
    private List<ObraSocial> obrasSociales;
    private boolean particular;
}
