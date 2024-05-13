package daos.interfaces;

import entities.Especialidad;

import java.util.List;

public interface EspecialidadDAO {
    String agregarEspecialidad(Especialidad especialidad);
    Especialidad obtenerEspecialidad(String nombre);
    List<Especialidad> listarEspecialidades();
    String eliminarEspecialidad(String nombre);
    String actualizarEspecialidad(Especialidad especialidad);
}
