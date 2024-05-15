package daos.interfaces;

import entities.Medicamento;

import java.util.List;

public interface MedicamentoDAO {
    String agregarMedicamento(Medicamento medicamento);
    Medicamento obtenerMedicamento(int id);
    List<Medicamento> listarMedicamentos();
    String eliminarMedicamento(int id);
    String actualizarMedicamento(Medicamento medicamento);
}
