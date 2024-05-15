package services;

import entities.Medicamento;
import entities.Receta;
import entities.Turno;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AtencionMedicoService {

    private static AtencionMedicoService instancia;
    private Contenedor contenedor;
    private Random random;

    private AtencionMedicoService() {
        contenedor = Contenedor.getInstancia();
        random = new Random();
    }

    public static AtencionMedicoService getInstancia() {
        if (instancia == null) {
            instancia = new AtencionMedicoService();
        }
        return instancia;
    }

    public String finalizarTurno(int idTurno) {
        Turno turno = contenedor.getTurnoDAO().obtenerTurno(idTurno);
        turno.setEstado(true);
        return contenedor.getTurnoDAO().verEstado(idTurno);
    }

    public Receta generarReceta(int idTurno) {
        Turno turno = contenedor.getTurnoDAO().obtenerTurno(idTurno);

        if (random.nextBoolean()) {
            List<Medicamento> medicamentos = new ArrayList<>();
            int cantidadMedicamentos = random.nextInt(3) + 1; // 1 a 4 medicamentos
            for (int i = 0; i < cantidadMedicamentos; i++) {
                medicamentos.add(obtenerMedicamentoAleatorio());
            }
            int idReceta = contenedor.getRecetaDAO().listarRecetas().size() + 1;
            return new Receta(idReceta, medicamentos, turno.getPaciente(), turno.getMedico());
        } else {
            return null;
        }
    }

    public Medicamento obtenerMedicamentoAleatorio() {
        List<Medicamento> medicamentos = contenedor.getMedicamentoDAO().listarMedicamentos();
        int indice = random.nextInt(medicamentos.size());
        return medicamentos.get(indice);
    }
}
