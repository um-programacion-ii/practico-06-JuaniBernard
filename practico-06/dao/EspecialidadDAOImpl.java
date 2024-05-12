package dao;

import dao.interfaces.EspecialidadDAO;
import entity.Especialidad;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EspecialidadDAOImpl implements EspecialidadDAO {
    private Map<String, Especialidad> especialidades;

    public EspecialidadDAOImpl() {
        especialidades = new HashMap<>();
    }

    @Override
    public String agregarEspecialidad(Especialidad especialidad) {
        especialidades.put(especialidad.getNombre(), especialidad);
        return "Especialidad agregada con exito";
    }

    @Override
    public Especialidad obtenerEspecialidad(String nombre) {
        return especialidades.get(nombre);
    }

    @Override
    public List<Especialidad> listarEspecialidades() {
        return new ArrayList<>(especialidades.values());
    }

    @Override
    public String eliminarEspecialidad(String nombre) {
        especialidades.remove(nombre);
        return "Especialidad eliminada con exito";
    }

    @Override
    public String actualizarEspecialidad(Especialidad especialidad) {
        especialidades.put(especialidad.getNombre(), especialidad);
        return "Especialidad actualizada con exito";
    }
}
