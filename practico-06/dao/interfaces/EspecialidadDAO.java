package dao.interfaces;

import entity.Especialidad;

import java.util.List;

public interface EspecialidadDAO {
    String agregarEspecialidad(Especialidad especialidad);
    Especialidad obtenerEspecialidad(String nombre);
    List<Especialidad> listarEspecialidades();
    String eliminarEspecialidad(String nombre);
    String actualizarEspecialidad(Especialidad especialidad);
}
