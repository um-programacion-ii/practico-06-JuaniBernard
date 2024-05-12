package dao.interfaces;

import entity.Paciente;

import java.util.List;

public interface PacienteDAO {
    String agregarPaciente(Paciente paciente);
    Paciente obtenerPaciente(int documento);
    List<Paciente> listarPacientes();
    String eliminarPaciente(int documento);
    String actualizarPaciente(Paciente paciente);
}
