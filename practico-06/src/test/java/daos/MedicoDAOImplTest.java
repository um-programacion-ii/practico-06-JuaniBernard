package daos;

import entities.Especialidad;
import entities.Medico;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.Contenedor;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MedicoDAOImplTest {

    private Contenedor contenedor;

    @BeforeEach
    void setUp() {
        contenedor = Contenedor.getInstancia();
    }

    @Test
    void agregarMedico() {
        Especialidad especialidad = new Especialidad("Cardiología");
        Medico medico = new Medico("Juan Perez", 12345678, especialidad, null, true);
        String resultado = contenedor.getMedicoDAO().agregarMedico(medico);
        assertEquals("Medico agregado con exito", resultado);
    }

    @Test
    void obtenerMedico() {
        Especialidad especialidad = new Especialidad("Cardiología");
        Medico medico = new Medico("Juan Perez", 12345678, especialidad, null, true);
        contenedor.getMedicoDAO().agregarMedico(medico);
        Medico medicoObtenido = contenedor.getMedicoDAO().obtenerMedico(12345678);
        assertEquals(medico, medicoObtenido);
    }

    @Test
    void listarMedicos() {
        Especialidad especialidad1 = new Especialidad("Cardiología");
        Especialidad especialidad2 = new Especialidad("Traumatología");
        Medico medico1 = new Medico("Juan Perez", 12345678, especialidad1, null, true);
        Medico medico2 = new Medico("Ana García", 87654321, especialidad2, null, false);
        contenedor.getMedicoDAO().agregarMedico(medico1);
        contenedor.getMedicoDAO().agregarMedico(medico2);
        List<Medico> medicos = contenedor.getMedicoDAO().listarMedicos();
        assertEquals(2, medicos.size());
    }

    @Test
    void eliminarMedico() {
        Especialidad especialidad = new Especialidad("Cardiología");
        Medico medico = new Medico("Juan Perez", 12345678, especialidad, null, true);
        contenedor.getMedicoDAO().agregarMedico(medico);
        String resultado = contenedor.getMedicoDAO().eliminarMedico(12345678);
        assertEquals("Medico eliminado con exito", resultado);
        assertNull(contenedor.getMedicoDAO().obtenerMedico(12345678));
    }

    @Test
    void actualizarMedico() {
        Especialidad especialidad = new Especialidad("Cardiología");
        Medico medico = new Medico("Juan Perez", 12345678, especialidad, null, true);
        contenedor.getMedicoDAO().agregarMedico(medico);
        medico.setNombre("Juan Pablo Perez");
        String resultado = contenedor.getMedicoDAO().actualizarMedico(medico);
        assertEquals("Medico actualizado con exito", resultado);
        Medico medicoActualizado = contenedor.getMedicoDAO().obtenerMedico(12345678);
        assertEquals("Juan Pablo Perez", medicoActualizado.getNombre());
    }

    @Test
    void limpiarDatos() {
        Especialidad especialidad = new Especialidad("Cardiología");
        Medico medico = new Medico("Juan Perez", 12345678, especialidad, null, true);
        contenedor.getMedicoDAO().agregarMedico(medico);
        assertFalse(contenedor.getMedicoDAO().listarMedicos().isEmpty());
        String resultado = contenedor.getMedicoDAO().limpiarDatos();
        assertEquals("Medicos eliminados con exito", resultado);
        assertTrue(contenedor.getMedicoDAO().listarMedicos().isEmpty());
    }
}
