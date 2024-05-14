package tests;

import entities.Especialidad;
import entities.Medico;
import entities.ObraSocial;
import entities.Paciente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.Contenedor;
import services.GestionTurnoService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GestionTurnoServiceTest {

    private GestionTurnoService gestionTurnoService;
    private Contenedor contenedor;

    @BeforeEach
    void setUp() {
        contenedor = Contenedor.getInstancia();
        gestionTurnoService = GestionTurnoService.getInstancia();

        // Agregar datos de prueba
        ObraSocial osde = new ObraSocial("OSDE");
        contenedor.getObraSocialDAO().agregarObraSocial(osde);
        ObraSocial swissMedical = new ObraSocial("Swiss Medical");
        contenedor.getObraSocialDAO().agregarObraSocial(swissMedical);
        Especialidad cardiologia = new Especialidad("Cardiología");
        contenedor.getEspecialidadDAO().agregarEspecialidad(cardiologia);
        Especialidad traumatologia = new Especialidad("Traumatología");
        contenedor.getEspecialidadDAO().agregarEspecialidad(traumatologia);

        // Crear médicos para OSDE
        Medico medico1 = new Medico("Juan Perez", 12345678, cardiologia, true);
        medico1.getObraSociales().add(osde);
        contenedor.getMedicoDAO().agregarMedico(medico1);
        Medico medico2 = new Medico("Maria Rodriguez", 22222222, traumatologia, false);
        medico2.getObraSociales().add(osde);
        contenedor.getMedicoDAO().agregarMedico(medico2);

        // Crear médicos para Swiss Medical
        Medico medico3 = new Medico("Pedro Gomez", 44444444, cardiologia, true);
        medico3.getObraSociales().add(swissMedical);
        contenedor.getMedicoDAO().agregarMedico(medico3);
        Medico medico4 = new Medico("Ana Garcia", 87654321, traumatologia, false);
        medico4.getObraSociales().add(swissMedical);
        contenedor.getMedicoDAO().agregarMedico(medico4);

        // Crear un paciente
        Paciente paciente = new Paciente("Luisa Lopez", 55555555, osde);
        contenedor.getPacienteDAO().agregarPaciente(paciente);
    }

    @Test
    void listarMedicosParticulares() {
        List<Medico> medicosParticulares = gestionTurnoService.listarMedicosParticulares();
        assertEquals(2, medicosParticulares.size());
        assertTrue(medicosParticulares.contains(contenedor.getMedicoDAO().obtenerMedico(12345678)));
        assertTrue(medicosParticulares.contains(contenedor.getMedicoDAO().obtenerMedico(44444444)));
    }

    @Test
    void listarMedicosPorEspecialidadYObraSocial() {
        List<Medico> medicos = gestionTurnoService.listarMedicosPorEspecialidadYObraSocial("Cardiología", "OSDE");
        assertEquals(1, medicos.size());
        assertTrue(medicos.contains(contenedor.getMedicoDAO().obtenerMedico(12345678)));
    }

    @Test
    void solicitarTurno() {
        Paciente paciente = contenedor.getPacienteDAO().obtenerPaciente(55555555);
        Medico medico = contenedor.getMedicoDAO().obtenerMedico(12345678);
        String resultado = gestionTurnoService.solicitarTurno(paciente, medico, true);
        assertEquals("Turno agregado con exito", resultado);
    }
}
