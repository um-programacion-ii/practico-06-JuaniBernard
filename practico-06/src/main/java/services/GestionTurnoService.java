package services;

import entities.Medico;
import entities.Paciente;
import entities.Turno;

import java.util.List;
import java.util.stream.Collectors;

public class GestionTurnoService {

    private static GestionTurnoService instancia;
    private Contenedor contenedor;

    private GestionTurnoService() {
        contenedor = Contenedor.getInstancia();
    }

    public static GestionTurnoService getInstancia() {
        if (instancia == null) {
            instancia = new GestionTurnoService();
        }
        return instancia;
    }

    public List<Medico> listarMedicosParticulares() {
        return contenedor.getMedicoDAO().listarMedicos().stream()
                .filter(Medico::isParticular)
                .collect(Collectors.toList());
    }

    public List<Medico> listarMedicosPorEspecialidadYObraSocial(String especialidad, String obraSocial) {
        return contenedor.getMedicoDAO().listarMedicos().stream()
                .filter(medico -> medico.getEspecialidad().getNombre().equals(especialidad) &&
                        medico.getObraSociales().stream()
                                .anyMatch(os -> os.getNombre().equals(obraSocial)))
                .collect(Collectors.toList());
    }

    public String solicitarTurno(Paciente paciente, Medico medico, boolean conObraSocial) {
        int id = contenedor.getTurnoDAO().listarTurnos().size() + 1;
        Turno turno = new Turno(id, paciente, medico, conObraSocial);
        return contenedor.getTurnoDAO().agregarTurno(turno);
    }
}
