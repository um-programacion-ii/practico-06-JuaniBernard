package dao;

import dao.interfaces.RecetaDAO;
import entity.Receta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecetaDAOImpl implements RecetaDAO {
    private Map<Integer, Receta> recetas;

    public RecetaDAOImpl() {
        recetas = new HashMap<>();
    }

    @Override
    public String agregarReceta(Receta receta) {
        recetas.put(receta.getId(), receta);
        return "Receta agregada con exito";
    }

    @Override
    public Receta obtenerReceta(int id) {
        return recetas.get(id);
    }

    @Override
    public List<Receta> listarRecetas() {
        return new ArrayList<>(recetas.values());
    }
}
