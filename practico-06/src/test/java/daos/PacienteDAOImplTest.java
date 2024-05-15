package daos;

import entities.ObraSocial;
import entities.Paciente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.Contenedor;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PacienteDAOImplTest {

    private Contenedor contenedor;

    @BeforeEach
    void setUp() {
        contenedor = Contenedor.getInstancia();

        // Limpiar los DAOs del contenedor
        contenedor.getPacienteDAO().limpiarDatos();
    }

    @Test
    void agregarPaciente() {
        ObraSocial obraSocial = new ObraSocial("OSDE");
        Paciente paciente = new Paciente("Juan Perez", 12345678, obraSocial);
        String resultado = contenedor.getPacienteDAO().agregarPaciente(paciente);
        assertEquals("Paciente agregado con exito", resultado);
    }

    @Test
    void obtenerPaciente() {
        ObraSocial obraSocial = new ObraSocial("OSDE");
        Paciente paciente = new Paciente("Juan Perez", 12345678, obraSocial);
        contenedor.getPacienteDAO().agregarPaciente(paciente);
        Paciente pacienteObtenido = contenedor.getPacienteDAO().obtenerPaciente(12345678);
        assertEquals(paciente, pacienteObtenido);
    }

    @Test
    void listarPacientes() {
        ObraSocial obraSocial1 = new ObraSocial("OSDE");
        ObraSocial obraSocial2 = new ObraSocial("Swiss Medical");
        Paciente paciente1 = new Paciente("Juan Perez", 12345678, obraSocial1);
        Paciente paciente2 = new Paciente("Ana García", 87654321, obraSocial2);
        contenedor.getPacienteDAO().agregarPaciente(paciente1);
        contenedor.getPacienteDAO().agregarPaciente(paciente2);
        List<Paciente> pacientes = contenedor.getPacienteDAO().listarPacientes();
        assertEquals(2, pacientes.size());
    }

    @Test
    void eliminarPaciente() {
        ObraSocial obraSocial = new ObraSocial("OSDE");
        Paciente paciente = new Paciente("Juan Perez", 12345678, obraSocial);
        contenedor.getPacienteDAO().agregarPaciente(paciente);
        String resultado = contenedor.getPacienteDAO().eliminarPaciente(12345678);
        assertEquals("Paciente eliminado con exito", resultado);
        assertNull(contenedor.getPacienteDAO().obtenerPaciente(12345678));
    }

    @Test
    void actualizarPaciente() {
        ObraSocial obraSocial = new ObraSocial("OSDE");
        Paciente paciente = new Paciente("Juan Perez", 12345678, obraSocial);
        contenedor.getPacienteDAO().agregarPaciente(paciente);
        paciente.setNombre("Juan Pablo Perez");
        String resultado = contenedor.getPacienteDAO().actualizarPaciente(paciente);
        assertEquals("Paciente actualizado con exito", resultado);
        Paciente pacienteActualizado = contenedor.getPacienteDAO().obtenerPaciente(12345678);
        assertEquals("Juan Pablo Perez", pacienteActualizado.getNombre());
    }

    @Test
    void limpiarDatos() {
        ObraSocial obraSocial = new ObraSocial("OSDE");
        Paciente paciente = new Paciente("Juan Perez", 12345678, obraSocial);
        contenedor.getPacienteDAO().agregarPaciente(paciente);
        assertFalse(contenedor.getPacienteDAO().listarPacientes().isEmpty());
        String resultado = contenedor.getPacienteDAO().limpiarDatos();
        assertEquals("Pacientes eliminados con exito", resultado);
        assertTrue(contenedor.getPacienteDAO().listarPacientes().isEmpty());
    }
}
