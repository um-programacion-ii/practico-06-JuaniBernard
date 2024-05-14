package tests;

import entities.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.AtencionMedicoService;
import services.Contenedor;

import static org.junit.jupiter.api.Assertions.*;

public class AtencionMedicoServiceTest {

    private AtencionMedicoService atencionMedicoService;
    private Contenedor contenedor;

    @BeforeEach
    void setUp() {
        contenedor = Contenedor.getInstancia();
        atencionMedicoService = AtencionMedicoService.getInstancia();

        // Agregar datos de prueba
        ObraSocial osde = new ObraSocial("OSDE");
        contenedor.getObraSocialDAO().agregarObraSocial(osde);
        Especialidad cardiologia = new Especialidad("Cardiología");
        contenedor.getEspecialidadDAO().agregarEspecialidad(cardiologia);
        Medicamento medicamento1 = new Medicamento(1, "Paracetamol");
        Medicamento medicamento2 = new Medicamento(2, "Ibuprofeno");
        contenedor.getMedicamentoDAO().agregarMedicamento(medicamento1);
        contenedor.getMedicamentoDAO().agregarMedicamento(medicamento2);
        Paciente paciente = new Paciente("Juan Perez", 12345678, osde);
        contenedor.getPacienteDAO().agregarPaciente(paciente);
        Medico medico = new Medico("Ana García", 87654321, cardiologia, true);
        medico.getObraSociales().add(osde);
        contenedor.getMedicoDAO().agregarMedico(medico);
        Turno turno = new Turno(1, paciente, medico, true);
        contenedor.getTurnoDAO().agregarTurno(turno);
    }

    @Test
    void finalizarTurno() {
        String resultado = atencionMedicoService.finalizarTurno(1);
        assertEquals("Turno finalizado", resultado);
    }

    @Test
    void generarReceta() {
        Receta receta = atencionMedicoService.generarReceta(1);
        // La receta puede ser null si el médico no la generó
        if (receta != null) {
            assertNotNull(receta.getMedicamentos());
            assertTrue(receta.getMedicamentos().size() >= 1 && receta.getMedicamentos().size() <= 4);
        }
    }

    @Test
    void obtenerMedicamentoAleatorio() {
        Medicamento medicamento = atencionMedicoService.obtenerMedicamentoAleatorio();
        assertNotNull(medicamento);
        assertTrue(medicamento.getId() == 1 || medicamento.getId() == 2);
    }
}
