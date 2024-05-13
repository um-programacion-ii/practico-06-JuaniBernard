package daos;

import entities.Medico;
import daos.interfaces.MedicoDAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MedicoDAOImpl implements MedicoDAO {
    private Map<Integer, Medico> medicos;

    public MedicoDAOImpl() {
        medicos = new HashMap<>();
    }

    @Override
    public String agregarMedico(Medico medico) {
        medicos.put(medico.getDocumento(), medico);
        return "Medico agregado con exito";
    }

    @Override
    public Medico obtenerMedico(int documento) {
        return medicos.get(documento);
    }

    @Override
    public List<Medico> listarMedicos() {
        return new ArrayList<>(medicos.values());
    }

    @Override
    public String eliminarMedico(int documento) {
        medicos.remove(documento);
        return "Medico eliminado con exito";
    }

    @Override
    public String actualizarMedico(Medico medico) {
        medicos.put(medico.getDocumento(), medico);
        return "Medico actualizado con exito";
    }
}
