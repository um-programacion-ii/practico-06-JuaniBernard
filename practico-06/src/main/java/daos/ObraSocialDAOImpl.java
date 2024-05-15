package daos;

import entities.ObraSocial;
import daos.interfaces.ObraSocialDAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ObraSocialDAOImpl implements ObraSocialDAO {
    private Map<String, ObraSocial> obrasSociales;

    public ObraSocialDAOImpl() {
        obrasSociales = new HashMap<>();
    }

    @Override
    public String agregarObraSocial(ObraSocial obrasocial) {
        obrasSociales.put(obrasocial.getNombre(), obrasocial);
        return "Obra Social agregada con exito";
    }

    @Override
    public ObraSocial obtenerObraSocial(String nombre) {
        return obrasSociales.get(nombre);
    }

    @Override
    public List<ObraSocial> listarObrasSociales() {
        return new ArrayList<>(obrasSociales.values());
    }

    @Override
    public String eliminarObraSocial(String nombre) {
        obrasSociales.remove(nombre);
        return "Obra Social eliminada con exito";
    }

    @Override
    public String actualizarObraSocial(ObraSocial obrasocial) {
        obrasSociales.put(obrasocial.getNombre(), obrasocial);
        return "Obra Social actualizada con exito";
    }
}
