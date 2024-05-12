package dao;

import dao.interfaces.TurnoDAO;
import entity.Turno;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TurnoDAOImpl implements TurnoDAO {
    private Map<Integer, Turno> turnos;

    public TurnoDAOImpl() {
        turnos = new HashMap<>();
    }

    @Override
    public String agregarTurno(Turno turno) {
        turnos.put(turno.getId(), turno);
        return "Turno agregado con exito";
    }

    @Override
    public Turno obtenerTurno(int id) {
        return turnos.get(id);
    }

    @Override
    public List<Turno> listarTurnos() {
        return new ArrayList<>(turnos.values());
    }

    @Override
    public String verEstado(int id) {
        Turno turno = turnos.get(id);
        boolean estado = turno.getEstado();
        String result = null;
        if (estado) {
            result = "Turno finalizado";
        }
        else {
            result = "Turno en proceso";
        }
        return result;
    }
}
