package daos;

import entities.ObraSocial;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.Contenedor;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ObraSocialDAOImplTest {

    private Contenedor contenedor;

    @BeforeEach
    void setUp() {
        contenedor = Contenedor.getInstancia();
    }

    @Test
    void agregarObraSocial() {
        ObraSocial obraSocial = new ObraSocial("OSDE");
        String resultado = contenedor.getObraSocialDAO().agregarObraSocial(obraSocial);
        assertEquals("Obra Social agregada con exito", resultado);
    }

    @Test
    void obtenerObraSocial() {
        ObraSocial obraSocial = new ObraSocial("OSDE");
        contenedor.getObraSocialDAO().agregarObraSocial(obraSocial);
        ObraSocial obraSocialObtenida = contenedor.getObraSocialDAO().obtenerObraSocial("OSDE");
        assertEquals(obraSocial, obraSocialObtenida);
    }

    @Test
    void listarObrasSociales() {
        ObraSocial obraSocial1 = new ObraSocial("OSDE");
        ObraSocial obraSocial2 = new ObraSocial("Swiss Medical");
        contenedor.getObraSocialDAO().agregarObraSocial(obraSocial1);
        contenedor.getObraSocialDAO().agregarObraSocial(obraSocial2);
        List<ObraSocial> obrasSociales = contenedor.getObraSocialDAO().listarObrasSociales();
        assertEquals(2, obrasSociales.size());
    }

    @Test
    void eliminarObraSocial() {
        ObraSocial obraSocial = new ObraSocial("OSDE");
        contenedor.getObraSocialDAO().agregarObraSocial(obraSocial);
        String resultado = contenedor.getObraSocialDAO().eliminarObraSocial("OSDE");
        assertEquals("Obra Social eliminada con exito", resultado);
        assertNull(contenedor.getObraSocialDAO().obtenerObraSocial("OSDE"));
    }

    @Test
    void actualizarObraSocial() {
        ObraSocial obraSocial = new ObraSocial("OSDE");
        contenedor.getObraSocialDAO().agregarObraSocial(obraSocial);
        obraSocial.setNombre("OSDE 210");
        String resultado = contenedor.getObraSocialDAO().actualizarObraSocial(obraSocial);
        assertEquals("Obra Social actualizada con exito", resultado);
        ObraSocial obraSocialActualizada = contenedor.getObraSocialDAO().obtenerObraSocial("OSDE 210");
        assertEquals("OSDE 210", obraSocialActualizada.getNombre());
    }
}
