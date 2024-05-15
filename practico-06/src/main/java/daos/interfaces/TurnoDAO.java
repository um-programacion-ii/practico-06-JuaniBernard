package daos.interfaces;

import entities.Turno;

import java.util.List;

public interface TurnoDAO {
    String agregarTurno(Turno turno);
    Turno obtenerTurno(int id);
    List<Turno> listarTurnos();
    String verEstado(int id);
}
