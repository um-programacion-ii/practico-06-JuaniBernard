package dao.interfaces;

import entity.Medico;

import java.util.List;

public interface MedicoDAO {
    String agregarMedico(Medico medico);
    Medico obtenerMedico(int documento);
    List<Medico> listarMedicos();
    String eliminarMedico(int documento);
    String actualizarMedico(Medico medico);
}
