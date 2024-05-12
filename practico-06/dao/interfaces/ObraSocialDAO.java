package dao.interfaces;

import entity.ObraSocial;

import java.util.List;

public interface ObraSocialDAO {
    String agregarObraSocial(ObraSocial obrasocial);
    ObraSocial obtenerObraSocial(String nombre);
    List<ObraSocial> listarObrasSociales();
    String eliminarObraSocial(String nombre);
    String actualizarObraSocial(ObraSocial obrasocial);
}
