package daos.interfaces;

import entities.Receta;

import java.util.List;

public interface RecetaDAO {
    String agregarReceta(Receta receta);
    Receta obtenerReceta(int id);
    List<Receta> listarRecetas();
}
