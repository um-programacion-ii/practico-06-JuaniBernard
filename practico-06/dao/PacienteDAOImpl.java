package dao;

import entity.Paciente;
import dao.interfaces.PacienteDAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PacienteDAOImpl implements PacienteDAO {
    private Map<Integer, Paciente> pacientes;

    public PacienteDAOImpl() {
        pacientes = new HashMap<>();
    }

    @Override
    public String agregarPaciente(Paciente paciente) {
        pacientes.put(paciente.getDocumento(), paciente);
        return "Paciente agregado con exito";
    }

    @Override
    public Paciente obtenerPaciente(int documento) {
        return pacientes.get(documento);
    }

    @Override
    public List<Paciente> listarPacientes() {
        return new ArrayList<>(pacientes.values());
    }

    @Override
    public String eliminarPaciente(int documento) {
        pacientes.remove(documento);
        return "Paciente eliminado con exito";
    }

    @Override
    public String actualizarPaciente(Paciente paciente) {
        pacientes.put(paciente.getDocumento(), paciente);
        return "Paciente actualizado con exito";
    }
}
