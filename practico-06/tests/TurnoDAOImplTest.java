package tests;

import entities.Medico;
import entities.Paciente;
import entities.Turno;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.Contenedor;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TurnoDAOImplTest {

    private Contenedor contenedor;

    @BeforeEach
    void setUp() {
        contenedor = Contenedor.getInstancia();
    }

    @Test
    void agregarTurno() {
        Paciente paciente = new Paciente("Juan Perez", 12345678, null);
        Medico medico = new Medico("Ana García", 87654321, null, true);
        Turno turno = new Turno(1, paciente, medico, true);
        String resultado = contenedor.getTurnoDAO().agregarTurno(turno);
        assertEquals("Turno agregado con exito", resultado);
    }

    @Test
    void obtenerTurno() {
        Paciente paciente = new Paciente("Juan Perez", 12345678, null);
        Medico medico = new Medico("Ana García", 87654321, null, true);
        Turno turno = new Turno(1, paciente, medico, true);
        contenedor.getTurnoDAO().agregarTurno(turno);
        Turno turnoObtenido = contenedor.getTurnoDAO().obtenerTurno(1);
        assertEquals(turno, turnoObtenido);
    }

    @Test
    void listarTurnos() {
        Paciente paciente = new Paciente("Juan Perez", 12345678, null);
        Medico medico = new Medico("Ana García", 87654321, null, true);
        Turno turno1 = new Turno(1, paciente, medico, true);
        Turno turno2 = new Turno(2, paciente, medico, false);
        contenedor.getTurnoDAO().agregarTurno(turno1);
        contenedor.getTurnoDAO().agregarTurno(turno2);
        List<Turno> turnos = contenedor.getTurnoDAO().listarTurnos();
        assertEquals(2, turnos.size());
    }

    @Test
    void verEstado() {
        Paciente paciente = new Paciente("Juan Perez", 12345678, null);
        Medico medico = new Medico("Ana García", 87654321, null, true);
        Turno turno = new Turno(1, paciente, medico, true);
        contenedor.getTurnoDAO().agregarTurno(turno);
        String estado = contenedor.getTurnoDAO().verEstado(1);
        assertEquals("Turno en proceso", estado);
        turno.setEstado(true);
        estado = contenedor.getTurnoDAO().verEstado(1);
        assertEquals("Turno finalizado", estado);
    }
}
