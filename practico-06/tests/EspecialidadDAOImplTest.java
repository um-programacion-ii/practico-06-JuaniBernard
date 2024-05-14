package tests;

import entities.Especialidad;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.Contenedor;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EspecialidadDAOImplTest {

    private Contenedor contenedor;

    @BeforeEach
    void setUp() {
        contenedor = Contenedor.getInstancia();
    }

    @Test
    void agregarEspecialidad() {
        Especialidad especialidad = new Especialidad("Cardiología");
        String resultado = contenedor.getEspecialidadDAO().agregarEspecialidad(especialidad);
        assertEquals("Especialidad agregada con exito", resultado);
    }

    @Test
    void obtenerEspecialidad() {
        Especialidad especialidad = new Especialidad("Cardiología");
        contenedor.getEspecialidadDAO().agregarEspecialidad(especialidad);
        Especialidad especialidadObtenida = contenedor.getEspecialidadDAO().obtenerEspecialidad("Cardiología");
        assertEquals(especialidad, especialidadObtenida);
    }

    @Test
    void listarEspecialidades() {
        Especialidad especialidad1 = new Especialidad("Cardiología");
        Especialidad especialidad2 = new Especialidad("Traumatología");
        contenedor.getEspecialidadDAO().agregarEspecialidad(especialidad1);
        contenedor.getEspecialidadDAO().agregarEspecialidad(especialidad2);
        List<Especialidad> especialidades = contenedor.getEspecialidadDAO().listarEspecialidades();
        assertEquals(2, especialidades.size());
    }

    @Test
    void eliminarEspecialidad() {
        Especialidad especialidad = new Especialidad("Cardiología");
        contenedor.getEspecialidadDAO().agregarEspecialidad(especialidad);
        String resultado = contenedor.getEspecialidadDAO().eliminarEspecialidad("Cardiología");
        assertEquals("Especialidad eliminada con exito", resultado);
        assertNull(contenedor.getEspecialidadDAO().obtenerEspecialidad("Cardiología"));
    }

    @Test
    void actualizarEspecialidad() {
        Especialidad especialidad = new Especialidad("Cardiología");
        contenedor.getEspecialidadDAO().agregarEspecialidad(especialidad);
        especialidad.setNombre("Cardiología Intervencionista");
        String resultado = contenedor.getEspecialidadDAO().actualizarEspecialidad(especialidad);
        assertEquals("Especialidad actualizada con exito", resultado);
        Especialidad especialidadActualizada = contenedor.getEspecialidadDAO().obtenerEspecialidad("Cardiología Intervencionista");
        assertEquals("Cardiología Intervencionista", especialidadActualizada.getNombre());
    }
}
